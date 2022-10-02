package com.kodtodya.practice.ximpl;

// Look up authorities, resourceIds and scopes based on clientId
import com.kodtodya.practice.token.generator.process.config.JwtTokenUtil;
import com.kodtodya.practice.token.generator.process.model.JwtRequest;
import com.kodtodya.practice.token.generator.process.model.JwtResponse;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

@Configuration
@EnableScheduling
public class AutoProcess {
    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private DefaultTokenServices tokenServices;

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private RestTemplate restTemplate = new RestTemplate();

    @Scheduled(fixedDelay = 10000)
    private void testService() {
        // Default values for other parameters
        Map<String, String> requestParameters = Collections.emptyMap();
        boolean approved = true;
        String redirectUrl = null;
        Set<String> responseTypes = Collections.emptySet();
        Map<String, Serializable> extensionProperties = Collections.emptyMap();

        ClientDetails client = clientDetailsService.loadClientByClientId("app");
        Collection<GrantedAuthority> authorities = client.getAuthorities();
        Set<String> resourceIds = client.getResourceIds();
        Set<String> scopes = client.getScope();
        // Create request
        OAuth2Request oAuth2Request = new OAuth2Request(requestParameters, "app", authorities, approved, scopes,
                resourceIds, redirectUrl, responseTypes, extensionProperties);

        // Create OAuth2AccessToken
        User userPrincipal = new User("avadhut", "", true, true, true, true, authorities);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userPrincipal, null, authorities);
        OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request, authenticationToken);

        OAuth2AccessToken existingToken = tokenStore.getAccessToken(oAuth2Authentication);
        if (existingToken == null) {
            OAuth2AccessToken oAuth2AccessToken = this.pollTokenFromServer();
            //new DefaultOAuth2AccessToken(existingToken.getValue());
            tokenStore.storeAccessToken(oAuth2AccessToken, oAuth2Authentication);
            System.out.println("First time token generated and stored to in-memory-store");
        }
        if (null != existingToken) {
            try {
                jwtTokenUtil.getUsernameFromToken(existingToken.getValue());
            } catch (IllegalArgumentException e) {
                System.out.println("Unable to get JWT Token");
            } catch (ExpiredJwtException e) {
                System.out.println("---------- Existing JWT Token has expired ---------------");
                tokenStore.removeAccessToken(existingToken);
                System.out.println("---------- Existing JWT Token has removed from in-memory-store ---------------");
                tokenStore.storeAccessToken(this.pollTokenFromServer(), oAuth2Authentication);
                System.out.println("---------- New JWT Token has added to in-memory-store ---------------");
            }
        }

        String balanceUrl = "http://localhost:8080/balance";
        HttpHeaders hdrs = new HttpHeaders();
        hdrs.add("Authorization", "Bearer " + fetchTokenFromStore());

        HttpEntity<String> req = new HttpEntity<String>(hdrs);
        ResponseEntity<String> balanceMessage = restTemplate.exchange(balanceUrl, HttpMethod.POST, req, String.class);

        System.out.println("Message: " + balanceMessage.getBody());
    }

    private OAuth2AccessToken pollTokenFromServer() {
        String authenticateUrl = "http://localhost:8080/authenticate";
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<JwtRequest> request = new HttpEntity<>(new JwtRequest("javainuse", "password"), headers);
        System.out.println("---------- Polling new JWT Token from Server ---------------");
        ResponseEntity<JwtResponse> authResponse = restTemplate.postForEntity(authenticateUrl, request, JwtResponse.class);
        System.out.println("---------- Polled new JWT Token from server ---------------");

        String strToken = authResponse.getBody().getToken();
        System.out.println("token -> " + strToken);
        return new DefaultOAuth2AccessToken(strToken);
    }

    public String fetchTokenFromStore() {
        Collection<OAuth2AccessToken> tokenCollection = tokenStore.findTokensByClientIdAndUserName("app", "avadhut");
        System.out.println("Current in-memory-store:tokenCollection.size() -> " + tokenCollection.size());
        OAuth2AccessToken oAuthAccessToken = tokenCollection.iterator().next();
        OAuth2Authentication oAuth = tokenStore.readAuthentication(oAuthAccessToken);
        OAuth2AccessToken newToken = tokenStore.getAccessToken(oAuth);
        tokenStore.removeAccessToken(oAuthAccessToken);
        tokenStore.storeAccessToken(newToken, oAuth);
        return newToken.getValue();
    }
}

package com.kodtodya.practice.demo.config;

import com.kodtodya.practice.demo.feature.AreYouOkayFeatures;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.togglz.core.Feature;
import org.togglz.core.manager.EnumBasedFeatureProvider;
import org.togglz.core.manager.TogglzConfig;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.mem.InMemoryStateRepository;
import org.togglz.core.spi.FeatureProvider;
import org.togglz.core.user.UserProvider;
import org.togglz.spring.security.SpringSecurityUserProvider;

@Configuration
public class ToggleConfiguration implements TogglzConfig {

    public Class<? extends Feature> getFeatureClass() {
        return AreYouOkayFeatures.class;
    }

    public StateRepository getStateRepository() {
        return new InMemoryStateRepository();
    }

    @Override
    public UserProvider getUserProvider() {
        return new SpringSecurityUserProvider("admin");
    }

    @Bean
    public FeatureProvider featureProvider() {
        return new EnumBasedFeatureProvider(AreYouOkayFeatures.class);
    }
}
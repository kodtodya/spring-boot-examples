package practice.kodtodya.restful.boot.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WelcomeService {

	@Value("${welcome.message}")
	private String welcomeMessage;

	public String retrieveWelcomeMessage() {
		//Complex Method
		return welcomeMessage;
	}
}
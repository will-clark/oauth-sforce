package org.willclark.oauthsforce;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2SsoDefaultConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableOAuth2Sso
public class CustomConfig extends OAuth2SsoDefaultConfiguration {

	public CustomConfig(ApplicationContext applicationContext) {
		super(applicationContext);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable();
		super.configure(http);
	}

}

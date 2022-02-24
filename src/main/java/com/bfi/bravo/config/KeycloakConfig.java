package com.bfi.bravo.config;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class KeycloakConfig {

  @Bean
  public KeycloakSpringBootConfigResolver keycloakSpringBootConfigResolver() {
    return new KeycloakSpringBootConfigResolver();
  }
}

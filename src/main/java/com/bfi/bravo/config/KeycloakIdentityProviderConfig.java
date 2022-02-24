package com.bfi.bravo.config;

import org.camunda.bpm.extension.keycloak.plugin.KeycloakIdentityProviderPlugin;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "plugin.identity.keycloak")
public class KeycloakIdentityProviderConfig extends KeycloakIdentityProviderPlugin {}

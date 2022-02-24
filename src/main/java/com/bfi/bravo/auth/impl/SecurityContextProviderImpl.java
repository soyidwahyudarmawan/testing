package com.bfi.bravo.auth.impl;

import com.bfi.bravo.auth.SecurityContextProvider;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.RefreshableKeycloakSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityContextProviderImpl implements SecurityContextProvider {

  @Override
  public String getCurrentUserEmail() {
    return getSecurityContext().getToken().getEmail();
  }

  @SuppressWarnings("unchecked")
  private RefreshableKeycloakSecurityContext getSecurityContext() {
    return (
      (KeycloakPrincipal<RefreshableKeycloakSecurityContext>) SecurityContextHolder
        .getContext()
        .getAuthentication()
        .getPrincipal()
    ).getKeycloakSecurityContext();
  }
}

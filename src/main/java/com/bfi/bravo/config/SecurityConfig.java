package com.bfi.bravo.config;

import com.bfi.bravo.constant.SecurityConstants.Grants;
import javax.servlet.http.HttpServletResponse;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.keycloak.adapters.springsecurity.management.HttpSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

// Using keycloak as the base class for setup
@KeycloakConfiguration
public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

  @Value("${setting.service.internal.key}")
  private String internalServiceSecret;

  @Value("${setting.service.internal.name}")
  private String internalServiceName;

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) {
    SimpleAuthorityMapper simpleAuthorityMapper = new SimpleAuthorityMapper();
    simpleAuthorityMapper.setPrefix("ROLE_"); // Default Spring Role marker ....

    KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();

    keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(simpleAuthorityMapper);
    authenticationManagerBuilder.authenticationProvider(keycloakAuthenticationProvider);
  }

  @Bean
  @Override
  protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
    return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
  }

  @Bean
  @Override
  @ConditionalOnMissingBean(HttpSessionManager.class)
  protected HttpSessionManager httpSessionManager() {
    return new HttpSessionManager();
  }

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    super.configure(httpSecurity); // Setup keycloak from super class

    // Setup security config
    httpSecurity
      .csrf()
      .disable()
      .cors()
      .and()
      // make sure we use stateless session; session won't be used to store user's
      // state.
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and()
      // handle an authorized attempts (if we happen to have any other custom
      // response)
      .exceptionHandling()
      .authenticationEntryPoint((request, response, authError) ->
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED)
      )
      .and()
      // API Authorization with secret filter (Internal)
      .addFilterAfter(
        // This is where we hook our INTERNAL auth filter
        new InternalAuthenticationFilter(internalServiceName, internalServiceSecret),
        AnonymousAuthenticationFilter.class
      )
      .authorizeRequests()
      // Enabled swagger end points
      .antMatchers("/api-docs", "/api-docs/**", "/swagger*/**", "/webjars/**", "/actuator/**")
      .permitAll()
      // Enabled camunda web end points
      .antMatchers("/camunda**", "/camunda/**")
      .permitAll()
      // All others for basic user
      .antMatchers("/**")
      .hasAnyAuthority(Grants.ROLE_SYSTEM_SERVICE.toString(), Grants.ROLE_BASIC.toString())
      .anyRequest()
      .authenticated();
  }
}

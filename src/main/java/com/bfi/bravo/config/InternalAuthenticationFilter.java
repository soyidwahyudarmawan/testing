package com.bfi.bravo.config;

import com.bfi.bravo.constant.SecurityConstants;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.intercept.RunAsUserToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class InternalAuthenticationFilter extends OncePerRequestFilter {

  private final String internalServiceName;
  private final String internalServiceSecret;

  public InternalAuthenticationFilter(String internalServiceName, String internalServiceSecret) {
    this.internalServiceName = internalServiceName;
    this.internalServiceSecret = internalServiceSecret;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
    throws ServletException, IOException {
    // Extract header value
    String apiSecretHeader = request.getHeader(SecurityConstants.API_SECRET_HEADER_KEY);

    // If we have api header and it matches value, then set user principal to SYSTEM SERVICE
    if (StringUtils.hasText(apiSecretHeader) && apiSecretHeader.equals(internalServiceSecret)) {
      SecurityContextHolder
        .getContext()
        .setAuthentication(
          new RunAsUserToken(
            apiSecretHeader,
            internalServiceName,
            internalServiceName,
            Arrays.asList(new SimpleGrantedAuthority(SecurityConstants.Grants.ROLE_SYSTEM_SERVICE.toString())),
            null
          )
        );
    }

    filterChain.doFilter(request, response);
  }
}

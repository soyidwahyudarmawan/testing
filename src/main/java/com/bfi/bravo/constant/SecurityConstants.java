package com.bfi.bravo.constant;

public abstract class SecurityConstants {

  public static final String API_SECRET_HEADER_KEY = "api-secret";

  public static enum Grants {
    ROLE_BASIC,
    ROLE_SURVEYOR,
    ROLE_CREDIT_ANALYST,
    ROLE_SYSTEM_SERVICE,
  }
}

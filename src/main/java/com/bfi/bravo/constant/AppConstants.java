package com.bfi.bravo.constant;

public class AppConstants {

  private AppConstants() {}

  //DEFAULT ACCESS ROLE
  public static final String DEFAULT_ACCESS_ROLE = "hasRole('ROLE_SYSTEM_SERVICE') or hasRole('ROLE_BASIC')";

  //DATE FORMAT
  public static final String DATE_FORMAT_DATE_1 = "dd MMM yyyy";
  public static final String DATE_FORMAT_DATE_2 = "dd MMM yyyy hh:mm";
}

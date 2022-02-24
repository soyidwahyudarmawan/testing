package com.bfi.bravo.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public final class DateUtil {

  public static String formatDatetime(LocalDateTime dateTime, String format) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
    return dateTime.format(formatter);
  }

  public static String formatDate(LocalDate date, String format) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
    return date.format(formatter);
  }

  public static String getUnixTimestamp() {
    Date date = new Date();
    return String.valueOf(date.getTime());
  }
}

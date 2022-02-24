package com.bfi.bravo.constant;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class ApplicationConstants {

  public static enum ApplicationStatus {
    SUBMITTED("SUBMITTED"),
    APPROVED("APPROVED"),
    ACCEPTED("ACCEPTED"),
    REJECTED("REJECTED"),
    SURVEY_ASSIGNED("SURVEY_ASSIGNED"),
    SURVEY_COMPLETE("SURVEY_COMPLETE"),
    SURVEY_FAIL("SURVEY_FAIL"),
    DOCUMENT_PICKED("DOCUMENT_PICKED"),
    DOCUMENT_MISSING("DOCUMENT_MISSING"),
    CANCEL("CANCEL"),
    GOLIVE("GOLIVE");

    private String label;

    ApplicationStatus(String label) {
      this.label = label;
    }

    private static final Map<String, ApplicationStatus> stringToEnum = Stream
      .of(values())
      .collect(Collectors.toMap(Object::toString, e -> e));

    public static Optional<ApplicationStatus> fromString(String label) {
      return Optional.ofNullable(stringToEnum.get(label.toUpperCase()));
    }
  }
}

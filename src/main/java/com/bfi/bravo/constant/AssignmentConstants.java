package com.bfi.bravo.constant;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AssignmentConstants
{
  public static enum DataEnrichmentStatus
  {
    NA("NA"),
    DONE("Done"),
    ONGOING("Ongoing"),
    NOTIFICATION("Notification");

    private String label;

    DataEnrichmentStatus(String label) {
      this.label = label;
    }

    private static final Map<String, AssignmentConstants.DataEnrichmentStatus> stringToEnum = Stream
      .of(values())
      .collect(Collectors.toMap(Object::toString, e -> e));

    public static Optional<AssignmentConstants.DataEnrichmentStatus> fromString(String label) {
      return Optional.ofNullable(stringToEnum.get(label.toUpperCase()));
    }
  }
  public static enum RequestGoLiveStatus
  {
    NA("NA"),
    DONE("Done"),
    ONGOING("Ongoing"),
    NOTIFICATION("Notification");

    private String label;

    RequestGoLiveStatus(String label) {
      this.label = label;
    }

    private static final Map<String, AssignmentConstants.RequestGoLiveStatus> stringToEnum = Stream
      .of(values())
      .collect(Collectors.toMap(Object::toString, e -> e));

    public static Optional<AssignmentConstants.RequestGoLiveStatus> fromString(String label) {
      return Optional.ofNullable(stringToEnum.get(label.toUpperCase()));
    }
  }
}

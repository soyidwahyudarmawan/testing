package com.bfi.bravo.dto.notification.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorNotificationCountUnreadResponse {

  @JsonProperty("count_unread_notification")
  private long countUnreadNotification;
}

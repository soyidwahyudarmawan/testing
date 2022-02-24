package com.bfi.bravo.dto.notification.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorNotificationCreateResponse {

  @JsonProperty("surveyor_notification_id")
  private Long surveyorNotificationId;
}

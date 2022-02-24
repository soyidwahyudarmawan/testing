package com.bfi.bravo.dto.notification.response;

import com.bfi.bravo.constant.NotificationConstants.ReadStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorNotificationReadStatusUpdateResponse {

  @JsonProperty("surveyor_notification_id")
  private Long surveyorNotificationId;

  @JsonProperty("read_status")
  private ReadStatus readStatus;
}

package com.bfi.bravo.dto.notification.response;

import com.bfi.bravo.constant.NotificationConstants.NotificationStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorNotificationStatusUpdateResponse {

  @JsonProperty("surveyor_notification_id")
  private Long surveyorNotificationId;

  @JsonProperty("notification_status")
  private NotificationStatus notificationStatus;
}

package com.bfi.bravo.dto.notification.response;

import com.bfi.bravo.constant.NotificationConstants.ActionType;
import com.bfi.bravo.constant.NotificationConstants.NotificationStatus;
import com.bfi.bravo.constant.NotificationConstants.ReadStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorNotificationResponse {

  @JsonProperty("notification_date")
  private String notificationDate;

  @JsonProperty("surveyor_notification_id")
  private Long id;

  @JsonProperty("surveyor_id")
  private String surveyorId;

  @JsonProperty("title")
  private String title;

  @JsonProperty("message")
  private String message;

  @JsonProperty("notification_status")
  private NotificationStatus notificationStatus;

  @JsonProperty("read_status")
  private ReadStatus readStatus;

  @JsonProperty("action_type")
  private ActionType actionType;

  @JsonProperty("notification_data")
  private String notificationData;
}

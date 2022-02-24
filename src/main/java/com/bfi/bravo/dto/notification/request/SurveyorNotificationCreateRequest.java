package com.bfi.bravo.dto.notification.request;

import com.bfi.bravo.constant.NotificationConstants.ActionType;
import com.bfi.bravo.constant.NotificationConstants.NotificationStatus;
import com.bfi.bravo.constant.NotificationConstants.ReadStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorNotificationCreateRequest {

  @NotBlank
  @JsonProperty("surveyor_id")
  private String surveyorId;

  @NotBlank
  @JsonProperty("title")
  private String title;

  @NotBlank
  @JsonProperty("message")
  private String message;

  @NotNull
  @JsonProperty("notification_status")
  private NotificationStatus notificationStatus;

  @NotNull
  @JsonProperty("read_status")
  private ReadStatus readStatus;

  @NotNull
  @JsonProperty("action_type")
  private ActionType actionType;

  @NotBlank
  @JsonProperty("notification_data")
  private String notificationData;
}

package com.bfi.bravo.dto.notification.request;

import com.bfi.bravo.constant.NotificationConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorNotificationReadStatusUpdateRequest {

  @NotNull
  @JsonProperty("surveyor_notification_id")
  private Long surveyorNotificationId;

  @NotNull
  @JsonProperty("read_status")
  private NotificationConstants.ReadStatus readStatus;
}

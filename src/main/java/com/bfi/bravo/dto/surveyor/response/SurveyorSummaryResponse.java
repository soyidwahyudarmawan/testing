package com.bfi.bravo.dto.surveyor.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorSummaryResponse {

  @JsonProperty("count_unread_notification")
  private long countUnreadNotification;

  @JsonProperty("count_new_assignment")
  private long countNewAssignment;

  @JsonProperty("count_open_assignment")
  private long countOpenAssignment;

  @JsonProperty("count_draft_saved")
  private long countDraftSaved;

  @JsonProperty("count_document_submission")
  private long countDocumentSubmission;
}

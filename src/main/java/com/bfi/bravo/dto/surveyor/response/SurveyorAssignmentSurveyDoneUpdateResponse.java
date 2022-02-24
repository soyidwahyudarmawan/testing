package com.bfi.bravo.dto.surveyor.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorAssignmentSurveyDoneUpdateResponse {

  @JsonProperty("assignment_id")
  private Long assignmentId;
}

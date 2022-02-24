package com.bfi.bravo.dto.surveyor.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorAssignmentPersonalDataUpdateResponse {

  @JsonProperty("assignment_id")
  private Long assignmentId;

  @JsonProperty("assignment_personal_data_id")
  private Long assignmentPersonalDataId;
}

package com.bfi.bravo.dto.surveyor.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorAssignmentOccupationDataCreateResponse {

  @JsonProperty("assignment_occupation_data_id")
  private Long assignmentOccupationDataId;
}

package com.bfi.bravo.dto.surveyor.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorAssignmentCollateralInformationUpdateResponse {

  @JsonProperty("assignment_id")
  private Long assignmentId;

  @JsonProperty("assignment_collateral_information_id")
  private Long assignmentCollateralInformationId;
}

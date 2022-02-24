package com.bfi.bravo.dto.operation.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OperationAssignmentFundingInformationUpdateResponse {

  @JsonProperty("assignment_funding_information_id")
  private Long assignmentFundingInformationId;

  @JsonProperty("assignment_id")
  private Long assignmentId;
}

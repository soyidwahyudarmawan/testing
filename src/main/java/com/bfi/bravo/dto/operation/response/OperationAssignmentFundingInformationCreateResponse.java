package com.bfi.bravo.dto.operation.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OperationAssignmentFundingInformationCreateResponse {

  @JsonProperty("assignment_funding_information_id")
  private Long assignmentFundingInformationId;
}

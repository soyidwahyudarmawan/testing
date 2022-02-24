package com.bfi.bravo.dto.operation.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OperationAssignmentThirdPartyInformationUpdateResponse {

  @JsonProperty("assignment_third_party_information_id")
  private Long assignmentThirdPartyInformationId;

  @JsonProperty("assignment_id")
  private Long assignmentId;
}

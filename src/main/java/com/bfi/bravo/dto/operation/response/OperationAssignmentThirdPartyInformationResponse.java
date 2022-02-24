package com.bfi.bravo.dto.operation.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OperationAssignmentThirdPartyInformationResponse {

  @JsonProperty("assignment_third_party_information_id")
  private Long assignmentThirdPartyInformationId;

  @JsonProperty("assignment_id")
  private Long assignmentId;

  @JsonProperty("guarantor_name")
  private String guarantorName;

  @JsonProperty("guarantor_identity_number")
  private String guarantorIdentityNumber;

  @JsonProperty("guarantor_address")
  private String guarantorAddress;
}

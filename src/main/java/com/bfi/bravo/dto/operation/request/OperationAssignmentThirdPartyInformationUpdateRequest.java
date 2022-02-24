package com.bfi.bravo.dto.operation.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class OperationAssignmentThirdPartyInformationUpdateRequest {

  @NotNull
  @JsonProperty("assignment_third_party_information_id")
  private Long assignmentThirdPartyInformationId;

  @NotBlank
  @JsonProperty("guarantor_name")
  private String guarantorName;

  @NotBlank
  @Size(min = 16, max = 16)
  @JsonProperty("guarantor_identity_number")
  private String guarantorIdentityNumber;

  @NotBlank
  @JsonProperty("guarantor_address")
  private String guarantorAddress;
}

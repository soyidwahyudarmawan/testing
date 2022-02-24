package com.bfi.bravo.dto.operation.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class OperationAssignmentPhysicalDocumentUpdateRequest {

  @NotNull
  @JsonProperty("assignment_physical_document_id")
  private Long assignmentPhysicalDocumentId;

  @NotNull
  @JsonProperty("assignment_id")
  private Long assignmentId;

  @NotNull
  @JsonProperty("vehicle_ownership_valid")
  private boolean vehicleOwnershipValid;

  @NotNull
  @JsonProperty("tax_notice_valid")
  private boolean taxNoticeValid;

  @NotNull
  @JsonProperty("vehicle_registration_valid")
  private boolean vehicleRegistrationValid;
}

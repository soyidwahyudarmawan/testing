package com.bfi.bravo.dto.operation.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OperationAssignmentPhysicalDocumentResponse {

  @JsonProperty("assignment_physical_document_id")
  private Long assignmentPhysicalDocumentId;

  @JsonProperty("assignment_id")
  private Long assignmentId;

  @JsonProperty("vehicle_ownership_valid")
  private boolean vehicleOwnershipValid;

  @JsonProperty("tax_notice_valid")
  private boolean taxNoticeValid;

  @JsonProperty("vehicle_registration_valid")
  private boolean vehicleRegistrationValid;
}

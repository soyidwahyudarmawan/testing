package com.bfi.bravo.dto.operation.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OperationAssignmentAssetDocumentDataChecklistUpdateRequest {

  @NotNull
  @JsonProperty("assignment_id")
  private Long assignmentId;

  @NotNull
  @JsonProperty("vehicle_ownership_completed")
  private boolean vehicleOwnershipCompleted;

  @NotNull
  @JsonProperty("vehicle_registration_completed")
  private boolean vehicleRegistrationCompleted;

  @NotNull
  @JsonProperty("tax_notice_completed")
  private boolean taxNoticeCompleted;
}

package com.bfi.bravo.dto.operation.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OperationAssignmentAssetDocumentDataVehicleOwnershipUpdateRequest {

  @NotNull
  @JsonProperty("assignment_asset_document_data_id")
  private Long assignmentAssetDocumentDataId;

  @NotNull
  @JsonProperty("assignment_id")
  private Long assignmentId;

  @NotBlank
  @JsonProperty("vehicle_ownership_number")
  private String vehicleOwnershipNumber;

  @NotBlank
  @JsonProperty("vehicle_ownership_on_behalf_of")
  private String vehicleOwnershipOnBehalfOf;

  @NotBlank
  @JsonProperty("vehicle_ownership_chassis_number")
  private String vehicleOwnershipChassisNumber;

  @NotBlank
  @JsonProperty("vehicle_ownership_machine_number")
  private String vehicleOwnershipMachineNumber;
}

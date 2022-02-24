package com.bfi.bravo.dto.operation.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OperationAssignmentAssetDocumentDataVehicleRegistrationUpdateRequest {

  @NotNull
  @JsonProperty("assignment_id")
  private Long assignmentId;

  @NotNull
  @NotEmpty
  @JsonProperty("vehicle_registration_number")
  private String vehicleRegistrationNumber;

  @NotNull
  @NotEmpty
  @JsonProperty("vehicle_registration_expired_date")
  private LocalDate vehicleRegistrationExpiredDate;

  @NotNull
  @NotEmpty
  @JsonProperty("vehicle_registration_color")
  private String vehicleRegistrationColor;

  @NotNull
  @NotEmpty
  @JsonProperty("vehicle_registration_chassis_number")
  private String vehicleRegistrationChassisNumber;

  @NotNull
  @NotEmpty
  @JsonProperty("vehicle_registration_machine_number")
  private String vehicleRegistrationMachineNumber;
}

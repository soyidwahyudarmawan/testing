package com.bfi.bravo.dto.operation.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Builder
public class OperationAssignmentCreateRequest {

  @NotNull
  @JsonProperty("application_id")
  private UUID applicationId;

  @NotBlank
  @JsonProperty("application_number")
  private String applicationNumber;

  @NotNull
  @JsonProperty("surveyor_assignment_id")
  private Long surveyorAssignmentId;

  @NotNull
  @JsonProperty("branch_id")
  private Long branchId;
}

package com.bfi.bravo.dto.operation.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class OperationAssignmentFundingInformationCreateRequest {

  @NotNull
  @JsonProperty("assignment_id")
  private Long assignmentId;
}

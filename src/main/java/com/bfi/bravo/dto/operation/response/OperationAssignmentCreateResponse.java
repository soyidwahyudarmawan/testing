package com.bfi.bravo.dto.operation.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OperationAssignmentCreateResponse {

  @JsonProperty("assignment_id")
  private Long assignmentId;
}

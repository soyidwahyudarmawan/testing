package com.bfi.bravo.dto.operation.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OperationAssignmentDocumentSignCreateRequest {

  @NotNull
  @JsonProperty("assignment_id")
  private Long assignmentId;
}

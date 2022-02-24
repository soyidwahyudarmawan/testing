package com.bfi.bravo.dto.operation.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OperationAssignmentAssetDocumentDataCreateRequest {

  @JsonProperty("assignment_id")
  private Long assignmentId;
}

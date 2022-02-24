package com.bfi.bravo.dto.operation.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OperationAssignmentPhysicalDocumentCreateResponse {

  @JsonProperty("assignment_physical_document_id")
  private Long assignmentPhysicalDocumentId;
}

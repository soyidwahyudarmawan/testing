package com.bfi.bravo.dto.operation.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OperationAssignmentDocumentSignUpdateResponse {

  @JsonProperty("assignment_document_sign_id")
  private Long assignmentDocumentSignId;

  @JsonProperty("assignment_id")
  private Long assignmentId;
}

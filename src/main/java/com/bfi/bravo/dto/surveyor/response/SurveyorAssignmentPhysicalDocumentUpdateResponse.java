package com.bfi.bravo.dto.surveyor.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorAssignmentPhysicalDocumentUpdateResponse {

  @JsonProperty("assignment_id")
  private Long assignmentId;

  @JsonProperty("assignment_physical_document_id")
  private Long assignmentPhysicalDocumentId;
}

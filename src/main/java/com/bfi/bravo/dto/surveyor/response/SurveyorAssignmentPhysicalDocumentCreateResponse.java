package com.bfi.bravo.dto.surveyor.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorAssignmentPhysicalDocumentCreateResponse {

  @JsonProperty("assignment_physical_document_id")
  private Long assignmentPhysicalDocumentId;
}

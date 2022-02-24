package com.bfi.bravo.dto.surveyor.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorAssignmentEmergencyContactUpdateResponse {

  @JsonProperty("assignment_id")
  private Long assignmentId;

  @JsonProperty("assignment_emergency_contact_id")
  private Long assignmentEmergencyContactId;
}

package com.bfi.bravo.dto.surveyor.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorAssignmentOccupationDataCreateRequest {

  @NotNull
  @JsonProperty("assignment_id")
  private Long assignmentId;
}

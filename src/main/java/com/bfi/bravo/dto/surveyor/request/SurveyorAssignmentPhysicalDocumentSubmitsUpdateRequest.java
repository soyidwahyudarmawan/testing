package com.bfi.bravo.dto.surveyor.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SurveyorAssignmentPhysicalDocumentSubmitsUpdateRequest {

  @NotNull
  @JsonProperty("assignment_ids")
  private List<Long> assignmentIds;
}

package com.bfi.bravo.dto.surveyor.request;

import com.bfi.bravo.constant.SurveyorConstants.AssignmentType;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorAssignmentCreateRequest {

  @NotNull
  @JsonProperty("application_id")
  private UUID applicationId;

  @NotBlank
  @JsonProperty("application_number")
  private String applicationNumber;

  @NotNull
  @JsonProperty("lead_id")
  private UUID leadId;

  @NotBlank
  @JsonProperty("lead_number")
  private String leadNumber;

  @NotBlank
  @JsonProperty("surveyor_id")
  private String surveyorId;

  @NotNull
  @JsonProperty("assignment_type")
  private AssignmentType assignmentType;

  @NotNull
  @JsonProperty("branch_id")
  private Long branchId;

  @NotNull
  @JsonProperty("product_id")
  private Long productId;
}

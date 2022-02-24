package com.bfi.bravo.dto.surveyor.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorAssignmentLoanInformationUpdateRequest {

  @NotNull
  @JsonProperty("assignment_loan_information_id")
  private Long assignmentLoanInformationId;

  @NotNull
  @JsonProperty("assignment_id")
  private Long assignmentId;

  @NotNull
  @JsonProperty("amount")
  private BigDecimal amount;

  @NotNull
  @JsonProperty("tenor")
  private int tenor;

  @NotNull
  @JsonProperty("installment_amount")
  private BigDecimal installmentAmount;
}

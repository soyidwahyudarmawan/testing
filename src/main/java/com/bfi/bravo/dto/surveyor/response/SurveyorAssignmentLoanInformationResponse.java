package com.bfi.bravo.dto.surveyor.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorAssignmentLoanInformationResponse {

  @JsonProperty("assignment_loan_information_id")
  private Long assignmentLoanInformationId;

  @JsonProperty("assignment_id")
  private Long assignmentId;

  @JsonProperty("amount")
  private BigDecimal amount;

  @JsonProperty("tenor")
  private int tenor;

  @JsonProperty("installment_amount")
  private BigDecimal installmentAmount;
}

package com.bfi.bravo.dto.operation.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class OperationAssignmentFundingInformationResponse {

  @JsonProperty("assignment_funding_information_id")
  private Long assignmentFundingInformationId;

  @JsonProperty("assignment_id")
  private Long assignmentId;

  @JsonProperty("amount")
  private BigDecimal amount;

  @JsonProperty("tenor")
  private int tenor;

  @JsonProperty("installment_amount")
  private BigDecimal installmentAmount;

  // TODO METHOD TO ENUM
  @JsonProperty("funding_method")
  private String fundingMethod;

  @JsonProperty("bank_name")
  private String bankName;

  @JsonProperty("bank_account_number")
  private String bankAccountNumber;

  @JsonProperty("bank_account_name")
  private String bankAccountName;

  // TODO STATUS TO ENUM
  @JsonProperty("bank_account_status")
  private String bankAccountStatus;

  @JsonProperty("effective_date")
  private LocalDate effectiveDate;
}

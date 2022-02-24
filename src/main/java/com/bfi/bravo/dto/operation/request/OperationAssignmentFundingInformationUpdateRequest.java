package com.bfi.bravo.dto.operation.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class OperationAssignmentFundingInformationUpdateRequest {

  @NotNull
  @JsonProperty("assignment_funding_information_id")
  private Long assignmentFundingInformationId;

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

  @NotNull
  @JsonProperty("funding_method")
  private String fundingMethod;

  @NotBlank
  @JsonProperty("bank_name")
  private String bankName;

  @NotBlank
  @JsonProperty("bank_account_number")
  private String bankAccountNumber;

  @NotBlank
  @JsonProperty("bank_account_name")
  private String bankAccountName;

  @NotNull
  @JsonProperty("bank_account_status")
  private String bankAccountStatus;

  @NotNull
  @JsonProperty("effective_date")
  private LocalDate effectiveDate;
}

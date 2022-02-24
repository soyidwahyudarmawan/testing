package com.bfi.bravo.dto.application.response;

import com.bfi.bravo.constant.ApplicationConstants.ApplicationStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApplicationResponse {

  @JsonProperty("application_id")
  private UUID applicationId;

  @JsonProperty("application_number")
  private String applicationNumber;

  @JsonProperty("lead_id")
  private UUID leadId;

  @JsonProperty("lead_number")
  private String leadNumber;

  @JsonProperty("application_status")
  private ApplicationStatus applicationStatus;

  @JsonProperty("collateral")
  private ApplicationCollateralResponse collateral;

  @JsonProperty("applicant")
  private ApplicationApplicantResponse applicant;

  @JsonProperty("amount")
  private BigDecimal amount;

  @JsonProperty("tenor")
  private int tenor;

  @JsonProperty("installment_amount")
  private BigDecimal installmentAmount;

  @JsonProperty("product_id")
  private Long productId;

  @JsonProperty("branch_id")
  private Long branchId;

  @JsonProperty("process_id")
  private UUID processId;
}

package com.bfi.bravo.dto.application.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.UUID;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApplicationCreateRequest {

  @NotNull
  @JsonProperty("lead_id")
  private UUID leadId;

  @NotBlank
  @JsonProperty("lead_number")
  private String leadNumber;

  @Valid
  @NotNull
  @JsonProperty("collateral")
  private ApplicationCollateralRequest collateral;

  @Valid
  @NotNull
  @JsonProperty("applicant")
  private ApplicationApplicantRequest applicant;

  @NotNull
  @JsonProperty("amount")
  private BigDecimal amount;

  @Min(1)
  @Max(240)
  @NotNull
  @JsonProperty("tenor")
  private int tenor;

  @NotNull
  @JsonProperty("installment_amount")
  private BigDecimal installmentAmount;

  @NotNull
  @JsonProperty("product_id")
  private Long productId;
}

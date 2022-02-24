package com.bfi.bravo.dto.application.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ApplicationCollateralByIdResponse {
  @JsonProperty("collateral_id")
  private Long collateralId;

  @JsonProperty("brand_code")
  private String brandCode;

  @JsonProperty("brand_name")
  private String brandName;

  @JsonProperty("model_code")
  private String modelCode;

  @JsonProperty("model_name")
  private String modelName;

  @JsonProperty("variant_code")
  private String variantCode;

  @JsonProperty("variant_name")
  private String variantName;

  @JsonProperty("year_made")
  private int yearMade;

  @JsonProperty("value_estimate")
  private BigDecimal valueEstimate;

  @JsonProperty("license_number")
  private String licenseNumber;

  @JsonProperty("registration_number")
  private String registrationNumber;

  @JsonProperty("registration_photo")
  private String registrationPhoto;
}

package com.bfi.bravo.dto.application.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApplicationCollateralRequest {

  @NotBlank
  @JsonProperty("brand_code")
  private String brandCode;

  @NotBlank
  @JsonProperty("brand_name")
  private String brandName;

  @NotBlank
  @JsonProperty("model_code")
  private String modelCode;

  @NotBlank
  @JsonProperty("model_name")
  private String modelName;

  @NotBlank
  @JsonProperty("variant_code")
  private String variantCode;

  @NotBlank
  @JsonProperty("variant_name")
  private String variantName;

  @NotNull
  @Min(1900)
  @JsonProperty("year_made")
  private int yearMade;

  @NotNull
  @JsonProperty("value_estimate")
  private BigDecimal valueEstimate;

  @NotBlank
  @JsonProperty("license_number")
  private String licenseNumber;

  @NotBlank
  @JsonProperty("registration_number")
  private String registrationNumber;

  @NotBlank
  @JsonProperty("registration_photo")
  private String registrationPhoto;
}

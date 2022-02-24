package com.bfi.bravo.dto.surveyor.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorAssignmentCollateralInformationUpdateRequest {

  @NotNull
  @JsonProperty("assignment_collateral_information_id")
  private Long assignmentCollateralInformationId;

  @NotNull
  @JsonProperty("assignment_id")
  private Long assignmentId;

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
  @JsonProperty("year_made")
  private int yearMade;

  @NotBlank
  @JsonProperty("license_number")
  private String licenseNumber;

  @NotBlank
  @JsonProperty("vehicle_registration_photo")
  private String vehicleRegistrationPhoto;

  @NotBlank
  @JsonProperty("vehicle_tax_notice_photo")
  private String vehicleTaxNoticePhoto;

  @NotBlank
  @JsonProperty("vehicle_left_side_photo")
  private String vehicleLeftSidePhoto;

  @NotBlank
  @JsonProperty("vehicle_right_side_photo")
  private String vehicleRightSidePhoto;

  @NotBlank
  @JsonProperty("vehicle_front_side_photo")
  private String vehicleFrontSidePhoto;

  @NotBlank
  @JsonProperty("vehicle_back_side_photo")
  private String vehicleBackSidePhoto;

  @NotBlank
  @JsonProperty("vehicle_dashboard_side_photo")
  private String vehicleDashboardSidePhoto;
}

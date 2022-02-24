package com.bfi.bravo.dto.surveyor.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorAssignmentCollateralInformationResponse {

  @JsonProperty("assignment_collateral_information_id")
  private Long assignmentCollateralInformationId;

  @JsonProperty("assignment_id")
  private Long assignmentId;

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

  @JsonProperty("license_number")
  private String licenseNumber;

  @JsonProperty("vehicle_registration_photo")
  private String vehicleRegistrationPhoto;

  @JsonProperty("vehicle_tax_notice_photo")
  private String vehicleTaxNoticePhoto;

  @JsonProperty("vehicle_left_side_photo")
  private String vehicleLeftSidePhoto;

  @JsonProperty("vehicle_right_side_photo")
  private String vehicleRightSidePhoto;

  @JsonProperty("vehicle_front_side_photo")
  private String vehicleFrontSidePhoto;

  @JsonProperty("vehicle_back_side_photo")
  private String vehicleBackSidePhoto;

  @JsonProperty("vehicle_dashboard_side_photo")
  private String vehicleDashboardSidePhoto;
}

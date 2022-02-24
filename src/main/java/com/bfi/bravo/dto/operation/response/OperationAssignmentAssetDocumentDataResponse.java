package com.bfi.bravo.dto.operation.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class OperationAssignmentAssetDocumentDataResponse {

  @JsonProperty("assignment_asset_document_data_id")
  private Long assignmentAssetDocumentDataId;

  @JsonProperty("assignment_id")
  private Long assignmentId;

  @JsonProperty("vehicle_ownership_completed")
  private boolean vehicleOwnershipCompleted;

  @JsonProperty("vehicle_registration_completed")
  private boolean vehicleRegistrationCompleted;

  @JsonProperty("tax_notice_completed")
  private boolean taxNoticeCompleted;

  @JsonProperty("asset_code_brand")
  private String assetCodeBrand;

  @JsonProperty("asset_brand_name")
  private String assetBrandName;

  @JsonProperty("asset_code_model")
  private String assetCodeModel;

  @JsonProperty("asset_model_name")
  private String assetModelName;

  @JsonProperty("asset_code_variant")
  private String assetCodeVariant;

  @JsonProperty("asset_variant_name")
  private String assetVariantName;

  @JsonProperty("asset_year_made")
  private int assetYearMade;

  @JsonProperty("license_number")
  private String licenseNumber;

  @JsonProperty("vehicle_ownership_number")
  private String vehicleOwnershipNumber;

  @JsonProperty("vehicle_ownership_on_behalf_of")
  private String vehicleOwnershipOnBehalfOf;

  @JsonProperty("vehicle_ownership_chassis_number")
  private String vehicleOwnershipChassisNumber;

  @JsonProperty("vehicle_ownership_machine_number")
  private String vehicleOwnershipMachineNumber;

  @JsonProperty("vehicle_registration_number")
  private String vehicleRegistrationNumber;

  @JsonProperty("vehicle_registration_expired_date")
  private LocalDate vehicleRegistrationExpiredDate;

  @JsonProperty("vehicle_registration_color")
  private String vehicleRegistrationColor;

  @JsonProperty("vehicle_registration_chassis_number")
  private String vehicleRegistrationChassisNumber;

  @JsonProperty("vehicle_registration_machine_number")
  private String vehicleRegistrationMachineNumber;

  @JsonProperty("tax_notice_number")
  private String taxNoticeNumber;

  @JsonProperty("tax_notice_expired_date")
  private LocalDate taxNoticeExpiredDate;

  @JsonProperty("tax_notice_color")
  private String taxNoticeColor;

  @JsonProperty("tax_notice_chassis_number")
  private String taxNoticeChassisNumber;

  @JsonProperty("tax_notice_machine_number")
  private String taxNoticeMachineNumber;
}

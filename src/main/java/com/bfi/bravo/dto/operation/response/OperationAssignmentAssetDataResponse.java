package com.bfi.bravo.dto.operation.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OperationAssignmentAssetDataResponse {

  @JsonProperty("assignment_asset_data_id")
  private Long assignmentAssetDataId;

  @JsonProperty("assignment_id")
  private Long assignmentId;

  @JsonProperty("asset_brand_checked")
  private boolean assetBrandChecked;

  @JsonProperty("asset_model_checked")
  private boolean assetModelChecked;

  @JsonProperty("asset_variant_checked")
  private boolean assetVariantChecked;

  @JsonProperty("asset_year_made_checked")
  private boolean assetYearMadeChecked;

  @JsonProperty("license_number_checked")
  private boolean licenseNumberChecked;

  @JsonProperty("noka_nosin_checked")
  private boolean nokaNosinChecked;

  @JsonProperty("color_checked")
  private boolean colorChecked;

  @JsonProperty("tax_notice_checked")
  private boolean taxNoticeChecked;
}

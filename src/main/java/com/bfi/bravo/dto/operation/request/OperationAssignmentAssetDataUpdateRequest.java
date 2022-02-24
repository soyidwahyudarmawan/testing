package com.bfi.bravo.dto.operation.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OperationAssignmentAssetDataUpdateRequest {

  @NotNull
  @JsonProperty("asset_data_id")
  private Long assetDataId;

  @NotNull
  @JsonProperty("assignment_id")
  private Long assignmentId;

  @NotNull
  @JsonProperty("asset_brand_checked")
  private Boolean assetBrandChecked;

  @NotNull
  @JsonProperty("asset_model_checked")
  private Boolean assetModelChecked;

  @NotNull
  @JsonProperty("asset_variant_checked")
  private Boolean assetVariantChecked;

  @NotNull
  @JsonProperty("asset_year_made_checked")
  private Boolean assetYearMadeChecked;

  @NotNull
  @JsonProperty("license_number_checked")
  private Boolean licenseNumberChecked;

  @NotNull
  @JsonProperty("noka_nosin_checked")
  private Boolean nokaNosinChecked;

  @NotNull
  @JsonProperty("color_checked")
  private Boolean colorChecked;

  @NotNull
  @JsonProperty("tax_notice_checked")
  private Boolean taxNoticeChecked;
}

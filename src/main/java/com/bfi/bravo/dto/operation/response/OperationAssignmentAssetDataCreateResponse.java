package com.bfi.bravo.dto.operation.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OperationAssignmentAssetDataCreateResponse {

  @JsonProperty("assignment_asset_data_id")
  private Long assignmentAssetDataId;
}

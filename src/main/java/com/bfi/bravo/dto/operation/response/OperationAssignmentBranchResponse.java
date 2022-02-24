package com.bfi.bravo.dto.operation.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

public class OperationAssignmentBranchResponse {
  @JsonProperty("branch_id")
  private Long branchId;

  @JsonProperty("city_code")
  private Long cityCode;

  @JsonProperty("branch_name")
  private String branchName;
}

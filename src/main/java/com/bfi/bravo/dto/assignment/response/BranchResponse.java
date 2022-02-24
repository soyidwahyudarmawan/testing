package com.bfi.bravo.dto.assignment.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BranchResponse
{
  @JsonProperty("branch_id")
  private Long branchId;

  @JsonProperty("city_code")
  private String cityCode;

  @JsonProperty("city_name")
  private String cityName;
}

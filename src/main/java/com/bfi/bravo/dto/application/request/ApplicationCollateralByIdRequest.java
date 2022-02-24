package com.bfi.bravo.dto.application.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class ApplicationCollateralByIdRequest {
  @NotNull
  @JsonProperty("collateral_id")
  private Long collateralId;
}

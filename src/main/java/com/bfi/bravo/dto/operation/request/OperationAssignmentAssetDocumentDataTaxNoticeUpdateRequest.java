package com.bfi.bravo.dto.operation.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OperationAssignmentAssetDocumentDataTaxNoticeUpdateRequest {

  @NotNull
  @JsonProperty("assignment_id")
  private Long assignmentId;

  @NotNull
  @NotEmpty
  @JsonProperty("tax_notice_number")
  private String taxNoticeNumber;

  @NotNull
  @JsonProperty("tax_notice_expired_date")
  private LocalDate taxNoticeExpiredDate;

  @NotNull
  @NotEmpty
  @JsonProperty("tax_notice_color")
  private String taxNoticeColor;

  @NotNull
  @NotEmpty
  @JsonProperty("tax_notice_chassis_number")
  private String taxNoticeChassisNumber;

  @NotNull
  @NotEmpty
  @JsonProperty("tax_notice_machine_number")
  private String taxNoticeMachineNumber;
}

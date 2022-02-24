package com.bfi.bravo.dto.operation.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class OperationAssignmentResponse {

  @JsonProperty("assignment_id")
  private Long assignmentId;

  @JsonProperty("application_id")
  private UUID applicationId;

  @JsonProperty("application_number")
  private String applicationNumber;

  @JsonProperty("surveyor_assignment_id")
  private Long surveyorAssignmentId;

  @JsonProperty("branch_id")
  private Long branchId;

  @JsonProperty("asset_document_data_completed")
  private boolean assetDocumentDataCompleted;

  @JsonProperty("document_sign_completed")
  private boolean documentSignCompleted;

  @JsonProperty("physical_document_completed")
  private boolean physicalDocumentCompleted;

  @JsonProperty("third_party_information_completed")
  private boolean thirdPartyInformationCompleted;

  @JsonProperty("funding_information_completed")
  private boolean fundingInformationCompleted;

  @JsonProperty("asset_data_completed")
  private boolean assetDataCompleted;

  // TODO MAKE STATUS TO ENUM
  @JsonProperty("assignment_status")
  private String assignmentStatus;

  @JsonProperty("assignment_branch_status")
  private String assignmentBranchStatus;

  @JsonProperty("assignment_head_office_status")
  private String assignmentHeadOfficeStatus;

  @JsonProperty("branch_pic")
  private String branchPic;

  @JsonProperty("head_office_cdp_pic")
  private String headOfficeCdpPic;

  @JsonProperty("head_office_rco_pic")
  private String headOfficeRcoPic;
}

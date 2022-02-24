package com.bfi.bravo.dto.assignment.response;

import com.bfi.bravo.constant.AssignmentConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MyAssignmentRcoResponse
{
  @JsonProperty("application_id")
  private UUID applicationId;

  @JsonProperty("branch")
  private BranchResponse branch;

  @JsonProperty("assignment_date")
  private LocalDateTime assignmentDate;

  @JsonProperty("asset_document_data_completed")
  private Boolean assetDocumentDataCompleted;

  @JsonProperty("document_sign_completed")
  private Boolean documentSignCompleted;

  @JsonProperty("physical_document_completed")
  private Boolean physicalDocumentCompleted;

  @JsonProperty("third_party_information_completed")
  private Boolean thirdPartyInformationCompleted;

  @JsonProperty("funding_information_completed")
  private Boolean fundingInformationCompleted;

  @JsonProperty("asset_data_completed")
  private Boolean assetDataCompleted;

  @JsonProperty("data_enrichment_status")
  private AssignmentConstants.DataEnrichmentStatus statusEnrichment;

  @JsonProperty("request_golive_status")
  private AssignmentConstants.RequestGoLiveStatus statusGoLive;
}

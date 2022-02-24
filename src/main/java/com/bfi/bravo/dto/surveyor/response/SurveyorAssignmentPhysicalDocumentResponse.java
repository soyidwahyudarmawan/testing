package com.bfi.bravo.dto.surveyor.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorAssignmentPhysicalDocumentResponse {

  @JsonProperty("assignment_physical_document_id")
  private Long assignmentPhysicalDocumentId;

  @JsonProperty("assignment_id")
  private Long assignmentId;

  @JsonProperty("vehicle_owner_photo_one")
  private String vehicleOwnerPhotoOne;

  @JsonProperty("vehicle_owner_photo_two")
  private String vehicleOwnerPhotoTwo;

  @JsonProperty("vehicle_owner_photo_three")
  private String vehicleOwnerPhotoThree;

  @JsonProperty("vehicle_owner_photo_four")
  private String vehicleOwnerPhotoFour;

  @JsonProperty("vehicle_ownership_identity_card_photo")
  private String vehicleOwnershipIdentityCardPhoto;

  @JsonProperty("additional_asset_registration_photo")
  private String additionalAssetRegistrationPhoto;
}

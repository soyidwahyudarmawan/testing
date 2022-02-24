package com.bfi.bravo.dto.surveyor.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorAssignmentPhysicalDocumentUpdateRequest {

  @NotNull
  @JsonProperty("assignment_physical_document_id")
  private Long assignmentPhysicalDocumentId;

  @NotNull
  @JsonProperty("assignment_id")
  private Long assignmentId;

  @NotBlank
  @JsonProperty("vehicle_owner_photo_one")
  private String vehicleOwnerPhotoOne;

  @NotBlank
  @JsonProperty("vehicle_owner_photo_two")
  private String vehicleOwnerPhotoTwo;

  @NotBlank
  @JsonProperty("vehicle_owner_photo_three")
  private String vehicleOwnerPhotoThree;

  @NotBlank
  @JsonProperty("vehicle_owner_photo_four")
  private String vehicleOwnerPhotoFour;

  @NotBlank
  @JsonProperty("vehicle_ownership_identity_card_photo")
  private String vehicleOwnershipIdentityCardPhoto;

  @NotBlank
  @JsonProperty("additional_asset_registration_photo")
  private String additionalAssetRegistrationPhoto;
}

package com.bfi.bravo.dto.surveyor.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorAssignmentPersonalDataUpdateRequest {

  @NotNull
  @JsonProperty("assignment_personal_data_id")
  private Long assignmentPersonalDataId;

  @NotNull
  @JsonProperty("assignment_id")
  private Long assignmentId;

  @NotBlank
  @JsonProperty("customer_name")
  private String customerName;

  @JsonProperty("customer_domicile_address")
  private String customerDomicileAddress;

  @JsonProperty("customer_domicile_additional_address")
  private String customerDomicileAdditionalAddress;

  @NotBlank
  @JsonProperty("customer_domicile_province_code")
  private String customerDomicileProvinceCode;

  @NotBlank
  @JsonProperty("customer_domicile_province_name")
  private String customerDomicileProvinceName;

  @NotBlank
  @JsonProperty("customer_domicile_city_code")
  private String customerDomicileCityCode;

  @NotBlank
  @JsonProperty("customer_domicile_city_name")
  private String customerDomicileCityName;

  @NotBlank
  @JsonProperty("customer_domicile_district_code")
  private String customerDomicileDistrictCode;

  @NotBlank
  @JsonProperty("customer_domicile_district_name")
  private String customerDomicileDistrictName;

  @NotBlank
  @JsonProperty("customer_domicile_subdistrict_code")
  private String customerDomicileSubdistrictCode;

  @NotBlank
  @JsonProperty("customer_domicile_subdistrict_name")
  private String customerDomicileSubdistrictName;

  @NotBlank
  @JsonProperty("customer_domicile_zipcode")
  private String customerDomicileZipcode;

  @JsonProperty("customer_domicile_longitude")
  private BigDecimal customerDomicileLongitude;

  @JsonProperty("customer_domicile_latitude")
  private BigDecimal customerDomicileLatitude;

  @NotNull
  @JsonProperty("same_with_domicile")
  private boolean sameWithDomicile;

  @JsonProperty("customer_legal_province_code")
  private String customerLegalProvinceCode;

  @JsonProperty("customer_legal_province_name")
  private String customerLegalProvinceName;

  @JsonProperty("customer_legal_city_code")
  private String customerLegalCityCode;

  @JsonProperty("customer_legal_city_name")
  private String customerLegalCityName;

  @JsonProperty("customer_legal_district_code")
  private String customerLegalDistrictCode;

  @JsonProperty("customer_legal_district_name")
  private String customerLegalDistrictName;

  @JsonProperty("customer_legal_subdistrict_code")
  private String customerLegalSubdistrictCode;

  @JsonProperty("customer_legal_subdistrict_name")
  private String customerLegalSubdistrictName;

  @JsonProperty("customer_legal_zipcode")
  private String customerLegalZipcode;

  @NotBlank
  @JsonProperty("customer_phone_number")
  private String customerPhoneNumber;

  @NotBlank
  @JsonProperty("customer_selfie_photo")
  private String customerSelfiePhoto;

  @NotBlank
  @JsonProperty("customer_identity_card_photo")
  private String customerIdentityCardPhoto;

  @NotBlank
  @JsonProperty("customer_family_card_photo")
  private String customerFamilyCardPhoto;

  @NotNull
  @JsonProperty("customer_is_married")
  private boolean customerIsMarried;

  @JsonProperty("customer_spouse_name")
  private String customerSpouseName;

  @JsonProperty("customer_spouse_occupation_code")
  private String customerSpouseOccupationCode;

  @JsonProperty("customer_spouse_occupation_name")
  private String customerSpouseOccupationName;

  @JsonProperty("customer_spouse_phone_number")
  private String customerSpousePhoneNumber;

  @JsonProperty("customer_spouse_identity_card_photo")
  private String customerSpouseIdentityCardPhoto;

  @NotBlank
  @JsonProperty("customer_mother_maiden_name")
  private String customerMotherMaidenName;

  @NotNull
  @JsonProperty("customer_count_dependency")
  private int customerCountDependency;

  @NotBlank
  @JsonProperty("customer_house_photo")
  private String customerHousePhoto;

  @NotBlank
  @JsonProperty("customer_house_two_photo")
  private String customerHouseTwoPhoto;
}

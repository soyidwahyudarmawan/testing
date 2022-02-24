package com.bfi.bravo.dto.surveyor.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorAssignmentPersonalDataResponse {

  @JsonProperty("assignment_personal_data_id")
  private Long assignmentPersonalDataId;

  @JsonProperty("assignment_id")
  private Long assignmentId;

  @JsonProperty("customer_name")
  private String customerName;

  @JsonProperty("customer_domicile_address")
  private String customerDomicileAddress;

  @JsonProperty("customer_domicile_additional_address")
  private String customerDomicileAdditionalAddress;

  @JsonProperty("customer_domicile_province_code")
  private String customerDomicileProvinceCode;

  @JsonProperty("customer_domicile_province_name")
  private String customerDomicileProvinceName;

  @JsonProperty("customer_domicile_city_code")
  private String customerDomicileCityCode;

  @JsonProperty("customer_domicile_city_name")
  private String customerDomicileCityName;

  @JsonProperty("customer_domicile_district_code")
  private String customerDomicileDistrictCode;

  @JsonProperty("customer_domicile_district_name")
  private String customerDomicileDistrictName;

  @JsonProperty("customer_domicile_subdistrict_code")
  private String customerDomicileSubdistrictCode;

  @JsonProperty("customer_domicile_subdistrict_name")
  private String customerDomicileSubdistrictName;

  @JsonProperty("customer_domicile_zipcode")
  private String customerDomicileZipcode;

  @JsonProperty("customer_domicile_longitude")
  private BigDecimal customerDomicileLongitude;

  @JsonProperty("customer_domicile_latitude")
  private BigDecimal customerDomicileLatitude;

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

  @JsonProperty("customer_phone_number")
  private String customerPhoneNumber;

  @JsonProperty("customer_selfie_photo")
  private String customerSelfiePhoto;

  @JsonProperty("customer_identity_card_photo")
  private String customerIdentityCardPhoto;

  @JsonProperty("customer_family_card_photo")
  private String customerFamilyCardPhoto;

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

  @JsonProperty("customer_mother_maiden_name")
  private String customerMotherMaidenName;

  @JsonProperty("customer_count_dependency")
  private int customerCountDependency;

  @JsonProperty("customer_house_photo")
  private String customerHousePhoto;

  @JsonProperty("customer_house_two_photo")
  private String customerHouseTwoPhoto;
}

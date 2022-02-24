package com.bfi.bravo.dto.surveyor.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorAssignmentEmergencyContactResponse {

  @JsonProperty("assignment_emergency_contact_id")
  private Long assignmentEmergencyContactId;

  @JsonProperty("assignment_id")
  private Long assignmentId;

  @JsonProperty("customer_relationship")
  private String customerRelationship;

  @JsonProperty("name")
  private String name;

  @JsonProperty("address")
  private String address;

  @JsonProperty("province_code")
  private String provinceCode;

  @JsonProperty("province_name")
  private String provinceName;

  @JsonProperty("city_code")
  private String cityCode;

  @JsonProperty("city_name")
  private String cityName;

  @JsonProperty("district_code")
  private String districtCode;

  @JsonProperty("district_name")
  private String districtName;

  @JsonProperty("subdistrict_code")
  private String subdistrictCode;

  @JsonProperty("subdistrict_name")
  private String subdistrictName;

  @JsonProperty("zipcode")
  private String zipcode;

  @JsonProperty("phone_number")
  private String phoneNumber;
}

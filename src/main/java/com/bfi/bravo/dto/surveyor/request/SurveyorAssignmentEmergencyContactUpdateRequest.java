package com.bfi.bravo.dto.surveyor.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorAssignmentEmergencyContactUpdateRequest {

  @NotNull
  @JsonProperty("assignment_emergency_contact_id")
  private Long assignmentEmergencyContactId;

  @NotNull
  @JsonProperty("assignment_id")
  private Long assignmentId;

  @NotBlank
  @JsonProperty("customer_relationship")
  private String customerRelationship;

  @NotBlank
  @JsonProperty("name")
  private String name;

  @NotBlank
  @JsonProperty("address")
  private String address;

  @NotBlank
  @JsonProperty("province_code")
  private String provinceCode;

  @NotBlank
  @JsonProperty("province_name")
  private String provinceName;

  @NotBlank
  @JsonProperty("city_code")
  private String cityCode;

  @NotBlank
  @JsonProperty("city_name")
  private String cityName;

  @NotBlank
  @JsonProperty("district_code")
  private String districtCode;

  @NotBlank
  @JsonProperty("district_name")
  private String districtName;

  @NotBlank
  @JsonProperty("subdistrict_code")
  private String subdistrictCode;

  @NotBlank
  @JsonProperty("subdistrict_name")
  private String subdistrictName;

  @NotBlank
  @JsonProperty("zipcode")
  private String zipcode;

  @NotBlank
  @JsonProperty("phone_number")
  private String phoneNumber;
}

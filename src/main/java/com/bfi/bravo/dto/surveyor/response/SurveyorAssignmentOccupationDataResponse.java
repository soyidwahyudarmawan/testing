package com.bfi.bravo.dto.surveyor.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorAssignmentOccupationDataResponse {

  @JsonProperty("assignment_occupation_data_id")
  private Long assignmentOccupationDataId;

  @JsonProperty("assignment_id")
  private Long assignmentId;

  @JsonProperty("economy_sector_code")
  private String economySectorCode;

  @JsonProperty("economy_sector_name")
  private String economySectorName;

  @JsonProperty("industry_type_code")
  private String industryTypeCode;

  @JsonProperty("industry_type_name")
  private String industryTypeName;

  @JsonProperty("occupation_code")
  private String occupationCode;

  @JsonProperty("occupation_name")
  private String occupationName;

  @JsonProperty("company_name")
  private String companyName;

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

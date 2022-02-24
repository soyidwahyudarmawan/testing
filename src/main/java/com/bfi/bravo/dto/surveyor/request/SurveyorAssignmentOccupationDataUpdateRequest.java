package com.bfi.bravo.dto.surveyor.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorAssignmentOccupationDataUpdateRequest {

  @NotNull
  @JsonProperty("assignment_occupation_data_id")
  private Long assignmentOccupationDataId;

  @NotNull
  @JsonProperty("assignment_id")
  private Long assignmentId;

  @NotBlank
  @JsonProperty("economy_sector_code")
  private String economySectorCode;

  @NotBlank
  @JsonProperty("economy_sector_name")
  private String economySectorName;

  @NotBlank
  @JsonProperty("industry_type_code")
  private String industryTypeCode;

  @NotBlank
  @JsonProperty("industry_type_name")
  private String industryTypeName;

  @NotBlank
  @JsonProperty("occupation_code")
  private String occupationCode;

  @NotBlank
  @JsonProperty("occupation_name")
  private String occupationName;

  @NotBlank
  @JsonProperty("company_name")
  private String companyName;

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

package com.bfi.bravo.dto.application.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApplicationApplicantResponse {

  @JsonProperty("customer_id")
  private String customerId;

  @JsonProperty("full_name")
  private String fullName;

  @JsonProperty("phone_number")
  private String phoneNumber;

  @JsonProperty("identity_number")
  private String identityNumber;

  @JsonProperty("npwp_number")
  private String npwpNumber;

  @JsonProperty("marital_status")
  private String maritalStatus;

  @JsonProperty("gender")
  private String gender;

  @JsonProperty("date_of_birth")
  private LocalDate dateOfBirth;

  @JsonProperty("place_of_birth")
  private String placeOfBirth;

  @JsonProperty("nationality")
  private String nationality;

  @JsonProperty("monthly_income")
  private BigDecimal monthlyIncome;

  @JsonProperty("address")
  private String address;

  @JsonProperty("additional_address")
  private String additionalAddress;

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

  @JsonProperty("selfie_photo")
  private String selfiePhoto;

  @JsonProperty("identity_photo")
  private String identityPhoto;

  @JsonProperty("spouse_identity_photo")
  private String spouseIdentityPhoto;
}

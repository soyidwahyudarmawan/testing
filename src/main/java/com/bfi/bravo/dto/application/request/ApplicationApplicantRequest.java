package com.bfi.bravo.dto.application.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApplicationApplicantRequest {

  @NotNull
  @JsonProperty("customer_id")
  private UUID customerId;

  @NotBlank
  @JsonProperty("full_name")
  private String fullName;

  @NotBlank
  @Size(min = 10, max = 50)
  @JsonProperty("phone_number")
  private String phoneNumber;

  @NotBlank
  @Size(min = 16, max = 16)
  @JsonProperty("identity_number")
  private String identityNumber;

  @NotBlank
  @Size(min = 15, max = 15)
  @JsonProperty("npwp_number")
  private String npwpNumber;

  @NotBlank
  @JsonProperty("marital_status")
  private String maritalStatus;

  @NotBlank
  @JsonProperty("gender")
  private String gender;

  @NotNull
  @JsonProperty("date_of_birth")
  private LocalDate dateOfBirth;

  @NotBlank
  @JsonProperty("place_of_birth")
  private String placeOfBirth;

  @NotBlank
  @JsonProperty("nationality")
  private String nationality;

  @NotNull
  @JsonProperty("monthly_income")
  private BigDecimal monthlyIncome;

  @NotBlank
  @JsonProperty("address")
  private String address;

  @JsonProperty("additional_address")
  private String additionalAddress;

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

  @JsonProperty("longitude")
  private BigDecimal longitude;

  @JsonProperty("latitude")
  private BigDecimal latitude;

  @NotBlank
  @JsonProperty("selfie_photo")
  private String selfiePhoto;

  @NotBlank
  @JsonProperty("identity_photo")
  private String identityPhoto;

  @JsonProperty("spouse_identity_photo")
  private String spouseIdentityPhoto;
}

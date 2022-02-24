package com.bfi.bravo.dto.surveyor.response;

import com.bfi.bravo.constant.SurveyorConstants.AssignmentStatus;
import com.bfi.bravo.constant.SurveyorConstants.AssignmentType;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorAssignmentResponse {

  @JsonProperty("assignment_date")
  private String assignmentDate;

  @JsonProperty("assignment_id")
  private Long assignmentId;

  @JsonProperty("application_id")
  private UUID applicationId;

  @JsonProperty("application_number")
  private String applicationNumber;

  @JsonProperty("lead_id")
  private UUID leadId;

  @JsonProperty("lead_number")
  private String leadNumber;

  @JsonProperty("surveyor_id")
  private String surveyorId;

  @JsonProperty("assignment_type")
  private AssignmentType assignmentType;

  @JsonProperty("assignment_status")
  private AssignmentStatus assignmentStatus;

  @JsonProperty("loaded")
  private boolean loaded;

  @JsonProperty("branch_name")
  private String branchName;

  @JsonProperty("customer_name")
  private String customerName;

  @JsonProperty("customer_address")
  private String customerAddress;

  @JsonProperty("customer_province_name")
  private String customerProvinceName;

  @JsonProperty("customer_city_name")
  private String customerCityName;

  @JsonProperty("customer_district_name")
  private String customerDistrictName;

  @JsonProperty("customer_subdistrict_name")
  private String customerSubdistrictName;

  @JsonProperty("customer_zipcode")
  private String customerZipcode;

  @JsonProperty("customer_longitude")
  private BigDecimal customerLongitude;

  @JsonProperty("customer_latitude")
  private BigDecimal customerLatitude;

  @JsonProperty("customer_phone_number")
  private String customerPhoneNumber;

  @JsonProperty("product_id")
  private Long productId;
}

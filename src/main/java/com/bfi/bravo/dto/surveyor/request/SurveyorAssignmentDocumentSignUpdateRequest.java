package com.bfi.bravo.dto.surveyor.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorAssignmentDocumentSignUpdateRequest {

  @NotNull
  @JsonProperty("assignment_document_sign_id")
  private Long assignmentDocumentSignId;

  @NotNull
  @JsonProperty("assignment_id")
  private Long assignmentId;

  @NotNull
  @JsonProperty("bank_receipt_by_customer")
  private boolean bankReceiptByCustomer;

  @NotNull
  @JsonProperty("bank_receipt_by_owner")
  private boolean bankReceiptByOwner;

  @NotNull
  @JsonProperty("customer_application_request")
  private boolean customerApplicationRequest;

  @NotNull
  @JsonProperty("loan_contract_agreement_transfer_title")
  private boolean loanContractAgreementTransferTitle;

  @NotNull
  @JsonProperty("loan_control_agreement_funding")
  private boolean loanControlAgreementFunding;

  @NotNull
  @JsonProperty("fiduciary")
  private boolean fiduciary;

  @NotNull
  @JsonProperty("fpp_signed")
  private boolean fppSigned;

  @NotBlank
  @JsonProperty("customer_sign_document_photo")
  private String customerSignDocumentPhoto;

  @JsonProperty("surveyor_note")
  private String surveyorNote;
}

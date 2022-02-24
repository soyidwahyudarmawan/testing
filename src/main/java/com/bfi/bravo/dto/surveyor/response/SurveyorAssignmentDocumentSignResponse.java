package com.bfi.bravo.dto.surveyor.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurveyorAssignmentDocumentSignResponse {

  @JsonProperty("assignment_document_sign_id")
  private Long assignmentDocumentSignId;

  @JsonProperty("assignment_id")
  private Long assignmentId;

  @JsonProperty("bank_receipt_by_customer")
  private boolean bankReceiptByCustomer;

  @JsonProperty("bank_receipt_by_owner")
  private boolean bankReceiptByOwner;

  @JsonProperty("customer_application_request")
  private boolean customerApplicationRequest;

  @JsonProperty("loan_contract_agreement_transfer_title")
  private boolean loanContractAgreementTransferTitle;

  @JsonProperty("loan_control_agreement_funding")
  private boolean loanControlAgreementFunding;

  @JsonProperty("fiduciary")
  private boolean fiduciary;

  @JsonProperty("fpp_signed")
  private boolean fppSigned;

  @JsonProperty("customer_sign_document_photo")
  private String customerSignDocumentPhoto;

  @JsonProperty("surveyor_note")
  private String surveyorNote;
}

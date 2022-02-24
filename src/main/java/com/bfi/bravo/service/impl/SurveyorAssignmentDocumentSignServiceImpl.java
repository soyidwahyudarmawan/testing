package com.bfi.bravo.service.impl;

import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentDocumentSignCreateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentDocumentSignUpdateRequest;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentDocumentSignCreateResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentDocumentSignResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentDocumentSignUpdateResponse;
import com.bfi.bravo.entity.SurveyorAssignment;
import com.bfi.bravo.entity.SurveyorAssignmentDocumentSign;
import com.bfi.bravo.repository.SurveyorAssignmentDocumentSignRepository;
import com.bfi.bravo.repository.SurveyorAssignmentRepository;
import com.bfi.bravo.service.SurveyorAssignmentDocumentSignService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
public class SurveyorAssignmentDocumentSignServiceImpl implements SurveyorAssignmentDocumentSignService {

  @Autowired
  private SurveyorAssignmentDocumentSignRepository surveyorAssignmentDocumentSignRepository;

  @Autowired
  private SurveyorAssignmentRepository surveyorAssignmentRepository;

  @Override
  public SurveyorAssignmentDocumentSignCreateResponse create(
    SurveyorAssignmentDocumentSignCreateRequest request
  ) {
    SurveyorAssignment surveyorAssignment = surveyorAssignmentRepository
      .findByIdAndActiveIsTrue(request.getAssignmentId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    SurveyorAssignmentDocumentSign surveyorAssignmentDocumentSign = surveyorAssignmentDocumentSignRepository.save(
      SurveyorAssignmentDocumentSign.builder().assignment(surveyorAssignment).build()
    );

    return SurveyorAssignmentDocumentSignCreateResponse
      .builder()
      .assignmentDocumentSignId(surveyorAssignmentDocumentSign.getId())
      .build();
  }

  @Override
  public SurveyorAssignmentDocumentSignUpdateResponse update(
    SurveyorAssignmentDocumentSignUpdateRequest request
  ) {
    SurveyorAssignmentDocumentSign surveyorAssignmentDocumentSign = surveyorAssignmentDocumentSignRepository
      .findByIdAndActiveIsTrue(request.getAssignmentDocumentSignId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    surveyorAssignmentDocumentSign.setBankReceiptByCustomer(request.isBankReceiptByCustomer());
    surveyorAssignmentDocumentSign.setBankReceiptByOwner(request.isBankReceiptByOwner());
    surveyorAssignmentDocumentSign.setCustomerApplicationRequest(request.isCustomerApplicationRequest());
    surveyorAssignmentDocumentSign.setLoanContractAgreementTransferTitle(
      request.isLoanContractAgreementTransferTitle()
    );
    surveyorAssignmentDocumentSign.setLoanControlAgreementFunding(request.isLoanControlAgreementFunding());
    surveyorAssignmentDocumentSign.setFiduciary(request.isFiduciary());
    surveyorAssignmentDocumentSign.setFppSigned(request.isFppSigned());
    surveyorAssignmentDocumentSign.setCustomerSignDocumentPhoto(request.getCustomerSignDocumentPhoto());
    surveyorAssignmentDocumentSign.setSurveyorNote(request.getSurveyorNote());
    surveyorAssignmentDocumentSignRepository.save(surveyorAssignmentDocumentSign);

    return SurveyorAssignmentDocumentSignUpdateResponse
      .builder()
      .assignmentDocumentSignId(surveyorAssignmentDocumentSign.getId())
      .assignmentId(surveyorAssignmentDocumentSign.getAssignment().getId())
      .build();
  }

  @Override
  public List<SurveyorAssignmentDocumentSignResponse> findAll() {
    List<SurveyorAssignmentDocumentSign> surveyorAssignmentDocumentSigns = Streamable
      .of(surveyorAssignmentDocumentSignRepository.findAllByActiveIsTrue())
      .toList();

    List<SurveyorAssignmentDocumentSignResponse> result = new ArrayList<>();
    surveyorAssignmentDocumentSigns.forEach(surveyorAssignmentDocumentSign -> {
      result.add(
        SurveyorAssignmentDocumentSignResponse
          .builder()
          .assignmentDocumentSignId(surveyorAssignmentDocumentSign.getId())
          .assignmentId(surveyorAssignmentDocumentSign.getAssignment().getId())
          .bankReceiptByCustomer(surveyorAssignmentDocumentSign.isBankReceiptByCustomer())
          .bankReceiptByOwner(surveyorAssignmentDocumentSign.isBankReceiptByOwner())
          .customerApplicationRequest(surveyorAssignmentDocumentSign.isCustomerApplicationRequest())
          .loanContractAgreementTransferTitle(surveyorAssignmentDocumentSign.isLoanContractAgreementTransferTitle())
          .loanControlAgreementFunding(surveyorAssignmentDocumentSign.isLoanControlAgreementFunding())
          .fiduciary(surveyorAssignmentDocumentSign.isFiduciary())
          .fppSigned(surveyorAssignmentDocumentSign.isFppSigned())
          .customerSignDocumentPhoto(surveyorAssignmentDocumentSign.getCustomerSignDocumentPhoto())
          .surveyorNote(surveyorAssignmentDocumentSign.getSurveyorNote())
          .build()
      );
    });

    return result;
  }

  @Override
  public SurveyorAssignmentDocumentSignResponse findById(Long id) {
    SurveyorAssignmentDocumentSign surveyorAssignmentDocumentSign = surveyorAssignmentDocumentSignRepository
      .findByIdAndActiveIsTrue(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return SurveyorAssignmentDocumentSignResponse
      .builder()
      .assignmentDocumentSignId(surveyorAssignmentDocumentSign.getId())
      .assignmentId(surveyorAssignmentDocumentSign.getAssignment().getId())
      .bankReceiptByCustomer(surveyorAssignmentDocumentSign.isBankReceiptByCustomer())
      .bankReceiptByOwner(surveyorAssignmentDocumentSign.isBankReceiptByOwner())
      .customerApplicationRequest(surveyorAssignmentDocumentSign.isCustomerApplicationRequest())
      .loanContractAgreementTransferTitle(surveyorAssignmentDocumentSign.isLoanContractAgreementTransferTitle())
      .loanControlAgreementFunding(surveyorAssignmentDocumentSign.isLoanControlAgreementFunding())
      .fiduciary(surveyorAssignmentDocumentSign.isFiduciary())
      .fppSigned(surveyorAssignmentDocumentSign.isFppSigned())
      .customerSignDocumentPhoto(surveyorAssignmentDocumentSign.getCustomerSignDocumentPhoto())
      .surveyorNote(surveyorAssignmentDocumentSign.getSurveyorNote())
      .build();
  }

  @Override
  public SurveyorAssignmentDocumentSignResponse findByAssignmentId(Long assignmentId) {
    SurveyorAssignmentDocumentSign surveyorAssignmentDocumentSign = surveyorAssignmentDocumentSignRepository
      .findByAssignmentIdAndActiveIsTrue(assignmentId)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return SurveyorAssignmentDocumentSignResponse
      .builder()
      .assignmentDocumentSignId(surveyorAssignmentDocumentSign.getId())
      .assignmentId(surveyorAssignmentDocumentSign.getAssignment().getId())
      .bankReceiptByCustomer(surveyorAssignmentDocumentSign.isBankReceiptByCustomer())
      .bankReceiptByOwner(surveyorAssignmentDocumentSign.isBankReceiptByOwner())
      .customerApplicationRequest(surveyorAssignmentDocumentSign.isCustomerApplicationRequest())
      .loanContractAgreementTransferTitle(surveyorAssignmentDocumentSign.isLoanContractAgreementTransferTitle())
      .loanControlAgreementFunding(surveyorAssignmentDocumentSign.isLoanControlAgreementFunding())
      .fiduciary(surveyorAssignmentDocumentSign.isFiduciary())
      .fppSigned(surveyorAssignmentDocumentSign.isFppSigned())
      .customerSignDocumentPhoto(surveyorAssignmentDocumentSign.getCustomerSignDocumentPhoto())
      .surveyorNote(surveyorAssignmentDocumentSign.getSurveyorNote())
      .build();
  }
}

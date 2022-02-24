package com.bfi.bravo.service.impl;

import com.bfi.bravo.dto.operation.request.OperationAssignmentDocumentSignCreateRequest;
import com.bfi.bravo.dto.operation.request.OperationAssignmentDocumentSignUpdateRequest;
import com.bfi.bravo.dto.operation.response.OperationAssignmentDocumentSignCreateResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentDocumentSignResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentDocumentSignUpdateResponse;
import com.bfi.bravo.entity.OperationAssignment;
import com.bfi.bravo.entity.OperationAssignmentDocumentSign;
import com.bfi.bravo.repository.OperationAssignmentDocumentSignRepository;
import com.bfi.bravo.repository.OperationAssignmentRepository;
import com.bfi.bravo.service.OperationAssignmentDocumentSignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class OperationAssignmentDocumentSignServiceImpl implements OperationAssignmentDocumentSignService {

  @Autowired
  private OperationAssignmentDocumentSignRepository operationAssignmentDocumentSignRepository;

  @Autowired
  private OperationAssignmentRepository operationAssignmentRepository;

  @Override
  public OperationAssignmentDocumentSignCreateResponse create(
    OperationAssignmentDocumentSignCreateRequest request
  ) {
    OperationAssignment operationAssignment = operationAssignmentRepository
      .findByIdAndActiveIsTrue(request.getAssignmentId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    OperationAssignmentDocumentSign operationAssignmentDocumentSign = operationAssignmentDocumentSignRepository.save(
      OperationAssignmentDocumentSign.builder().assignment(operationAssignment).build()
    );

    return OperationAssignmentDocumentSignCreateResponse
      .builder()
      .assignmentDocumentSignId(operationAssignmentDocumentSign.getId())
      .build();
  }

  @Override
  public OperationAssignmentDocumentSignUpdateResponse update(
    OperationAssignmentDocumentSignUpdateRequest request
  ) {
    OperationAssignmentDocumentSign operationAssignmentDocumentSign = operationAssignmentDocumentSignRepository
      .findByIdAndActiveIsTrue(request.getAssignmentDocumentSignId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    operationAssignmentDocumentSign.setBankReceiptByCustomer(request.isBankReceiptByCustomer());
    operationAssignmentDocumentSign.setBankReceiptByOwner(request.isBankReceiptByOwner());
    operationAssignmentDocumentSign.setCustomerApplicationRequest(request.isCustomerApplicationRequest());
    operationAssignmentDocumentSign.setLoanContractAgreementTransferTitle(
      request.isLoanContractAgreementTransferTitle()
    );
    operationAssignmentDocumentSign.setLoanControlAgreementFunding(request.isLoanControlAgreementFunding());
    operationAssignmentDocumentSign.setFiduciary(request.isFiduciary());
    operationAssignmentDocumentSign.setFppSigned(request.isFppSigned());
    operationAssignmentDocumentSign.setCustomerSignDocumentPhoto(request.getCustomerSignDocumentPhoto());
    operationAssignmentDocumentSignRepository.save(operationAssignmentDocumentSign);

    return OperationAssignmentDocumentSignUpdateResponse
      .builder()
      .assignmentDocumentSignId(operationAssignmentDocumentSign.getId())
      .assignmentId(operationAssignmentDocumentSign.getAssignment().getId())
      .build();
  }

  @Override
  public List<OperationAssignmentDocumentSignResponse> findAll() {
    List<OperationAssignmentDocumentSign> operationAssignmentDocumentSigns = Streamable
      .of(operationAssignmentDocumentSignRepository.findAllByActiveIsTrue())
      .toList();

    List<OperationAssignmentDocumentSignResponse> result = new ArrayList<>();
    operationAssignmentDocumentSigns.forEach(operationAssignmentDocumentSign -> {
      result.add(
        OperationAssignmentDocumentSignResponse
          .builder()
          .assignmentDocumentSignId(operationAssignmentDocumentSign.getId())
          .assignmentId(operationAssignmentDocumentSign.getAssignment().getId())
          .bankReceiptByCustomer(operationAssignmentDocumentSign.isBankReceiptByCustomer())
          .bankReceiptByOwner(operationAssignmentDocumentSign.isBankReceiptByOwner())
          .customerApplicationRequest(operationAssignmentDocumentSign.isCustomerApplicationRequest())
          .loanContractAgreementTransferTitle(operationAssignmentDocumentSign.isLoanContractAgreementTransferTitle())
          .loanControlAgreementFunding(operationAssignmentDocumentSign.isLoanControlAgreementFunding())
          .fiduciary(operationAssignmentDocumentSign.isFiduciary())
          .fppSigned(operationAssignmentDocumentSign.isFppSigned())
          .customerSignDocumentPhoto(operationAssignmentDocumentSign.getCustomerSignDocumentPhoto())
          .build()
      );
    });

    return result;
  }

  @Override
  public OperationAssignmentDocumentSignResponse findById(Long id) {
    OperationAssignmentDocumentSign operationAssignmentDocumentSign = operationAssignmentDocumentSignRepository
      .findByIdAndActiveIsTrue(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return OperationAssignmentDocumentSignResponse
      .builder()
      .assignmentDocumentSignId(operationAssignmentDocumentSign.getId())
      .assignmentId(operationAssignmentDocumentSign.getAssignment().getId())
      .bankReceiptByCustomer(operationAssignmentDocumentSign.isBankReceiptByCustomer())
      .bankReceiptByOwner(operationAssignmentDocumentSign.isBankReceiptByOwner())
      .customerApplicationRequest(operationAssignmentDocumentSign.isCustomerApplicationRequest())
      .loanContractAgreementTransferTitle(operationAssignmentDocumentSign.isLoanContractAgreementTransferTitle())
      .loanControlAgreementFunding(operationAssignmentDocumentSign.isLoanControlAgreementFunding())
      .fiduciary(operationAssignmentDocumentSign.isFiduciary())
      .fppSigned(operationAssignmentDocumentSign.isFppSigned())
      .customerSignDocumentPhoto(operationAssignmentDocumentSign.getCustomerSignDocumentPhoto())
      .build();
  }

  @Override
  public OperationAssignmentDocumentSignResponse findByAssignmentId(Long assignmentId) {
    OperationAssignmentDocumentSign operationAssignmentDocumentSign = operationAssignmentDocumentSignRepository
      .findByAssignmentIdAndActiveIsTrue(assignmentId)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return OperationAssignmentDocumentSignResponse
      .builder()
      .assignmentDocumentSignId(operationAssignmentDocumentSign.getId())
      .assignmentId(operationAssignmentDocumentSign.getAssignment().getId())
      .bankReceiptByCustomer(operationAssignmentDocumentSign.isBankReceiptByCustomer())
      .bankReceiptByOwner(operationAssignmentDocumentSign.isBankReceiptByOwner())
      .customerApplicationRequest(operationAssignmentDocumentSign.isCustomerApplicationRequest())
      .loanContractAgreementTransferTitle(operationAssignmentDocumentSign.isLoanContractAgreementTransferTitle())
      .loanControlAgreementFunding(operationAssignmentDocumentSign.isLoanControlAgreementFunding())
      .fiduciary(operationAssignmentDocumentSign.isFiduciary())
      .fppSigned(operationAssignmentDocumentSign.isFppSigned())
      .customerSignDocumentPhoto(operationAssignmentDocumentSign.getCustomerSignDocumentPhoto())
      .build();
  }
}

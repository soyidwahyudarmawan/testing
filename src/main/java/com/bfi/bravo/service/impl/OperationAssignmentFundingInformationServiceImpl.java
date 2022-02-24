package com.bfi.bravo.service.impl;

import com.bfi.bravo.dto.operation.request.OperationAssignmentFundingInformationCreateRequest;
import com.bfi.bravo.dto.operation.request.OperationAssignmentFundingInformationUpdateRequest;
import com.bfi.bravo.dto.operation.response.OperationAssignmentFundingInformationCreateResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentFundingInformationResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentFundingInformationUpdateResponse;
import com.bfi.bravo.entity.OperationAssignment;
import com.bfi.bravo.entity.OperationAssignmentFundingInformation;
import com.bfi.bravo.repository.OperationAssignmentFundingInformationRepository;
import com.bfi.bravo.repository.OperationAssignmentRepository;
import com.bfi.bravo.service.OperationAssignmentFundingInformationService;
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
public class OperationAssignmentFundingInformationServiceImpl implements OperationAssignmentFundingInformationService {

  @Autowired
  private OperationAssignmentFundingInformationRepository operationAssignmentFundingInformationRepository;

  @Autowired
  private OperationAssignmentRepository operationAssignmentRepository;

  @Override
  public OperationAssignmentFundingInformationCreateResponse create(
    OperationAssignmentFundingInformationCreateRequest request
  ) {
    OperationAssignment operationAssignment = operationAssignmentRepository
      .findByIdAndActiveIsTrue(request.getAssignmentId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    OperationAssignmentFundingInformation operationAssignmentFundingInformation = operationAssignmentFundingInformationRepository.save(
      OperationAssignmentFundingInformation.builder().assignment(operationAssignment).build()
    );

    return OperationAssignmentFundingInformationCreateResponse
      .builder()
      .assignmentFundingInformationId(operationAssignmentFundingInformation.getId())
      .build();
  }

  @Override
  public OperationAssignmentFundingInformationUpdateResponse update(
    OperationAssignmentFundingInformationUpdateRequest request
  ) {
    OperationAssignmentFundingInformation operationAssignmentFundingInformation = operationAssignmentFundingInformationRepository
      .findByIdAndActiveIsTrue(request.getAssignmentFundingInformationId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    operationAssignmentFundingInformation.setAmount(request.getAmount());
    operationAssignmentFundingInformation.setTenor(request.getTenor());
    operationAssignmentFundingInformation.setInstallmentAmount(request.getInstallmentAmount());
    operationAssignmentFundingInformation.setFundingMethod(request.getFundingMethod());
    operationAssignmentFundingInformation.setBankName(request.getBankName());
    operationAssignmentFundingInformation.setBankAccountNumber(request.getBankAccountNumber());
    operationAssignmentFundingInformation.setBankAccountName(request.getBankAccountName());
    operationAssignmentFundingInformation.setBankAccountStatus(request.getBankAccountStatus());
    operationAssignmentFundingInformation.setEffectiveDate(request.getEffectiveDate());
    operationAssignmentFundingInformationRepository.save(operationAssignmentFundingInformation);

    return OperationAssignmentFundingInformationUpdateResponse
      .builder()
      .assignmentFundingInformationId(operationAssignmentFundingInformation.getId())
      .assignmentId(operationAssignmentFundingInformation.getAssignment().getId())
      .build();
  }

  @Override
  public List<OperationAssignmentFundingInformationResponse> findAll() {
    List<OperationAssignmentFundingInformation> operationAssignmentFundingInformations = Streamable
      .of(operationAssignmentFundingInformationRepository.findAllByActiveIsTrue())
      .toList();

    List<OperationAssignmentFundingInformationResponse> result = new ArrayList<>();
    operationAssignmentFundingInformations.forEach(operationAssignmentFundingInformation -> {
      result.add(
        OperationAssignmentFundingInformationResponse
          .builder()
          .assignmentFundingInformationId(operationAssignmentFundingInformation.getId())
          .assignmentId(operationAssignmentFundingInformation.getAssignment().getId())
          .amount(operationAssignmentFundingInformation.getAmount())
          .tenor(operationAssignmentFundingInformation.getTenor())
          .installmentAmount(operationAssignmentFundingInformation.getInstallmentAmount())
          .fundingMethod(operationAssignmentFundingInformation.getFundingMethod())
          .bankName(operationAssignmentFundingInformation.getBankName())
          .bankAccountNumber(operationAssignmentFundingInformation.getBankAccountNumber())
          .bankAccountName(operationAssignmentFundingInformation.getBankAccountName())
          .bankAccountStatus(operationAssignmentFundingInformation.getBankAccountStatus())
          .effectiveDate(operationAssignmentFundingInformation.getEffectiveDate())
          .build()
      );
    });

    return result;
  }

  @Override
  public OperationAssignmentFundingInformationResponse findById(Long id) {
    OperationAssignmentFundingInformation operationAssignmentFundingInformation = operationAssignmentFundingInformationRepository
      .findByIdAndActiveIsTrue(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return OperationAssignmentFundingInformationResponse
      .builder()
      .assignmentFundingInformationId(operationAssignmentFundingInformation.getId())
      .assignmentId(operationAssignmentFundingInformation.getAssignment().getId())
      .amount(operationAssignmentFundingInformation.getAmount())
      .tenor(operationAssignmentFundingInformation.getTenor())
      .installmentAmount(operationAssignmentFundingInformation.getInstallmentAmount())
      .fundingMethod(operationAssignmentFundingInformation.getFundingMethod())
      .bankName(operationAssignmentFundingInformation.getBankName())
      .bankAccountNumber(operationAssignmentFundingInformation.getBankAccountNumber())
      .bankAccountName(operationAssignmentFundingInformation.getBankAccountName())
      .bankAccountStatus(operationAssignmentFundingInformation.getBankAccountStatus())
      .effectiveDate(operationAssignmentFundingInformation.getEffectiveDate())
      .build();
  }

  @Override
  public OperationAssignmentFundingInformationResponse findByAssignmentId(Long assignmentId) {
    OperationAssignmentFundingInformation operationAssignmentFundingInformation = operationAssignmentFundingInformationRepository
      .findByAssignmentIdAndActiveIsTrue(assignmentId)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return OperationAssignmentFundingInformationResponse
      .builder()
      .assignmentFundingInformationId(operationAssignmentFundingInformation.getId())
      .assignmentId(operationAssignmentFundingInformation.getAssignment().getId())
      .amount(operationAssignmentFundingInformation.getAmount())
      .tenor(operationAssignmentFundingInformation.getTenor())
      .installmentAmount(operationAssignmentFundingInformation.getInstallmentAmount())
      .fundingMethod(operationAssignmentFundingInformation.getFundingMethod())
      .bankName(operationAssignmentFundingInformation.getBankName())
      .bankAccountNumber(operationAssignmentFundingInformation.getBankAccountNumber())
      .bankAccountName(operationAssignmentFundingInformation.getBankAccountName())
      .bankAccountStatus(operationAssignmentFundingInformation.getBankAccountStatus())
      .effectiveDate(operationAssignmentFundingInformation.getEffectiveDate())
      .build();
  }
}

package com.bfi.bravo.service.impl;

import com.bfi.bravo.dto.operation.request.OperationAssignmentThirdPartyInformationCreateRequest;
import com.bfi.bravo.dto.operation.request.OperationAssignmentThirdPartyInformationUpdateRequest;
import com.bfi.bravo.dto.operation.response.OperationAssignmentThirdPartyInformationCreateResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentThirdPartyInformationResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentThirdPartyInformationUpdateResponse;
import com.bfi.bravo.entity.OperationAssignment;
import com.bfi.bravo.entity.OperationAssignmentThirdPartyInformation;
import com.bfi.bravo.repository.OperationAssignmentRepository;
import com.bfi.bravo.repository.OperationAssignmentThirdPartyInformationRepository;
import com.bfi.bravo.service.OperationAssignmentThirdPartyInformationService;
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
public class OperationAssignmentThirdPartyInformationServiceImpl implements OperationAssignmentThirdPartyInformationService {

  @Autowired
  private OperationAssignmentThirdPartyInformationRepository operationAssignmentThirdPartyInformationRepository;

  @Autowired
  private OperationAssignmentRepository operationAssignmentRepository;

  @Override
  public OperationAssignmentThirdPartyInformationCreateResponse create(
    OperationAssignmentThirdPartyInformationCreateRequest request
  ) {
    OperationAssignment operationAssignment = operationAssignmentRepository
      .findByIdAndActiveIsTrue(request.getAssignmentId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    OperationAssignmentThirdPartyInformation operationAssignmentThirdPartyInformation = operationAssignmentThirdPartyInformationRepository.save(
      OperationAssignmentThirdPartyInformation.builder().assignment(operationAssignment).build()
    );

    return OperationAssignmentThirdPartyInformationCreateResponse
      .builder()
      .assignmentThirdPartyInformationId(operationAssignmentThirdPartyInformation.getId())
      .build();
  }

  @Override
  public OperationAssignmentThirdPartyInformationUpdateResponse update(
    OperationAssignmentThirdPartyInformationUpdateRequest request
  ) {
    OperationAssignmentThirdPartyInformation operationAssignmentThirdPartyInformation = operationAssignmentThirdPartyInformationRepository
      .findByIdAndActiveIsTrue(request.getAssignmentThirdPartyInformationId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    operationAssignmentThirdPartyInformation.setGuarantorName(request.getGuarantorName());
    operationAssignmentThirdPartyInformation.setGuarantorIdentityNumber(request.getGuarantorIdentityNumber());
    operationAssignmentThirdPartyInformation.setGuarantorAddress(request.getGuarantorAddress());
    operationAssignmentThirdPartyInformationRepository.save(operationAssignmentThirdPartyInformation);

    return OperationAssignmentThirdPartyInformationUpdateResponse
      .builder()
      .assignmentThirdPartyInformationId(operationAssignmentThirdPartyInformation.getId())
      .assignmentId(operationAssignmentThirdPartyInformation.getAssignment().getId())
      .build();
  }

  @Override
  public List<OperationAssignmentThirdPartyInformationResponse> findAll() {
    List<OperationAssignmentThirdPartyInformation> operationAssignmentThirdPartyInformations = Streamable
      .of(operationAssignmentThirdPartyInformationRepository.findAllByActiveIsTrue())
      .toList();

    List<OperationAssignmentThirdPartyInformationResponse> result = new ArrayList<>();
    operationAssignmentThirdPartyInformations.forEach(operationAssignmentThirdPartyInformation -> {
      result.add(
        OperationAssignmentThirdPartyInformationResponse
          .builder()
          .assignmentThirdPartyInformationId(operationAssignmentThirdPartyInformation.getId())
          .assignmentId(operationAssignmentThirdPartyInformation.getAssignment().getId())
          .guarantorName(operationAssignmentThirdPartyInformation.getGuarantorName())
          .guarantorIdentityNumber(operationAssignmentThirdPartyInformation.getGuarantorIdentityNumber())
          .guarantorAddress(operationAssignmentThirdPartyInformation.getGuarantorAddress())
          .build()
      );
    });

    return result;
  }

  @Override
  public OperationAssignmentThirdPartyInformationResponse findById(Long id) {
    OperationAssignmentThirdPartyInformation operationAssignmentThirdPartyInformation = operationAssignmentThirdPartyInformationRepository
      .findByIdAndActiveIsTrue(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return OperationAssignmentThirdPartyInformationResponse
      .builder()
      .assignmentThirdPartyInformationId(operationAssignmentThirdPartyInformation.getId())
      .assignmentId(operationAssignmentThirdPartyInformation.getAssignment().getId())
      .guarantorName(operationAssignmentThirdPartyInformation.getGuarantorName())
      .guarantorIdentityNumber(operationAssignmentThirdPartyInformation.getGuarantorIdentityNumber())
      .guarantorAddress(operationAssignmentThirdPartyInformation.getGuarantorAddress())
      .build();
  }

  @Override
  public OperationAssignmentThirdPartyInformationResponse findByAssignmentId(Long assignmentId) {
    OperationAssignmentThirdPartyInformation operationAssignmentThirdPartyInformation = operationAssignmentThirdPartyInformationRepository
      .findByAssignmentIdAndActiveIsTrue(assignmentId)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return OperationAssignmentThirdPartyInformationResponse
      .builder()
      .assignmentThirdPartyInformationId(operationAssignmentThirdPartyInformation.getId())
      .assignmentId(operationAssignmentThirdPartyInformation.getAssignment().getId())
      .guarantorName(operationAssignmentThirdPartyInformation.getGuarantorName())
      .guarantorIdentityNumber(operationAssignmentThirdPartyInformation.getGuarantorIdentityNumber())
      .guarantorAddress(operationAssignmentThirdPartyInformation.getGuarantorAddress())
      .build();
  }
}

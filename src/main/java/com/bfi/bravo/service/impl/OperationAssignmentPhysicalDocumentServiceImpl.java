package com.bfi.bravo.service.impl;

import com.bfi.bravo.dto.operation.request.OperationAssignmentPhysicalDocumentCreateRequest;
import com.bfi.bravo.dto.operation.request.OperationAssignmentPhysicalDocumentUpdateRequest;
import com.bfi.bravo.dto.operation.response.OperationAssignmentPhysicalDocumentCreateResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentPhysicalDocumentResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentPhysicalDocumentUpdateResponse;
import com.bfi.bravo.entity.OperationAssignment;
import com.bfi.bravo.entity.OperationAssignmentPhysicalDocument;
import com.bfi.bravo.repository.OperationAssignmentPhysicalDocumentRepository;
import com.bfi.bravo.repository.OperationAssignmentRepository;
import com.bfi.bravo.service.OperationAssignmentPhysicalDocumentService;
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
public class OperationAssignmentPhysicalDocumentServiceImpl implements OperationAssignmentPhysicalDocumentService {

  @Autowired
  private OperationAssignmentPhysicalDocumentRepository operationAssignmentPhysicalDocumentRepository;

  @Autowired
  private OperationAssignmentRepository operationAssignmentRepository;

  @Override
  public OperationAssignmentPhysicalDocumentCreateResponse create(
    OperationAssignmentPhysicalDocumentCreateRequest request
  ) {
    OperationAssignment operationAssignment = operationAssignmentRepository
      .findByIdAndActiveIsTrue(request.getAssignmentId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    OperationAssignmentPhysicalDocument operationAssignmentPhysicalDocument = operationAssignmentPhysicalDocumentRepository.save(
      OperationAssignmentPhysicalDocument.builder().assignment(operationAssignment).build()
    );

    return OperationAssignmentPhysicalDocumentCreateResponse
      .builder()
      .assignmentPhysicalDocumentId(operationAssignmentPhysicalDocument.getId())
      .build();
  }

  @Override
  public OperationAssignmentPhysicalDocumentUpdateResponse update(
    OperationAssignmentPhysicalDocumentUpdateRequest request
  ) {
    OperationAssignmentPhysicalDocument operationAssignmentPhysicalDocument = operationAssignmentPhysicalDocumentRepository
      .findByIdAndActiveIsTrue(request.getAssignmentPhysicalDocumentId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    operationAssignmentPhysicalDocument.setVehicleOwnershipValid(request.isVehicleOwnershipValid());
    operationAssignmentPhysicalDocument.setTaxNoticeValid(request.isTaxNoticeValid());
    operationAssignmentPhysicalDocument.setVehicleRegistrationValid(request.isVehicleRegistrationValid());
    operationAssignmentPhysicalDocumentRepository.save(operationAssignmentPhysicalDocument);

    return OperationAssignmentPhysicalDocumentUpdateResponse
      .builder()
      .assignmentPhysicalDocumentId(operationAssignmentPhysicalDocument.getId())
      .assignmentId(operationAssignmentPhysicalDocument.getAssignment().getId())
      .build();
  }

  @Override
  public List<OperationAssignmentPhysicalDocumentResponse> findAll() {
    List<OperationAssignmentPhysicalDocument> operationAssignmentPhysicalDocuments = Streamable
      .of(operationAssignmentPhysicalDocumentRepository.findAllByActiveIsTrue())
      .toList();

    List<OperationAssignmentPhysicalDocumentResponse> result = new ArrayList<>();
    operationAssignmentPhysicalDocuments.forEach(operationAssignmentPhysicalDocument -> {
      result.add(
        OperationAssignmentPhysicalDocumentResponse
          .builder()
          .assignmentPhysicalDocumentId(operationAssignmentPhysicalDocument.getId())
          .assignmentId(operationAssignmentPhysicalDocument.getAssignment().getId())
          .vehicleOwnershipValid(operationAssignmentPhysicalDocument.isVehicleOwnershipValid())
          .taxNoticeValid(operationAssignmentPhysicalDocument.isTaxNoticeValid())
          .vehicleRegistrationValid(operationAssignmentPhysicalDocument.isVehicleRegistrationValid())
          .build()
      );
    });

    return result;
  }

  @Override
  public OperationAssignmentPhysicalDocumentResponse findById(Long id) {
    OperationAssignmentPhysicalDocument operationAssignmentPhysicalDocument = operationAssignmentPhysicalDocumentRepository
      .findByIdAndActiveIsTrue(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return OperationAssignmentPhysicalDocumentResponse
      .builder()
      .assignmentPhysicalDocumentId(operationAssignmentPhysicalDocument.getId())
      .assignmentId(operationAssignmentPhysicalDocument.getAssignment().getId())
      .vehicleOwnershipValid(operationAssignmentPhysicalDocument.isVehicleOwnershipValid())
      .taxNoticeValid(operationAssignmentPhysicalDocument.isTaxNoticeValid())
      .vehicleRegistrationValid(operationAssignmentPhysicalDocument.isVehicleRegistrationValid())
      .build();
  }

  @Override
  public OperationAssignmentPhysicalDocumentResponse findByAssignmentId(Long assignmentId) {
    OperationAssignmentPhysicalDocument operationAssignmentPhysicalDocument = operationAssignmentPhysicalDocumentRepository
      .findByAssignmentIdAndActiveIsTrue(assignmentId)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return OperationAssignmentPhysicalDocumentResponse
      .builder()
      .assignmentPhysicalDocumentId(operationAssignmentPhysicalDocument.getId())
      .assignmentId(operationAssignmentPhysicalDocument.getAssignment().getId())
      .vehicleOwnershipValid(operationAssignmentPhysicalDocument.isVehicleOwnershipValid())
      .taxNoticeValid(operationAssignmentPhysicalDocument.isTaxNoticeValid())
      .vehicleRegistrationValid(operationAssignmentPhysicalDocument.isVehicleRegistrationValid())
      .build();
  }
}

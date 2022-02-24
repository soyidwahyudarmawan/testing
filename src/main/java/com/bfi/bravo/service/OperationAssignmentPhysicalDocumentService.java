package com.bfi.bravo.service;

import com.bfi.bravo.dto.operation.request.OperationAssignmentPhysicalDocumentCreateRequest;
import com.bfi.bravo.dto.operation.request.OperationAssignmentPhysicalDocumentUpdateRequest;
import com.bfi.bravo.dto.operation.response.OperationAssignmentPhysicalDocumentCreateResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentPhysicalDocumentResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentPhysicalDocumentUpdateResponse;

import java.util.List;

public interface OperationAssignmentPhysicalDocumentService {
  public OperationAssignmentPhysicalDocumentCreateResponse create(
    OperationAssignmentPhysicalDocumentCreateRequest request
  );

  public OperationAssignmentPhysicalDocumentUpdateResponse update(
    OperationAssignmentPhysicalDocumentUpdateRequest request
  );

  public List<OperationAssignmentPhysicalDocumentResponse> findAll();

  public OperationAssignmentPhysicalDocumentResponse findById(Long id);

  public OperationAssignmentPhysicalDocumentResponse findByAssignmentId(Long assignmentId);
}

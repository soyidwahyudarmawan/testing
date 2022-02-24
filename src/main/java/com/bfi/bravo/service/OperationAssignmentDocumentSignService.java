package com.bfi.bravo.service;

import com.bfi.bravo.dto.operation.request.OperationAssignmentDocumentSignCreateRequest;
import com.bfi.bravo.dto.operation.request.OperationAssignmentDocumentSignUpdateRequest;
import com.bfi.bravo.dto.operation.response.OperationAssignmentDocumentSignCreateResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentDocumentSignResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentDocumentSignUpdateResponse;

import java.util.List;

public interface OperationAssignmentDocumentSignService {
  public OperationAssignmentDocumentSignCreateResponse create(
    OperationAssignmentDocumentSignCreateRequest request
  );

  public OperationAssignmentDocumentSignUpdateResponse update(
    OperationAssignmentDocumentSignUpdateRequest request
  );

  public List<OperationAssignmentDocumentSignResponse> findAll();

  public OperationAssignmentDocumentSignResponse findById(Long id);

  public OperationAssignmentDocumentSignResponse findByAssignmentId(Long assignmentId);
}

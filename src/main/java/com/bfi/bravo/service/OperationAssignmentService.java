package com.bfi.bravo.service;

import com.bfi.bravo.dto.operation.request.OperationAssignmentCreateRequest;
import com.bfi.bravo.dto.operation.response.OperationAssignmentCdpResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentCreateResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentRcoResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentResponse;

import java.util.List;

public interface OperationAssignmentService {
  public OperationAssignmentCreateResponse create(OperationAssignmentCreateRequest request);
  public List<OperationAssignmentResponse> findAll();
  public OperationAssignmentResponse findById(Long id);
  public List<OperationAssignmentCdpResponse> findAllCdpResponse();
  public List<OperationAssignmentRcoResponse> findAllRcoResponse();
}

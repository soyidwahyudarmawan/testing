package com.bfi.bravo.service;

import com.bfi.bravo.dto.operation.request.OperationAssignmentAssetDataCreateRequest;
import com.bfi.bravo.dto.operation.request.OperationAssignmentAssetDataUpdateRequest;
import com.bfi.bravo.dto.operation.response.OperationAssignmentAssetDataCreateResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentAssetDataResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentAssetDataUpdateResponse;

import java.util.List;

public interface OperationAssignmentAssetDataService {
  public OperationAssignmentAssetDataCreateResponse create(
    OperationAssignmentAssetDataCreateRequest request
  );

  public OperationAssignmentAssetDataUpdateResponse update(
    OperationAssignmentAssetDataUpdateRequest request
  );

  public List<OperationAssignmentAssetDataResponse> findAll();

  public OperationAssignmentAssetDataResponse findById(Long id);

  public OperationAssignmentAssetDataResponse findByAssignmentId(Long assignmentId);
}

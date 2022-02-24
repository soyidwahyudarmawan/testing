package com.bfi.bravo.service;

import com.bfi.bravo.dto.operation.request.OperationAssignmentFundingInformationCreateRequest;
import com.bfi.bravo.dto.operation.request.OperationAssignmentFundingInformationUpdateRequest;
import com.bfi.bravo.dto.operation.response.OperationAssignmentFundingInformationCreateResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentFundingInformationResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentFundingInformationUpdateResponse;

import java.util.List;

public interface OperationAssignmentFundingInformationService {
  public OperationAssignmentFundingInformationCreateResponse create(
    OperationAssignmentFundingInformationCreateRequest request
  );

  public OperationAssignmentFundingInformationUpdateResponse update(
    OperationAssignmentFundingInformationUpdateRequest request
  );

  public List<OperationAssignmentFundingInformationResponse> findAll();

  public OperationAssignmentFundingInformationResponse findById(Long id);

  public OperationAssignmentFundingInformationResponse findByAssignmentId(Long assignmentId);
}

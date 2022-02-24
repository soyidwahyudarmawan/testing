package com.bfi.bravo.service;

import com.bfi.bravo.dto.operation.request.OperationAssignmentThirdPartyInformationCreateRequest;
import com.bfi.bravo.dto.operation.request.OperationAssignmentThirdPartyInformationUpdateRequest;
import com.bfi.bravo.dto.operation.response.OperationAssignmentThirdPartyInformationCreateResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentThirdPartyInformationResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentThirdPartyInformationUpdateResponse;

import java.util.List;

public interface OperationAssignmentThirdPartyInformationService {
  public OperationAssignmentThirdPartyInformationCreateResponse create(
    OperationAssignmentThirdPartyInformationCreateRequest request
  );

  public OperationAssignmentThirdPartyInformationUpdateResponse update(
    OperationAssignmentThirdPartyInformationUpdateRequest request
  );

  public List<OperationAssignmentThirdPartyInformationResponse> findAll();

  public OperationAssignmentThirdPartyInformationResponse findById(Long id);

  public OperationAssignmentThirdPartyInformationResponse findByAssignmentId(Long assignmentId);
}

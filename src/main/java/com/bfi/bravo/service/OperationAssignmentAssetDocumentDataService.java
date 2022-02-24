package com.bfi.bravo.service;

import com.bfi.bravo.dto.operation.request.OperationAssignmentAssetDocumentDataChecklistUpdateRequest;
import com.bfi.bravo.dto.operation.request.OperationAssignmentAssetDocumentDataCreateRequest;
import com.bfi.bravo.dto.operation.request.OperationAssignmentAssetDocumentDataTaxNoticeUpdateRequest;
import com.bfi.bravo.dto.operation.request.OperationAssignmentAssetDocumentDataVehicleRegistrationUpdateRequest;
import com.bfi.bravo.dto.operation.request.OperationAssignmentAssetDocumentDataVehicleOwnershipUpdateRequest;
import com.bfi.bravo.dto.operation.response.OperationAssignmentAssetDocumentDataChecklistUpdateResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentAssetDocumentDataCreateResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentAssetDocumentDataTaxNoticeUpdateResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentAssetDocumentDataVehicleRegistrationUpdateResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentAssetDocumentDataVehicleOwnershipUpdateResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentAssetDocumentDataResponse;

import java.util.List;

public interface OperationAssignmentAssetDocumentDataService {
  public OperationAssignmentAssetDocumentDataCreateResponse create(
    OperationAssignmentAssetDocumentDataCreateRequest request
  );

  public OperationAssignmentAssetDocumentDataChecklistUpdateResponse updateChecklist(
    OperationAssignmentAssetDocumentDataChecklistUpdateRequest request
  );

  public OperationAssignmentAssetDocumentDataVehicleOwnershipUpdateResponse updateVehicleOwnership(
    OperationAssignmentAssetDocumentDataVehicleOwnershipUpdateRequest request
  );

  public OperationAssignmentAssetDocumentDataVehicleRegistrationUpdateResponse updateVehicleRegistration(
    OperationAssignmentAssetDocumentDataVehicleRegistrationUpdateRequest request
  );

  public OperationAssignmentAssetDocumentDataTaxNoticeUpdateResponse updateTaxNotice(
    OperationAssignmentAssetDocumentDataTaxNoticeUpdateRequest request
  );

  public List<OperationAssignmentAssetDocumentDataResponse> findAll();

  public OperationAssignmentAssetDocumentDataResponse findById(Long id);

  public OperationAssignmentAssetDocumentDataResponse findByAssignmentId(Long assignmentId);
}

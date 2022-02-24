package com.bfi.bravo.controller;

import com.bfi.bravo.dto.operation.request.*;
import com.bfi.bravo.dto.operation.response.*;
import com.bfi.bravo.service.OperationAssignmentAssetDocumentDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/operation-assignment-asset-document-data")
@Tag(name = "Operation Assignment Asset Document Data API", description = "CRUD operation assignment asset document data")
public class OperationAssignmentAssetDocumentDataController {

  @Autowired
  private OperationAssignmentAssetDocumentDataService operationAssignmentAssetDocumentDataService;

  @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create", description = "Create operation assignment asset document data")
  @ResponseStatus(HttpStatus.CREATED)
  public OperationAssignmentAssetDocumentDataCreateResponse create(
    @Valid @RequestBody OperationAssignmentAssetDocumentDataCreateRequest request
  ) {
    return operationAssignmentAssetDocumentDataService.create(request);
  }

  @PutMapping(value = "/checklist", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Update", description = "Update operation assignment asset document data")
  public OperationAssignmentAssetDocumentDataChecklistUpdateResponse updateChecklist(
    @Valid @RequestBody OperationAssignmentAssetDocumentDataChecklistUpdateRequest request
  ) {
    return operationAssignmentAssetDocumentDataService.updateChecklist(request);
  }

  @PutMapping(value = "/vehicle-ownership", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Update", description = "Update operation assignment asset document data")
  public OperationAssignmentAssetDocumentDataVehicleOwnershipUpdateResponse updateVehicleOwnership(
    @Valid @RequestBody OperationAssignmentAssetDocumentDataVehicleOwnershipUpdateRequest request
  ) {
    return operationAssignmentAssetDocumentDataService.updateVehicleOwnership(request);
  }

  @PutMapping(value = "/vehicle-registration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Update", description = "Update operation assignment asset document data")
  public OperationAssignmentAssetDocumentDataVehicleRegistrationUpdateResponse updateVehicleRegistration(
    @Valid @RequestBody OperationAssignmentAssetDocumentDataVehicleRegistrationUpdateRequest request
  ) {
    return operationAssignmentAssetDocumentDataService.updateVehicleRegistration(request);
  }

  @PutMapping(value = "/tax-notice", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Update", description = "Update operation assignment asset document data")
  public OperationAssignmentAssetDocumentDataTaxNoticeUpdateResponse updateTaxNotice(
    @Valid @RequestBody OperationAssignmentAssetDocumentDataTaxNoticeUpdateRequest request
  ) {
    return operationAssignmentAssetDocumentDataService.updateTaxNotice(request);
  }

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get all", description = "Get all operation assignment asset document data")
  public List<OperationAssignmentAssetDocumentDataResponse> findAll() {
    return operationAssignmentAssetDocumentDataService.findAll();
  }

  @GetMapping(value = "/{assignmentAssetDocumentDataId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get one", description = "Get one operation assignment asset document data")
  public OperationAssignmentAssetDocumentDataResponse findById(@PathVariable Long assignmentAssetDocumentDataId) {
    return operationAssignmentAssetDocumentDataService.findById(assignmentAssetDocumentDataId);
  }

  @GetMapping(value = "/assignment/{assignmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get one", description = "Get one operation assignment asset document data by operation assignment id")
  public OperationAssignmentAssetDocumentDataResponse findByAssignmentId(@PathVariable Long assignmentId) {
    return operationAssignmentAssetDocumentDataService.findByAssignmentId(assignmentId);
  }
}

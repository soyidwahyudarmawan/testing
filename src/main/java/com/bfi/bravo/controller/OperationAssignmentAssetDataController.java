package com.bfi.bravo.controller;

import com.bfi.bravo.dto.operation.request.OperationAssignmentAssetDataCreateRequest;
import com.bfi.bravo.dto.operation.request.OperationAssignmentAssetDataUpdateRequest;
import com.bfi.bravo.dto.operation.response.OperationAssignmentAssetDataCreateResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentAssetDataResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentAssetDataUpdateResponse;
import com.bfi.bravo.service.OperationAssignmentAssetDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/operation-assignment-asset-data")
@Tag(name = "Operation Assignment Asset Data API", description = "CRUD operation assignment asset data")
public class OperationAssignmentAssetDataController {

  @Autowired
  private OperationAssignmentAssetDataService operationAssignmentAssetDataService;

  @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create", description = "Create operation assignment asset data")
  @ResponseStatus(HttpStatus.CREATED)
  public OperationAssignmentAssetDataCreateResponse create(
    @Valid @RequestBody OperationAssignmentAssetDataCreateRequest request
  ) {
    return operationAssignmentAssetDataService.create(request);
  }

  @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Update", description = "Update operation assignment asset data")
  public OperationAssignmentAssetDataUpdateResponse update(
    @Valid @RequestBody OperationAssignmentAssetDataUpdateRequest request
  ) {
    return operationAssignmentAssetDataService.update(request);
  }

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get all", description = "Get all operation assignment asset data")
  public List<OperationAssignmentAssetDataResponse> findAll() {
    return operationAssignmentAssetDataService.findAll();
  }

  @GetMapping(value = "/{assignmentAssetDataId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get one", description = "Get one operation assignment asset data")
  public OperationAssignmentAssetDataResponse findById(@PathVariable Long assignmentAssetDataId) {
    return operationAssignmentAssetDataService.findById(assignmentAssetDataId);
  }

  @GetMapping(value = "/assignment/{assignmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get one", description = "Get one operation assignment asset data by operation assignment id")
  public OperationAssignmentAssetDataResponse findByAssignmentId(@PathVariable Long assignmentId) {
    return operationAssignmentAssetDataService.findByAssignmentId(assignmentId);
  }
}

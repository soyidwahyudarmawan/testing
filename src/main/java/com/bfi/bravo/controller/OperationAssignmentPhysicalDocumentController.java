package com.bfi.bravo.controller;

import com.bfi.bravo.dto.operation.request.OperationAssignmentPhysicalDocumentCreateRequest;
import com.bfi.bravo.dto.operation.request.OperationAssignmentPhysicalDocumentUpdateRequest;
import com.bfi.bravo.dto.operation.response.OperationAssignmentPhysicalDocumentCreateResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentPhysicalDocumentResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentPhysicalDocumentUpdateResponse;
import com.bfi.bravo.service.OperationAssignmentPhysicalDocumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/operation-assignment-physical-document")
@Tag(name = "Operation Assignment Physical Document API", description = "CRUD operation assignment physical document")
public class OperationAssignmentPhysicalDocumentController {

  @Autowired
  private OperationAssignmentPhysicalDocumentService operationAssignmentPhysicalDocumentService;

  @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create", description = "Create operation assignment physical document")
  @ResponseStatus(HttpStatus.CREATED)
  public OperationAssignmentPhysicalDocumentCreateResponse create(
    @Valid @RequestBody OperationAssignmentPhysicalDocumentCreateRequest request
  ) {
    return operationAssignmentPhysicalDocumentService.create(request);
  }

  @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Update", description = "Update operation assignment physical document")
  public OperationAssignmentPhysicalDocumentUpdateResponse update(
    @Valid @RequestBody OperationAssignmentPhysicalDocumentUpdateRequest request
  ) {
    return operationAssignmentPhysicalDocumentService.update(request);
  }

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get all", description = "Get all operation assignment physical document")
  public List<OperationAssignmentPhysicalDocumentResponse> findAll() {
    return operationAssignmentPhysicalDocumentService.findAll();
  }

  @GetMapping(value = "/{assignmentPhysicalDocumentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get one", description = "Get one operation assignment physical document")
  public OperationAssignmentPhysicalDocumentResponse findById(@PathVariable Long assignmentPhysicalDocumentId) {
    return operationAssignmentPhysicalDocumentService.findById(assignmentPhysicalDocumentId);
  }

  @GetMapping(value = "/assignment/{assignmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get one", description = "Get one operation assignment physical document by operation assignment id")
  public OperationAssignmentPhysicalDocumentResponse findByAssignmentId(@PathVariable Long assignmentId) {
    return operationAssignmentPhysicalDocumentService.findByAssignmentId(assignmentId);
  }
}

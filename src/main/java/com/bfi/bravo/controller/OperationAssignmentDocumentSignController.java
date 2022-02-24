package com.bfi.bravo.controller;

import com.bfi.bravo.dto.operation.request.OperationAssignmentDocumentSignCreateRequest;
import com.bfi.bravo.dto.operation.request.OperationAssignmentDocumentSignUpdateRequest;
import com.bfi.bravo.dto.operation.response.OperationAssignmentDocumentSignCreateResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentDocumentSignResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentDocumentSignUpdateResponse;
import com.bfi.bravo.service.OperationAssignmentDocumentSignService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/operation-assignment-document-sign")
@Tag(name = "Operation Assignment Document Sign API", description = "CRUD operation assignment document sign")
public class OperationAssignmentDocumentSignController {

  @Autowired
  private OperationAssignmentDocumentSignService operationAssignmentDocumentSignService;

  @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create", description = "Create operation assignment document sign")
  @ResponseStatus(HttpStatus.CREATED)
  public OperationAssignmentDocumentSignCreateResponse create(
    @Valid @RequestBody OperationAssignmentDocumentSignCreateRequest request
  ) {
    return operationAssignmentDocumentSignService.create(request);
  }

  @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Update", description = "Update operation assignment document sign")
  public OperationAssignmentDocumentSignUpdateResponse update(
    @Valid @RequestBody OperationAssignmentDocumentSignUpdateRequest request
  ) {
    return operationAssignmentDocumentSignService.update(request);
  }

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get all", description = "Get all operation assignment document sign")
  public List<OperationAssignmentDocumentSignResponse> findAll() {
    return operationAssignmentDocumentSignService.findAll();
  }

  @GetMapping(value = "/{assignmentDocumentSignId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get one", description = "Get one operation assignment document sign")
  public OperationAssignmentDocumentSignResponse findById(@PathVariable Long assignmentDocumentSignId) {
    return operationAssignmentDocumentSignService.findById(assignmentDocumentSignId);
  }

  @GetMapping(value = "/assignment/{assignmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get one", description = "Get one operation assignment document sign by operation assignment id")
  public OperationAssignmentDocumentSignResponse findByAssignmentId(@PathVariable Long assignmentId) {
    return operationAssignmentDocumentSignService.findByAssignmentId(assignmentId);
  }
}

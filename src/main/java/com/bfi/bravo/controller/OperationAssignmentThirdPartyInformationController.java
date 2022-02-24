package com.bfi.bravo.controller;

import com.bfi.bravo.dto.operation.request.OperationAssignmentThirdPartyInformationCreateRequest;
import com.bfi.bravo.dto.operation.request.OperationAssignmentThirdPartyInformationUpdateRequest;
import com.bfi.bravo.dto.operation.response.OperationAssignmentThirdPartyInformationCreateResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentThirdPartyInformationResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentThirdPartyInformationUpdateResponse;
import com.bfi.bravo.service.OperationAssignmentThirdPartyInformationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/operation-assignment-third-party-information")
@Tag(name = "Operation Assignment Third Party Information API", description = "CRUD operation assignment third party information")
public class OperationAssignmentThirdPartyInformationController {

  @Autowired
  OperationAssignmentThirdPartyInformationService operationAssignmentThirdPartyInformationService;

  @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create", description = "Create operation assignment third party information")
  @ResponseStatus(HttpStatus.CREATED)
  public OperationAssignmentThirdPartyInformationCreateResponse create(
    @Valid @RequestBody OperationAssignmentThirdPartyInformationCreateRequest request
  ) {
    return operationAssignmentThirdPartyInformationService.create(request);
  }

  @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Update", description = "Update operation assignment third party information")
  public OperationAssignmentThirdPartyInformationUpdateResponse update(
    @Valid @RequestBody OperationAssignmentThirdPartyInformationUpdateRequest request
  ) {
    return operationAssignmentThirdPartyInformationService.update(request);
  }

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get all", description = "Get all operation assignment third party information")
  public List<OperationAssignmentThirdPartyInformationResponse> findAll() {
    return operationAssignmentThirdPartyInformationService.findAll();
  }

  @GetMapping(value = "/{assignmentThirdPartyInformationId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get one", description = "Get one operation assignment third party information")
  public OperationAssignmentThirdPartyInformationResponse findById(@PathVariable Long assignmentThirdPartyInformationId) {
    return operationAssignmentThirdPartyInformationService.findById(assignmentThirdPartyInformationId);
  }

  @GetMapping(value = "/assignment/{assignmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get one", description = "Get one operation assignment third party information by operation assignment id")
  public OperationAssignmentThirdPartyInformationResponse findByAssignmentId(@PathVariable Long assignmentId) {
    return operationAssignmentThirdPartyInformationService.findByAssignmentId(assignmentId);
  }
}

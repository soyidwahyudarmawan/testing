package com.bfi.bravo.controller;

import com.bfi.bravo.dto.operation.request.OperationAssignmentFundingInformationCreateRequest;
import com.bfi.bravo.dto.operation.request.OperationAssignmentFundingInformationUpdateRequest;
import com.bfi.bravo.dto.operation.response.OperationAssignmentFundingInformationCreateResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentFundingInformationResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentFundingInformationUpdateResponse;
import com.bfi.bravo.service.OperationAssignmentFundingInformationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/operation-assignment-funding-information")
@Tag(name = "Operation Assignment Funding Information API", description = "CRUD operation assignment funding information")
public class OperationAssignmentFundingInformationController {

  @Autowired
  private OperationAssignmentFundingInformationService operationAssignmentFundingInformationService;

  @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create", description = "Create operation assignment funding information")
  @ResponseStatus(HttpStatus.CREATED)
  public OperationAssignmentFundingInformationCreateResponse create(
    @Valid @RequestBody OperationAssignmentFundingInformationCreateRequest request
  ) {
    return operationAssignmentFundingInformationService.create(request);
  }

  @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Update", description = "Update operation assignment funding information")
  public OperationAssignmentFundingInformationUpdateResponse update(
    @Valid @RequestBody OperationAssignmentFundingInformationUpdateRequest request
  ) {
    return operationAssignmentFundingInformationService.update(request);
  }

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get all", description = "Get all operation assignment funding information")
  public List<OperationAssignmentFundingInformationResponse> findAll() {
    return operationAssignmentFundingInformationService.findAll();
  }

  @GetMapping(value = "/{assignmentFundingInformationId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get one", description = "Get one operation assignment funding information")
  public OperationAssignmentFundingInformationResponse findById(@PathVariable Long assignmentFundingInformationId) {
    return operationAssignmentFundingInformationService.findById(assignmentFundingInformationId);
  }

  @GetMapping(value = "/assignment/{assignmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get one", description = "Get one operation assignment funding information by operation assignment id")
  public OperationAssignmentFundingInformationResponse findByAssignmentId(@PathVariable Long assignmentId) {
    return operationAssignmentFundingInformationService.findByAssignmentId(assignmentId);
  }
}

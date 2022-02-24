package com.bfi.bravo.controller;

import com.bfi.bravo.dto.operation.request.OperationAssignmentCreateRequest;
import com.bfi.bravo.dto.operation.response.OperationAssignmentCdpResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentCreateResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentRcoResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentResponse;
import com.bfi.bravo.service.OperationAssignmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.bfi.bravo.constant.AppConstants.DEFAULT_ACCESS_ROLE;

@RestController
@RequestMapping(value = "/v1/operation-assignment")
@Tag(name = "Operation Assignment API", description = "CRUD operation assignment")
public class OperationAssignmentController {

  @Autowired
  private OperationAssignmentService operationAssignmentService;

  @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create", description = "Create operation assignment")
  @ResponseStatus(HttpStatus.CREATED)
  public OperationAssignmentCreateResponse create(
    @Valid @RequestBody OperationAssignmentCreateRequest request
  ) {
    return operationAssignmentService.create(request);
  }

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get all", description = "Get all operation assignment")
  public List<OperationAssignmentResponse> findAll() {
    return operationAssignmentService.findAll();
  }

  @GetMapping(value = "/{assignmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get one", description = "Get one operation assignment")
  public OperationAssignmentResponse findById(@PathVariable Long assignmentId) {
    return operationAssignmentService.findById(assignmentId);
  }

  @GetMapping(value = "/my-assignment/cdp", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get my assignment by role cdp", description = "Get my assignment by role cdp")
  @PreAuthorize("hasRole('ROLE_CDP') or " + DEFAULT_ACCESS_ROLE)
  public List<OperationAssignmentCdpResponse> findAllCdpResponse(){
    return operationAssignmentService.findAllCdpResponse();
  }

  @GetMapping(value = "/my-assignment/rco", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get my assignment by role rco", description = "Get my assignment by role rco")
  @PreAuthorize("hasRole('ROLE_RCO') or " + DEFAULT_ACCESS_ROLE)
  public List<OperationAssignmentRcoResponse> findAllRcoResponse(){
    return operationAssignmentService.findAllRcoResponse();
  }
}

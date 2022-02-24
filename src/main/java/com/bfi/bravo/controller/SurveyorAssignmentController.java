package com.bfi.bravo.controller;

import static com.bfi.bravo.constant.AppConstants.DEFAULT_ACCESS_ROLE;

import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentCreateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentPhysicalDocumentSubmitUpdateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentPhysicalDocumentSubmitsUpdateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentSurveyDoneUpdateRequest;
import com.bfi.bravo.dto.surveyor.response.*;
import com.bfi.bravo.service.SurveyorAssignmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/surveyor-assignment")
@Tag(name = "Surveyor Assignment API", description = "CRUD surveyor assignment")
public class SurveyorAssignmentController {

  @Autowired
  private SurveyorAssignmentService surveyorAssignmentService;

  @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create", description = "Create surveyor assignment")
  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentCreateResponse create(@Valid @RequestBody SurveyorAssignmentCreateRequest request) {
    return surveyorAssignmentService.create(request);
  }

  @PutMapping(
    value = "/survey-done",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @Operation(summary = "Survey done", description = "Update surveyor assignment survey done")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentSurveyDoneUpdateResponse surveyDone(
    @Valid @RequestBody SurveyorAssignmentSurveyDoneUpdateRequest request
  ) {
    return surveyorAssignmentService.surveyDone(request);
  }

  @PutMapping(
    value = "/physical-document-submit",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @Operation(summary = "Physical document submit", description = "Update surveyor assignment physical document submit")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentPhysicalDocumentSubmitUpdateResponse physicalDocumentSubmit(
    @Valid @RequestBody SurveyorAssignmentPhysicalDocumentSubmitUpdateRequest request
  ) {
    return surveyorAssignmentService.physicalDocumentSubmit(request);
  }

  @PutMapping(
    value = "/physical-document-submits",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @Operation(summary = "Physical document submit", description = "Update surveyor assignment physical document submit")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentPhysicalDocumentSubmitsUpdateResponse physicalDocumentSubmit(
    @Valid @RequestBody SurveyorAssignmentPhysicalDocumentSubmitsUpdateRequest request
  ) {
    return surveyorAssignmentService.physicalDocumentSubmits(request);
  }

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get all", description = "Get all surveyor assignment")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public List<SurveyorAssignmentResponse> findAll() {
    return surveyorAssignmentService.findAll();
  }

  @GetMapping(value = "/{assignmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get one", description = "Get one surveyor assignment")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentResponse findById(@PathVariable Long assignmentId) {
    return surveyorAssignmentService.findById(assignmentId);
  }

  @GetMapping(value = "/surveyor/{surveyorId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get all by surveyor", description = "Get all surveyor assignment by surveyor")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public List<SurveyorAssignmentResponse> findAllBySurveyorId(@PathVariable String surveyorId) {
    return surveyorAssignmentService.findAllBySurveyorId(surveyorId);
  }
}

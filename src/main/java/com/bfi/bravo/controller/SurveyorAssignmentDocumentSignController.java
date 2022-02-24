package com.bfi.bravo.controller;

import static com.bfi.bravo.constant.AppConstants.DEFAULT_ACCESS_ROLE;

import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentDocumentSignCreateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentDocumentSignUpdateRequest;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentDocumentSignCreateResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentDocumentSignResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentDocumentSignUpdateResponse;
import com.bfi.bravo.service.SurveyorAssignmentDocumentSignService;
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
@RequestMapping(value = "/v1/surveyor-assignment-document-sign")
@Tag(name = "Surveyor Assignment Document Sign API", description = "CRUD surveyor assignment document sign")
public class SurveyorAssignmentDocumentSignController {

  @Autowired
  private SurveyorAssignmentDocumentSignService surveyorAssignmentDocumentSignService;

  @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create", description = "Create surveyor assignment document sign")
  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentDocumentSignCreateResponse create(
    @Valid @RequestBody SurveyorAssignmentDocumentSignCreateRequest request
  ) {
    return surveyorAssignmentDocumentSignService.create(request);
  }

  @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Update", description = "Update surveyor assignment document sign")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentDocumentSignUpdateResponse update(
    @Valid @RequestBody SurveyorAssignmentDocumentSignUpdateRequest request
  ) {
    return surveyorAssignmentDocumentSignService.update(request);
  }

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get all", description = "Get all surveyor assignment document sign")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public List<SurveyorAssignmentDocumentSignResponse> findAll() {
    return surveyorAssignmentDocumentSignService.findAll();
  }

  @GetMapping(value = "/{assignmentDocumentSignId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get one", description = "Get one surveyor assignment document sign")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentDocumentSignResponse findById(@PathVariable Long assignmentDocumentSignId) {
    return surveyorAssignmentDocumentSignService.findById(assignmentDocumentSignId);
  }

  @GetMapping(value = "/assignment/{assignmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get one", description = "Get one surveyor assignment document sign by surveyor assignment id")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentDocumentSignResponse findByAssignmentId(@PathVariable Long assignmentId) {
    return surveyorAssignmentDocumentSignService.findByAssignmentId(assignmentId);
  }
}

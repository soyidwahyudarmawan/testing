package com.bfi.bravo.controller;

import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentPhysicalDocumentCreateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentPhysicalDocumentUpdateRequest;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentPhysicalDocumentCreateResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentPhysicalDocumentResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentPhysicalDocumentUpdateResponse;
import com.bfi.bravo.service.SurveyorAssignmentPhysicalDocumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/surveyor-assignment-physical-document")
@Tag(name = "Surveyor Assignment Physical Document API", description = "CRUD surveyor assignment physical document")
public class SurveyorAssignmentPhysicalDocumentController {

  @Autowired
  private SurveyorAssignmentPhysicalDocumentService surveyorAssignmentPhysicalDocumentService;

  @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create", description = "Create surveyor assignment physical document")
  @ResponseStatus(HttpStatus.CREATED)
  public SurveyorAssignmentPhysicalDocumentCreateResponse create(
    @Valid @RequestBody SurveyorAssignmentPhysicalDocumentCreateRequest request
  ) {
    return surveyorAssignmentPhysicalDocumentService.create(request);
  }

  @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Update", description = "Update surveyor assignment physical document")
  public SurveyorAssignmentPhysicalDocumentUpdateResponse update(
    @Valid @RequestBody SurveyorAssignmentPhysicalDocumentUpdateRequest request
  ) {
    return surveyorAssignmentPhysicalDocumentService.update(request);
  }

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get all", description = "Get all surveyor assignment physical document")
  public List<SurveyorAssignmentPhysicalDocumentResponse> findAll() {
    return surveyorAssignmentPhysicalDocumentService.findAll();
  }

  @GetMapping(value = "/{assignmentPhysicalDocumentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get one", description = "Get one surveyor assignment physical document")
  public SurveyorAssignmentPhysicalDocumentResponse findById(@PathVariable Long assignmentPhysicalDocumentId) {
    return surveyorAssignmentPhysicalDocumentService.findById(assignmentPhysicalDocumentId);
  }

  @GetMapping(value = "/assignment/{assignmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(
    summary = "Get one",
    description = "Get one surveyor assignment physical document by surveyor assignment id"
  )
  public SurveyorAssignmentPhysicalDocumentResponse findByAssignmentId(@PathVariable Long assignmentId) {
    return surveyorAssignmentPhysicalDocumentService.findByAssignmentId(assignmentId);
  }
}

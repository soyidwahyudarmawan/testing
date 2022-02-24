package com.bfi.bravo.controller;

import static com.bfi.bravo.constant.AppConstants.DEFAULT_ACCESS_ROLE;

import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentPersonalDataCreateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentPersonalDataUpdateRequest;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentPersonalDataCreateResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentPersonalDataResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentPersonalDataUpdateResponse;
import com.bfi.bravo.service.SurveyorAssignmentPersonalDataService;
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
@RequestMapping(value = "/v1/surveyor-assignment-personal-data")
@Tag(name = "Surveyor Assignment Personal Data API", description = "CRUD surveyor assignment personal data")
public class SurveyorAssignmentPersonalDataController {

  @Autowired
  private SurveyorAssignmentPersonalDataService surveyorAssignmentPersonalDataService;

  @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create", description = "Create surveyor assignment personal data")
  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentPersonalDataCreateResponse create(
    @Valid @RequestBody SurveyorAssignmentPersonalDataCreateRequest request
  ) {
    return surveyorAssignmentPersonalDataService.create(request);
  }

  @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Update", description = "Update surveyor assignment personal data")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentPersonalDataUpdateResponse update(
    @Valid @RequestBody SurveyorAssignmentPersonalDataUpdateRequest request
  ) {
    return surveyorAssignmentPersonalDataService.update(request);
  }

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get all", description = "Get all surveyor assignment personal data")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public List<SurveyorAssignmentPersonalDataResponse> findAll() {
    return surveyorAssignmentPersonalDataService.findAll();
  }

  @GetMapping(value = "/{assignmentPersonalDataId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get one", description = "Get one surveyor assignment personal data")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentPersonalDataResponse findById(@PathVariable Long assignmentPersonalDataId) {
    return surveyorAssignmentPersonalDataService.findById(assignmentPersonalDataId);
  }

  @GetMapping(value = "/assignment/{assignmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get one", description = "Get one surveyor assignment personal data by surveyor assignment id")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentPersonalDataResponse findByAssignmentId(@PathVariable Long assignmentId) {
    return surveyorAssignmentPersonalDataService.findByAssignmentId(assignmentId);
  }
}

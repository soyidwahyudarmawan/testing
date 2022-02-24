package com.bfi.bravo.controller;

import static com.bfi.bravo.constant.AppConstants.DEFAULT_ACCESS_ROLE;

import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentOccupationDataCreateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentOccupationDataUpdateRequest;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentOccupationDataCreateResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentOccupationDataResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentOccupationDataUpdateResponse;
import com.bfi.bravo.service.SurveyorAssignmentOccupationDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.List;
import javax.validation.Valid;
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
@RequestMapping(value = "/v1/surveyor-assignment-occupation-data")
@Tag(name = "Surveyor Assignment Occupation Data API", description = "CRUD surveyor assignment occupation data")
public class SurveyorAssignmentOccupationDataController {

  @Autowired
  private SurveyorAssignmentOccupationDataService surveyorAssignmentOccupationDataService;

  @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create", description = "Create surveyor assignment occupation data")
  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentOccupationDataCreateResponse create(
    @Valid @RequestBody SurveyorAssignmentOccupationDataCreateRequest request
  ) {
    return surveyorAssignmentOccupationDataService.create(request);
  }

  @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Update", description = "Update surveyor assignment occupation data")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentOccupationDataUpdateResponse update(
    @Valid @RequestBody SurveyorAssignmentOccupationDataUpdateRequest request
  ) {
    return surveyorAssignmentOccupationDataService.update(request);
  }

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get all", description = "Get all surveyor assignment occupation data")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public List<SurveyorAssignmentOccupationDataResponse> findAll() {
    return surveyorAssignmentOccupationDataService.findAll();
  }

  @GetMapping(value = "/{assignmentOccupationDataId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get one", description = "Get one surveyor assignment occupation data")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentOccupationDataResponse findById(@PathVariable Long assignmentOccupationDataId) {
    return surveyorAssignmentOccupationDataService.findById(assignmentOccupationDataId);
  }

  @GetMapping(value = "/assignment/{assignmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get one", description = "Get one surveyor assignment occupation data by surveyor assignment id")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentOccupationDataResponse findByAssignmentId(@PathVariable Long assignmentId) {
    return surveyorAssignmentOccupationDataService.findByAssignmentId(assignmentId);
  }
}

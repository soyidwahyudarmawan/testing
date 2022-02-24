package com.bfi.bravo.controller;

import static com.bfi.bravo.constant.AppConstants.DEFAULT_ACCESS_ROLE;

import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentLoanInformationCreateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentLoanInformationUpdateRequest;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentLoanInformationCreateResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentLoanInformationResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentLoanInformationUpdateResponse;
import com.bfi.bravo.service.SurveyorAssignmentLoanInformationService;
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
@RequestMapping(value = "/v1/surveyor-assignment-loan-information")
@Tag(name = "Surveyor Assignment Loan Information API", description = "CRUD surveyor assignment loan information")
public class SurveyorAssignmentLoanInformationController {

  @Autowired
  private SurveyorAssignmentLoanInformationService surveyorAssignmentLoanInformationService;

  @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create", description = "Create surveyor assignment loan information")
  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentLoanInformationCreateResponse create(
    @Valid @RequestBody SurveyorAssignmentLoanInformationCreateRequest request
  ) {
    return surveyorAssignmentLoanInformationService.create(request);
  }

  @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Update", description = "Update surveyor assignment loan information")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentLoanInformationUpdateResponse update(
    @Valid @RequestBody SurveyorAssignmentLoanInformationUpdateRequest request
  ) {
    return surveyorAssignmentLoanInformationService.update(request);
  }

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get all", description = "Get all surveyor assignment loan information")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public List<SurveyorAssignmentLoanInformationResponse> findAll() {
    return surveyorAssignmentLoanInformationService.findAll();
  }

  @GetMapping(value = "/{assignmentCollateralInformationId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get one", description = "Get one surveyor assignment loan information")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentLoanInformationResponse findById(@PathVariable Long assignmentLoanInformationId) {
    return surveyorAssignmentLoanInformationService.findById(assignmentLoanInformationId);
  }

  @GetMapping(value = "/assignment/{assignmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(
    summary = "Get one",
    description = "Get one surveyor assignment loan information by surveyor assignment id"
  )
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentLoanInformationResponse findByAssignmentId(@PathVariable Long assignmentId) {
    return surveyorAssignmentLoanInformationService.findByAssignmentId(assignmentId);
  }
}

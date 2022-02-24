package com.bfi.bravo.controller;

import static com.bfi.bravo.constant.AppConstants.DEFAULT_ACCESS_ROLE;

import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentCollateralInformationCreateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentCollateralInformationUpdateRequest;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentCollateralInformationCreateResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentCollateralInformationResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentCollateralInformationUpdateResponse;
import com.bfi.bravo.service.SurveyorAssignmentCollateralInformationService;
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
@RequestMapping(value = "/v1/surveyor-assignment-collateral-information")
@Tag(
  name = "Surveyor Assignment Collateral Information API",
  description = "CRUD surveyor assignment collateral information"
)
public class SurveyorAssignmentCollateralInformationController {

  @Autowired
  private SurveyorAssignmentCollateralInformationService surveyorAssignmentCollateralInformationService;

  @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create", description = "Create surveyor assignment collateral information")
  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentCollateralInformationCreateResponse create(
    @Valid @RequestBody SurveyorAssignmentCollateralInformationCreateRequest request
  ) {
    return surveyorAssignmentCollateralInformationService.create(request);
  }

  @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Update", description = "Update surveyor assignment collateral information")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentCollateralInformationUpdateResponse update(
    @Valid @RequestBody SurveyorAssignmentCollateralInformationUpdateRequest request
  ) {
    return surveyorAssignmentCollateralInformationService.update(request);
  }

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get all", description = "Get all surveyor assignment collateral information")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public List<SurveyorAssignmentCollateralInformationResponse> findAll() {
    return surveyorAssignmentCollateralInformationService.findAll();
  }

  @GetMapping(value = "/{assignmentCollateralInformationId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get one", description = "Get one surveyor assignment collateral information")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentCollateralInformationResponse findById(
    @PathVariable Long assignmentCollateralInformationId
  ) {
    return surveyorAssignmentCollateralInformationService.findById(assignmentCollateralInformationId);
  }

  @GetMapping(value = "/assignment/{assignmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(
    summary = "Get one",
    description = "Get one surveyor assignment collateral information by surveyor assignment id"
  )
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentCollateralInformationResponse findByAssignmentId(@PathVariable Long assignmentId) {
    return surveyorAssignmentCollateralInformationService.findByAssignmentId(assignmentId);
  }
}

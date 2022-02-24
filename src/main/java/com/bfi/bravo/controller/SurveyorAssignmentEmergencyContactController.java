package com.bfi.bravo.controller;

import static com.bfi.bravo.constant.AppConstants.DEFAULT_ACCESS_ROLE;

import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentEmergencyContactCreateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentEmergencyContactUpdateRequest;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentEmergencyContactCreateResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentEmergencyContactResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentEmergencyContactUpdateResponse;
import com.bfi.bravo.service.SurveyorAssignmentEmergencyContactService;
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
@RequestMapping(value = "/api/v1/surveyor-assignment-emergency-contact")
@Tag(name = "Surveyor Assignment Emergency Contact API", description = "CRUD surveyor assignment emergency contact")
public class SurveyorAssignmentEmergencyContactController {

  @Autowired
  private SurveyorAssignmentEmergencyContactService surveyorAssignmentEmergencyContactService;

  @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create", description = "Create surveyor assignment emergency contact")
  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentEmergencyContactCreateResponse create(
    @Valid @RequestBody SurveyorAssignmentEmergencyContactCreateRequest request
  ) {
    return surveyorAssignmentEmergencyContactService.create(request);
  }

  @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Update", description = "Update surveyor assignment emergency contact")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentEmergencyContactUpdateResponse update(
    @Valid @RequestBody(required = true) SurveyorAssignmentEmergencyContactUpdateRequest request
  ) {
    return surveyorAssignmentEmergencyContactService.update(request);
  }

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get all", description = "Get all surveyor assignment emergency contact")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public List<SurveyorAssignmentEmergencyContactResponse> findAll() {
    return surveyorAssignmentEmergencyContactService.findAll();
  }

  @GetMapping(value = "/{assignmentEmergencyContactId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get one", description = "Get one surveyor assignment emergency contact")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentEmergencyContactResponse findById(@PathVariable Long assignmentEmergencyContactId) {
    return surveyorAssignmentEmergencyContactService.findById(assignmentEmergencyContactId);
  }

  @GetMapping(value = "/assignment/{assignmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(
    summary = "Get one",
    description = "Get one surveyor assignment emergency contact by surveyor assignment id"
  )
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorAssignmentEmergencyContactResponse findByAssignmentId(@PathVariable Long assignmentId) {
    return surveyorAssignmentEmergencyContactService.findByAssignmentId(assignmentId);
  }
}

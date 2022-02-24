package com.bfi.bravo.controller;

import static com.bfi.bravo.constant.AppConstants.DEFAULT_ACCESS_ROLE;

import com.bfi.bravo.dto.notification.request.SurveyorNotificationCreateRequest;
import com.bfi.bravo.dto.notification.request.SurveyorNotificationReadStatusUpdateRequest;
import com.bfi.bravo.dto.notification.request.SurveyorNotificationStatusUpdateRequest;
import com.bfi.bravo.dto.notification.response.SurveyorNotificationCountUnreadResponse;
import com.bfi.bravo.dto.notification.response.SurveyorNotificationCreateResponse;
import com.bfi.bravo.dto.notification.response.SurveyorNotificationReadStatusUpdateResponse;
import com.bfi.bravo.dto.notification.response.SurveyorNotificationResponse;
import com.bfi.bravo.dto.notification.response.SurveyorNotificationStatusUpdateResponse;
import com.bfi.bravo.service.SurveyorNotificationService;
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
@RequestMapping(value = "/v1/surveyor-notification")
@Tag(name = "Surveyor Notification API", description = "CRUD surveyor notification")
public class SurveyorNotificationController {

  @Autowired
  private SurveyorNotificationService surveyorNotificationService;

  @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create", description = "Create surveyor notification")
  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorNotificationCreateResponse create(
    @Valid @RequestBody(required = true) SurveyorNotificationCreateRequest request
  ) {
    return surveyorNotificationService.create(request);
  }

  @PutMapping(
    value = "/notification-status",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @Operation(summary = "Update notification status", description = "Update surveyor notification status")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorNotificationStatusUpdateResponse updateNotificationStatus(
    @Valid @RequestBody SurveyorNotificationStatusUpdateRequest request
  ) {
    return surveyorNotificationService.updateNotificationStatus(request);
  }

  @PutMapping(
    value = "/read-status",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @Operation(summary = "Update read status", description = "Update surveyor notification read status")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorNotificationReadStatusUpdateResponse updateReadStatus(
    @Valid @RequestBody SurveyorNotificationReadStatusUpdateRequest request
  ) {
    return surveyorNotificationService.updateReadStatus(request);
  }

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get all", description = "Get all surveyor notification")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public List<SurveyorNotificationResponse> findAll() {
    return surveyorNotificationService.findAll();
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get one", description = "Get one surveyor notification")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorNotificationResponse findById(@PathVariable Long id) {
    return surveyorNotificationService.findById(id);
  }

  @GetMapping(value = "/surveyor/{surveyorId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get all by surveyor", description = "Get all surveyor notification by surveyor")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public List<SurveyorNotificationResponse> findAllBySurveyorId(@PathVariable String surveyorId) {
    return surveyorNotificationService.findAllBySurveyorId(surveyorId);
  }

  @GetMapping(value = "/surveyor/{surveyorId}/count-unread", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(
    summary = "Get count unread by surveyor",
    description = "Get count unread surveyor notification by surveyor"
  )
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorNotificationCountUnreadResponse getCountUnread(@PathVariable String surveyorId) {
    return surveyorNotificationService.getCountUnread(surveyorId);
  }
}

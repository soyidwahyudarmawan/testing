package com.bfi.bravo.controller;

import static com.bfi.bravo.constant.AppConstants.DEFAULT_ACCESS_ROLE;

import com.bfi.bravo.dto.application.request.ApplicationCreateRequest;
import com.bfi.bravo.dto.application.response.ApplicationCreateResponse;
import com.bfi.bravo.dto.application.response.ApplicationResponse;
import com.bfi.bravo.service.ApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/application")
@Tag(name = "Application API", description = "CRUD application")
class ApplicationController {

  @Autowired
  private ApplicationService applicationService;

  @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create", description = "Create application")
  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize(DEFAULT_ACCESS_ROLE)
  public ApplicationCreateResponse create(@Valid @RequestBody ApplicationCreateRequest request) {
    return applicationService.create(request);
  }

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get all", description = "Get all application")
  @PreAuthorize(DEFAULT_ACCESS_ROLE)
  public List<ApplicationResponse> findAll() {
    return applicationService.findAll();
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get one", description = "Get one application")
  public ApplicationResponse findById(@PathVariable UUID id) {
    return applicationService.findById(id);
  }
}

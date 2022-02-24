package com.bfi.bravo.controller;

import com.bfi.bravo.dto.operation.response.OperationUploadResponse;
import com.bfi.bravo.service.OperationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static com.bfi.bravo.constant.AppConstants.DEFAULT_ACCESS_ROLE;

@RestController
@RequestMapping(value = "/v1/operation")
@Tag(name = "Operation API", description = "CRUD operation")
public class OperationController {

  @Autowired
  private OperationService operationService;

  @PostMapping(
    value = "/upload",
    consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @Operation(summary = "Upload", description = "Upload file")
  @PreAuthorize("hasRole('ROLE_BRANCH_ADMIN') or hasRole('ROLE_CDP') or hasRole('ROLE_RCO') or " + DEFAULT_ACCESS_ROLE)
  public OperationUploadResponse upload(@RequestParam("file") MultipartFile file) {
    return operationService.upload(file);
  }
}

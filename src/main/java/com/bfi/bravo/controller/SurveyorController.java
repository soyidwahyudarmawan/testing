package com.bfi.bravo.controller;

import static com.bfi.bravo.constant.AppConstants.DEFAULT_ACCESS_ROLE;

import com.bfi.bravo.dto.surveyor.response.SurveyorSummaryResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorUploadResponse;
import com.bfi.bravo.service.SurveyorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/v1/surveyor")
@Tag(name = "Surveyor API", description = "CRUD surveyor")
public class SurveyorController {

  @Autowired
  private SurveyorService surveyorService;

  @GetMapping(value = "/{surveyorId}/summary", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get summary", description = "Get surveyor summary")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorSummaryResponse getSummary(@PathVariable(required = true, name = "surveyorId") String surveyorId) {
    return surveyorService.getSummary(surveyorId);
  }

  @PostMapping(
    value = "/upload",
    consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @Operation(summary = "Upload", description = "Upload file")
  @PreAuthorize("hasRole('ROLE_SURVEYOR') or " + DEFAULT_ACCESS_ROLE)
  public SurveyorUploadResponse upload(@RequestParam("file") MultipartFile file) {
    return surveyorService.upload(file);
  }
}

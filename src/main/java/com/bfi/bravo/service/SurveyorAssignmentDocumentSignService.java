package com.bfi.bravo.service;

import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentDocumentSignCreateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentDocumentSignUpdateRequest;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentDocumentSignCreateResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentDocumentSignResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentDocumentSignUpdateResponse;
import java.util.List;

public interface SurveyorAssignmentDocumentSignService {
  public SurveyorAssignmentDocumentSignCreateResponse create(SurveyorAssignmentDocumentSignCreateRequest request);

  public SurveyorAssignmentDocumentSignUpdateResponse update(SurveyorAssignmentDocumentSignUpdateRequest request);

  public List<SurveyorAssignmentDocumentSignResponse> findAll();

  public SurveyorAssignmentDocumentSignResponse findById(Long id);

  public SurveyorAssignmentDocumentSignResponse findByAssignmentId(Long assignmentId);
}

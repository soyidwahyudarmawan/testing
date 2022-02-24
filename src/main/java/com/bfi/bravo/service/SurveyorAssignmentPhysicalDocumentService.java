package com.bfi.bravo.service;

import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentPhysicalDocumentCreateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentPhysicalDocumentUpdateRequest;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentPhysicalDocumentCreateResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentPhysicalDocumentResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentPhysicalDocumentUpdateResponse;
import java.util.List;

public interface SurveyorAssignmentPhysicalDocumentService {
  public SurveyorAssignmentPhysicalDocumentCreateResponse create(
    SurveyorAssignmentPhysicalDocumentCreateRequest request
  );

  public SurveyorAssignmentPhysicalDocumentUpdateResponse update(
    SurveyorAssignmentPhysicalDocumentUpdateRequest request
  );

  public List<SurveyorAssignmentPhysicalDocumentResponse> findAll();

  public SurveyorAssignmentPhysicalDocumentResponse findById(Long id);

  public SurveyorAssignmentPhysicalDocumentResponse findByAssignmentId(Long assignmentId);
}

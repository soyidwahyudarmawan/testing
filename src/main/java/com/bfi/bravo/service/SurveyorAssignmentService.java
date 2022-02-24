package com.bfi.bravo.service;

import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentCreateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentPhysicalDocumentSubmitUpdateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentPhysicalDocumentSubmitsUpdateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentSurveyDoneUpdateRequest;
import com.bfi.bravo.dto.surveyor.response.*;

import java.util.List;

public interface SurveyorAssignmentService {
  public SurveyorAssignmentCreateResponse create(SurveyorAssignmentCreateRequest request);

  public SurveyorAssignmentSurveyDoneUpdateResponse surveyDone(SurveyorAssignmentSurveyDoneUpdateRequest request);

  public SurveyorAssignmentPhysicalDocumentSubmitUpdateResponse physicalDocumentSubmit(
    SurveyorAssignmentPhysicalDocumentSubmitUpdateRequest request
  );

  public SurveyorAssignmentPhysicalDocumentSubmitsUpdateResponse physicalDocumentSubmits(
    SurveyorAssignmentPhysicalDocumentSubmitsUpdateRequest request
  );

  public List<SurveyorAssignmentResponse> findAll();

  public SurveyorAssignmentResponse findById(Long id);

  public List<SurveyorAssignmentResponse> findAllBySurveyorId(String surveyorId);
}

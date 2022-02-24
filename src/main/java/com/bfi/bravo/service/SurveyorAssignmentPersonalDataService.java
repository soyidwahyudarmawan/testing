package com.bfi.bravo.service;

import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentPersonalDataCreateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentPersonalDataUpdateRequest;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentPersonalDataCreateResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentPersonalDataResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentPersonalDataUpdateResponse;
import java.util.List;

public interface SurveyorAssignmentPersonalDataService {
  public SurveyorAssignmentPersonalDataCreateResponse create(SurveyorAssignmentPersonalDataCreateRequest request);

  public SurveyorAssignmentPersonalDataUpdateResponse update(SurveyorAssignmentPersonalDataUpdateRequest request);

  public List<SurveyorAssignmentPersonalDataResponse> findAll();

  public SurveyorAssignmentPersonalDataResponse findById(Long id);

  public SurveyorAssignmentPersonalDataResponse findByAssignmentId(Long assignmentId);
}

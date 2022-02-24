package com.bfi.bravo.service;

import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentOccupationDataCreateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentOccupationDataUpdateRequest;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentOccupationDataCreateResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentOccupationDataResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentOccupationDataUpdateResponse;
import java.util.List;

public interface SurveyorAssignmentOccupationDataService {
  public SurveyorAssignmentOccupationDataCreateResponse create(SurveyorAssignmentOccupationDataCreateRequest request);

  public SurveyorAssignmentOccupationDataUpdateResponse update(SurveyorAssignmentOccupationDataUpdateRequest request);

  public List<SurveyorAssignmentOccupationDataResponse> findAll();

  public SurveyorAssignmentOccupationDataResponse findById(Long id);

  public SurveyorAssignmentOccupationDataResponse findByAssignmentId(Long assignmentId);
}

package com.bfi.bravo.service;

import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentEmergencyContactCreateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentEmergencyContactUpdateRequest;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentEmergencyContactCreateResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentEmergencyContactResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentEmergencyContactUpdateResponse;
import java.util.List;

public interface SurveyorAssignmentEmergencyContactService {
  public SurveyorAssignmentEmergencyContactCreateResponse create(
    SurveyorAssignmentEmergencyContactCreateRequest request
  );

  public SurveyorAssignmentEmergencyContactUpdateResponse update(
    SurveyorAssignmentEmergencyContactUpdateRequest request
  );

  public List<SurveyorAssignmentEmergencyContactResponse> findAll();

  public SurveyorAssignmentEmergencyContactResponse findById(Long id);

  public SurveyorAssignmentEmergencyContactResponse findByAssignmentId(Long assignmentId);
}

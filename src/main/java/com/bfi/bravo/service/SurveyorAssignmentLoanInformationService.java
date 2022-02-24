package com.bfi.bravo.service;

import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentLoanInformationCreateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentLoanInformationUpdateRequest;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentLoanInformationCreateResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentLoanInformationResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentLoanInformationUpdateResponse;
import java.util.List;

public interface SurveyorAssignmentLoanInformationService {
  public SurveyorAssignmentLoanInformationCreateResponse create(SurveyorAssignmentLoanInformationCreateRequest request);

  public SurveyorAssignmentLoanInformationUpdateResponse update(SurveyorAssignmentLoanInformationUpdateRequest request);

  public List<SurveyorAssignmentLoanInformationResponse> findAll();

  public SurveyorAssignmentLoanInformationResponse findById(Long id);

  public SurveyorAssignmentLoanInformationResponse findByAssignmentId(Long assignmentId);
}

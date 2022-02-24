package com.bfi.bravo.service;

import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentCollateralInformationCreateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentCollateralInformationUpdateRequest;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentCollateralInformationCreateResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentCollateralInformationResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentCollateralInformationUpdateResponse;
import java.util.List;

public interface SurveyorAssignmentCollateralInformationService {
  public SurveyorAssignmentCollateralInformationCreateResponse create(
    SurveyorAssignmentCollateralInformationCreateRequest request
  );

  public SurveyorAssignmentCollateralInformationUpdateResponse update(
    SurveyorAssignmentCollateralInformationUpdateRequest request
  );

  public List<SurveyorAssignmentCollateralInformationResponse> findAll();

  public SurveyorAssignmentCollateralInformationResponse findById(Long id);

  public SurveyorAssignmentCollateralInformationResponse findByAssignmentId(Long assignmentId);
}

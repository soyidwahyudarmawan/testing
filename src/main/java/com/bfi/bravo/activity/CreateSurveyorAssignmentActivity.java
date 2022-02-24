package com.bfi.bravo.activity;

import com.bfi.bravo.constant.SurveyorConstants.AssignmentType;
import com.bfi.bravo.constant.WorkflowConstants;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentCreateRequest;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentCreateResponse;
import com.bfi.bravo.entity.Application;
import com.bfi.bravo.repository.ApplicationRepository;
import com.bfi.bravo.service.SurveyorAssignmentService;
import java.util.UUID;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ConfigurationProperties
public class CreateSurveyorAssignmentActivity implements JavaDelegate {

  @Autowired
  private ApplicationRepository applicationRepository;

  @Autowired
  private SurveyorAssignmentService surveyorAssignmentService;

  @Override
  public void execute(DelegateExecution delegateExecution) throws Exception {
    Application application = applicationRepository
      .findByIdAndActiveIsTrue((UUID) delegateExecution.getVariable(WorkflowConstants.APPLICATION_ID_VARIABLE_KEY))
      .orElseThrow(() -> new RuntimeException("Application do NOT exists!"));

    SurveyorAssignmentCreateResponse surveyorAssignmentCreateResponse = surveyorAssignmentService.create(
      SurveyorAssignmentCreateRequest
        .builder()
        .applicationId(application.getId())
        .applicationNumber(String.valueOf(application.getNumber()))
        .leadId(application.getLeadId())
        .leadNumber(application.getLeadNumber())
        .surveyorId((String) delegateExecution.getVariable(WorkflowConstants.WORKFLOW_SURVEY_ASSIGNEE))
        .assignmentType(AssignmentType.VEHICLE_OWNER_PICKUP)
        .branchId(application.getBranch().getId())
        .productId(application.getProductId())
        .build()
    );
  }
}

package com.bfi.bravo.activity;

import com.bfi.bravo.constant.WorkflowConstants;
import com.bfi.bravo.entity.Application;
import com.bfi.bravo.repository.ApplicationRepository;
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
public class NDF4WCreditModelActivity implements JavaDelegate {

  @Autowired
  private ApplicationRepository applicationRepository;

  @Override
  public void execute(DelegateExecution delegateExecution) throws Exception {
    Application application = applicationRepository
      .findByIdAndActiveIsTrue((UUID) delegateExecution.getVariable(WorkflowConstants.APPLICATION_ID_VARIABLE_KEY))
      .orElseThrow(() -> new RuntimeException("Application do NOT exists!"));

    if (application.getApplicant().getFullName().startsWith("Najeeb")) {
      log.info("Application Approved by mock credit model");
      delegateExecution.setVariable(WorkflowConstants.WORKFLOW_CREDIT_MODEL_APPROVAL, "approved");

      delegateExecution.setVariable(WorkflowConstants.WORKFLOW_CREDIT_MODEL_PERSONA, "low-risk");
    } else {
      log.info("Application REJECTED by mock credit model");
      delegateExecution.setVariable(WorkflowConstants.WORKFLOW_CREDIT_MODEL_APPROVAL, "rejected");
    }

    delegateExecution.getVariables().forEach((thisX, thisY) -> log.info("K: {}, V: {}", thisX, thisY));
  }
}

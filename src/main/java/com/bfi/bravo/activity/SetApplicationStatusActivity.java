package com.bfi.bravo.activity;

import com.bfi.bravo.constant.ApplicationConstants.ApplicationStatus;
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
public class SetApplicationStatusActivity implements JavaDelegate {

  @Autowired
  private ApplicationRepository applicationRepository;

  @Override
  public void execute(DelegateExecution delegateExecution) throws Exception {
    Application application = applicationRepository
      .findByIdAndActiveIsTrue((UUID) delegateExecution.getVariable(WorkflowConstants.APPLICATION_ID_VARIABLE_KEY))
      .orElseThrow(() -> new RuntimeException("Application do NOT exists!"));

    // THIS IS A (LOCAL VARIABLE !)
    ApplicationStatus newApplicationStatus = ApplicationStatus
      .fromString((String) delegateExecution.getVariableLocal(WorkflowConstants.WORKFLOW_STATUS_TO_BE_SET_KEY))
      .orElseThrow(() ->
        new RuntimeException(
          String.format(
            "Wrong status, unable to parse (%s)",
            delegateExecution.getVariableLocal(WorkflowConstants.WORKFLOW_STATUS_TO_BE_SET_KEY)
          )
        )
      );

    log.info("Setting application ({}) to status ({})", application.getId(), newApplicationStatus);

    application.setStatus(newApplicationStatus);
    applicationRepository.save(application);
  }
}

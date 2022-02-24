package com.bfi.bravo.activity;

import com.bfi.bravo.constant.WorkflowConstants;
import com.bfi.bravo.dto.branch.workload.BranchSurveyorsWorkload;
import com.bfi.bravo.service.BranchSurveyorsService;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map.Entry;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SurveyorResolutionActivity implements JavaDelegate {

  @Autowired
  private BranchSurveyorsService branchSurveyorsService;

  @Override
  public void execute(DelegateExecution delegateExecution) throws Exception {
    String branchKey = (String) delegateExecution.getVariable(WorkflowConstants.APPLICATION_BRANCH_VARIABLE_KEY);

    BranchSurveyorsWorkload branchSurveyorWorkload = branchSurveyorsService.getBranchSurveyorsWorkload(branchKey);

    Entry<String, Long> leastOccupiedSurveyor = Collections.max(
      branchSurveyorWorkload.getBranchUserTasks().entrySet(),
      new Comparator<Entry<String, Long>>() {
        public int compare(Entry<String, Long> entryA, Entry<String, Long> entryB) {
          return entryB.getValue().compareTo(entryA.getValue());
        }
      }
    );

    log.info(
      "Surveyor resolved to least occupied to ({}) with ({}) tasks",
      leastOccupiedSurveyor.getKey(),
      leastOccupiedSurveyor.getValue()
    );
    delegateExecution.setVariable("surveyAssignee", leastOccupiedSurveyor.getKey());
  }
}

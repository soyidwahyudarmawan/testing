package com.bfi.bravo.service.impl;

import com.bfi.bravo.dto.branch.workload.BranchSurveyorsWorkload;
import com.bfi.bravo.service.BranchSurveyorsService;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.identity.Group;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BranchSurveyorsServiceImpl implements BranchSurveyorsService {

  @Autowired
  private IdentityService identityService;

  @Autowired
  private TaskService taskService;

  @Override
  public BranchSurveyorsWorkload getBranchSurveyorsWorkload(String branchKey) {
    log.info(String.format("%s/%s", branchKey, "surveyor"));
    Group branchSurveyorsGroup = identityService
      .createGroupQuery()
      .groupName(String.format("%s/%s", branchKey, "surveyor"))
      .singleResult();

    List<User> branchSurveyors = identityService.createUserQuery().memberOfGroup(branchSurveyorsGroup.getId()).list();

    return BranchSurveyorsWorkload
      .builder()
      .branchCode(branchKey)
      .branchUserTasks(
        branchSurveyors
          .stream()
          .map(thisUser ->
            new AbstractMap.SimpleEntry<>(
              thisUser.getId(),
              taskService.createTaskQuery().taskAssignee(thisUser.getId()).count()
            )
          )
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
      )
      .build();
  }
}

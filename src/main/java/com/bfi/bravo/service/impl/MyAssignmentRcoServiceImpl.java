package com.bfi.bravo.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import com.bfi.bravo.dto.assignment.response.MyAssignmentRcoResponse;
import com.bfi.bravo.entity.Assignment;
import com.bfi.bravo.mapper.MyAssignmentMapper;
import com.bfi.bravo.repository.MyAssignmentRcoRepository;
import com.bfi.bravo.service.MyAssignmentRcoService;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
public class MyAssignmentRcoServiceImpl implements MyAssignmentRcoService
{
  @Autowired
  MyAssignmentRcoRepository repository;

  @Autowired
  MyAssignmentMapper mapper;

  @Override
  public List<MyAssignmentRcoResponse> findAll() {
    List<Assignment> assignments = Streamable.of(repository.findAllByActiveIsTrue()).toList();

    List<MyAssignmentRcoResponse> result = new ArrayList<>();

    assignments.forEach(assignment -> {
      MyAssignmentRcoResponse
        .builder()
        .applicationId(assignment.getApplicationId())
        .branch(mapper.convertToBranchResponse(assignment.getBranch()))
        .assignmentDate(assignment.getAssignmentDate())
        .assetDocumentDataCompleted(assignment.getAssetDocumentDataCompleted())
        .documentSignCompleted(assignment.getDocumentSignCompleted())
        .physicalDocumentCompleted(assignment.getPhysicalDocumentCompleted())
        .thirdPartyInformationCompleted(assignment.getThirdPartyInformationCompleted())
        .fundingInformationCompleted(assignment.getFundingInformationCompleted())
        .assetDataCompleted(assignment.getAssetDataCompleted())
        .statusEnrichment(assignment.getStatusEnrichment())
        .statusGoLive(assignment.getStatusGoLive())
        .build();
    });

    return result;
  }
}

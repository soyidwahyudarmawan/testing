package com.bfi.bravo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bfi.bravo.dto.assignment.response.MyAssignmentCdpResponse;
import com.bfi.bravo.entity.Assignment;
import com.bfi.bravo.mapper.MyAssignmentMapper;
import com.bfi.bravo.repository.MyAssignmentCdpRepository;
import com.bfi.bravo.service.MyAssignmentCdpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyAssignmentCdpServiceImpl implements MyAssignmentCdpService
{
  @Autowired
  private MyAssignmentCdpRepository repository;

  @Autowired
  private MyAssignmentMapper mapper;

  @Override
  public List<MyAssignmentCdpResponse> findAll() {
    List<Assignment> assignments = Streamable.of(repository.findAllByActiveIsTrue()).toList();

    List<MyAssignmentCdpResponse> result = new ArrayList<>();
    assignments.forEach(assignment -> {
      result.add(
        MyAssignmentCdpResponse
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
          .build()
      );
    });
    return result;
  }
}

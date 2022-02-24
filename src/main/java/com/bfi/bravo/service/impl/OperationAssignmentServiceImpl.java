package com.bfi.bravo.service.impl;

import com.bfi.bravo.dto.operation.request.OperationAssignmentCreateRequest;
import com.bfi.bravo.dto.operation.response.OperationAssignmentCdpResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentCreateResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentRcoResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentResponse;
import com.bfi.bravo.entity.*;
import com.bfi.bravo.mapper.OperationAssignmentMapper;
import com.bfi.bravo.repository.*;
import com.bfi.bravo.service.OperationAssignmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class OperationAssignmentServiceImpl implements OperationAssignmentService {

  @Autowired
  private OperationAssignmentRepository operationAssignmentRepository;

  @Autowired
  private OperationAssignmentAssetDocumentDataRepository operationAssignmentAssetDocumentDataRepository;

  @Autowired
  private OperationAssignmentDocumentSignRepository operationAssignmentDocumentSignRepository;

  @Autowired
  private OperationAssignmentPhysicalDocumentRepository operationAssignmentPhysicalDocumentRepository;

  @Autowired
  private OperationAssignmentThirdPartyInformationRepository operationAssignmentThirdPartyInformationRepository;

  @Autowired
  private OperationAssignmentFundingInformationRepository operationAssignmentFundingInformationRepository;

  @Autowired
  private OperationAssignmentAssetDataRepository operationAssignmentAssetDataRepository;

  @Autowired
  private ApplicationRepository applicationRepository;

  @Autowired
  private SurveyorAssignmentRepository surveyorAssignmentRepository;

  @Autowired
  private BranchRepository branchRepository;

  @Autowired
  private OperationAssignmentMapper mapper;

  @Override
  public OperationAssignmentCreateResponse create(OperationAssignmentCreateRequest request) {
    Application application = applicationRepository
      .findByIdAndActiveIsTrue(request.getApplicationId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    SurveyorAssignment surveyorAssignment = surveyorAssignmentRepository
      .findByIdAndActiveIsTrue(request.getSurveyorAssignmentId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    Branch branch = branchRepository
      .findByIdAndActiveIsTrue(request.getBranchId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    OperationAssignment operationAssignment = operationAssignmentRepository.save(
      OperationAssignment
        .builder()
        .application(application)
        .surveyorAssignment(surveyorAssignment)
        .branch(branch)
        .assignmentStatus("DRAFT")
        .assignmentBranchStatus("DRAFT")
        .assignmentHeadOfficeStatus("DRAFT")
        .build()
    );

    //Operation Assignment Asset Document Data
    OperationAssignmentAssetDocumentData operationAssignmentAssetDocumentData = operationAssignmentAssetDocumentDataRepository.save(
      OperationAssignmentAssetDocumentData.builder().assignment(operationAssignment).build()
    );

    //Operation Assignment Document Sign
    OperationAssignmentDocumentSign operationAssignmentDocumentSign = operationAssignmentDocumentSignRepository.save(
      OperationAssignmentDocumentSign.builder().assignment(operationAssignment).build()
    );

    //Operation Assignment Physical Document
    OperationAssignmentPhysicalDocument operationAssignmentPhysicalDocument = operationAssignmentPhysicalDocumentRepository.save(
      OperationAssignmentPhysicalDocument.builder().assignment(operationAssignment).build()
    );

    //Operation Assignment Third Party Information
    OperationAssignmentThirdPartyInformation operationAssignmentThirdPartyInformation = operationAssignmentThirdPartyInformationRepository.save(
      OperationAssignmentThirdPartyInformation.builder().assignment(operationAssignment).build()
    );

    //Operation Assignment Funding Information
    OperationAssignmentFundingInformation operationAssignmentFundingInformation = operationAssignmentFundingInformationRepository.save(
      OperationAssignmentFundingInformation.builder().assignment(operationAssignment).build()
    );

    //Operation Assignment Asset Data
    OperationAssignmentAssetData operationAssignmentAssetData = operationAssignmentAssetDataRepository.save(
      OperationAssignmentAssetData.builder().assignment(operationAssignment).build()
    );

    return OperationAssignmentCreateResponse
      .builder()
      .assignmentId(operationAssignment.getId())
      .build();
  }

  @Override
  public List<OperationAssignmentResponse> findAll() {
    List<OperationAssignment> operationAssignments = Streamable
      .of(operationAssignmentRepository.findAllByActiveIsTrue())
      .toList();

    List<Branch> branches = Streamable.of(branchRepository.findAllByActiveIsTrue()).toList();

    List<OperationAssignmentResponse> result = new ArrayList<>();
    operationAssignments.forEach(operationAssignment -> {
      String branchName = null;
      for (Branch branch : branches) {
        if (operationAssignment.getBranch().getId().longValue() == branch.getId().longValue()) {
          branchName = branch.getName();
        }
      }
      result.add(
        OperationAssignmentResponse
          .builder()
          .assignmentId(operationAssignment.getId())
          .applicationId(operationAssignment.getApplication().getId())
          .applicationNumber(operationAssignment.getApplicationNumber())
          .surveyorAssignmentId(operationAssignment.getSurveyorAssignment().getId())
          .branchId(operationAssignment.getBranch().getId())
          .assetDocumentDataCompleted(operationAssignment.isAssetDocumentDataCompleted())
          .documentSignCompleted(operationAssignment.isDocumentSignCompleted())
          .physicalDocumentCompleted(operationAssignment.isPhysicalDocumentCompleted())
          .thirdPartyInformationCompleted(operationAssignment.isThirdPartyInformationCompleted())
          .fundingInformationCompleted(operationAssignment.isFundingInformationCompleted())
          .assetDataCompleted(operationAssignment.isAssetDataCompleted())
          .assignmentStatus(operationAssignment.getAssignmentStatus())
          .assignmentBranchStatus(operationAssignment.getAssignmentBranchStatus())
          .assignmentHeadOfficeStatus(operationAssignment.getAssignmentHeadOfficeStatus())
          .branchPic(operationAssignment.getBranchPic())
          .headOfficeCdpPic(operationAssignment.getHeadOfficeCdpPic())
          .headOfficeRcoPic(operationAssignment.getHeadOfficeRcoPic())
          .build()
      );
    });

    return result;
  }

  @Override
  public OperationAssignmentResponse findById(Long id) {
    OperationAssignment operationAssignment = operationAssignmentRepository
      .findByIdAndActiveIsTrue(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    Branch branch = branchRepository
      .findByIdAndActiveIsTrue(operationAssignment.getBranch().getId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return OperationAssignmentResponse
      .builder()
      .assignmentId(operationAssignment.getId())
      .applicationId(operationAssignment.getApplication().getId())
      .applicationNumber(operationAssignment.getApplicationNumber())
      .surveyorAssignmentId(operationAssignment.getSurveyorAssignment().getId())
      .branchId(operationAssignment.getBranch().getId())
      .assetDocumentDataCompleted(operationAssignment.isAssetDocumentDataCompleted())
      .documentSignCompleted(operationAssignment.isDocumentSignCompleted())
      .physicalDocumentCompleted(operationAssignment.isPhysicalDocumentCompleted())
      .thirdPartyInformationCompleted(operationAssignment.isThirdPartyInformationCompleted())
      .fundingInformationCompleted(operationAssignment.isFundingInformationCompleted())
      .assetDataCompleted(operationAssignment.isAssetDataCompleted())
      .assignmentStatus(operationAssignment.getAssignmentStatus())
      .assignmentBranchStatus(operationAssignment.getAssignmentBranchStatus())
      .assignmentHeadOfficeStatus(operationAssignment.getAssignmentHeadOfficeStatus())
      .branchPic(operationAssignment.getBranchPic())
      .headOfficeCdpPic(operationAssignment.getHeadOfficeCdpPic())
      .headOfficeRcoPic(operationAssignment.getHeadOfficeRcoPic())
      .build();
  }

  @Override
  public List<OperationAssignmentCdpResponse> findAllCdpResponse() {
    List<OperationAssignment> assignments = Streamable.of(operationAssignmentRepository.findAllByActiveIsTrue()).toList();

    List<OperationAssignmentCdpResponse> result = new ArrayList<>();

    assignments.forEach(assignment -> {
      result.add(
        OperationAssignmentCdpResponse
          .builder()
          .applicationId(assignment.getApplication().getId())
          .branch(mapper.convertToBranchResponse(assignment.getBranch()))
          .assignmentDate(assignment.getAssignmentDate())
          .assetDocumentDataCompleted(assignment.isAssetDocumentDataCompleted())
          .documentSignCompleted(assignment.isDocumentSignCompleted())
          .physicalDocumentCompleted(assignment.isPhysicalDocumentCompleted())
          .thirdPartyInformationCompleted(assignment.isThirdPartyInformationCompleted())
          .fundingInformationCompleted(assignment.isFundingInformationCompleted())
          .assetDataCompleted(assignment.isAssetDataCompleted())
          .statusEnrichment(assignment.getStatusEnrichment())
          .statusGoLive(assignment.getStatusGoLive())
          .build()
      );
    });

    return result;
  }

  @Override
  public List<OperationAssignmentRcoResponse> findAllRcoResponse() {
    List<OperationAssignment> assignments = Streamable.of(operationAssignmentRepository.findAllByActiveIsTrue()).toList();

    List<OperationAssignmentRcoResponse> result = new ArrayList<>();

    assignments.forEach(assignment -> {
      result.add(
        OperationAssignmentRcoResponse
          .builder()
          .applicationId(assignment.getApplication().getId())
          .branch(mapper.convertToBranchResponse(assignment.getBranch()))
          .assignmentDate(assignment.getAssignmentDate())
          .assetDocumentDataCompleted(assignment.isAssetDocumentDataCompleted())
          .documentSignCompleted(assignment.isDocumentSignCompleted())
          .physicalDocumentCompleted(assignment.isPhysicalDocumentCompleted())
          .thirdPartyInformationCompleted(assignment.isThirdPartyInformationCompleted())
          .fundingInformationCompleted(assignment.isFundingInformationCompleted())
          .assetDataCompleted(assignment.isAssetDataCompleted())
          .statusEnrichment(assignment.getStatusEnrichment())
          .statusGoLive(assignment.getStatusGoLive())
          .build()
      );
    });

    return result;
  }
}

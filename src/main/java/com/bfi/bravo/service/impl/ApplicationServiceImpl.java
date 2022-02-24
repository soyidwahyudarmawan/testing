package com.bfi.bravo.service.impl;

import com.bfi.bravo.constant.ApplicationConstants.ApplicationStatus;
import com.bfi.bravo.constant.WorkflowConstants;
import com.bfi.bravo.dto.application.request.ApplicationCollateralByIdRequest;
import com.bfi.bravo.dto.application.request.ApplicationCreateRequest;
import com.bfi.bravo.dto.application.response.ApplicationCollateralResponse;
import com.bfi.bravo.dto.application.response.ApplicationCreateResponse;
import com.bfi.bravo.dto.application.response.ApplicationResponse;
import com.bfi.bravo.entity.Application;
import com.bfi.bravo.entity.Branch;
import com.bfi.bravo.entity.Collateral;
import com.bfi.bravo.mapper.ApplicantMapper;
import com.bfi.bravo.mapper.ApplicationMapper;
import com.bfi.bravo.mapper.CollateralMapper;
import com.bfi.bravo.repository.ApplicationRepository;
import com.bfi.bravo.repository.CollateralRepository;
import com.bfi.bravo.service.ApplicationService;
import com.bfi.bravo.service.BranchService;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
public class ApplicationServiceImpl implements ApplicationService {

  @Autowired
  private ApplicationRepository applicationRepository;

  @Autowired
  private CollateralRepository collateralRepository;

  @Autowired
  private RuntimeService runtimeService;

  @Autowired
  private BranchService branchService;

  @Autowired
  private ApplicantMapper applicantMapper;

  @Autowired
  private ApplicationMapper applicationMapper;

  @Autowired
  private CollateralMapper collateralMapper;

  @Override
  public ApplicationCreateResponse create(ApplicationCreateRequest request) {
    // If product ID is not mapped to workflow in constants
    if (!WorkflowConstants.PRODUCT_TO_WORKFLOW_MAP.containsKey(request.getProductId())) {
      log.info("Application product is invalid, Product Id: ({})", request.getProductId());
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product ID is invalid");
    }

    // Find branch to use for assignment
    Branch matchedBranch = branchService
      .mapApplicationBranch(
        request.getApplicant().getProvinceCode(),
        request.getApplicant().getCityCode(),
        request.getApplicant().getDistrictCode(),
        request.getApplicant().getSubdistrictCode(),
        request.getApplicant().getZipcode()
      )
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, "No matching branch"));

    // Save application tree
    Application application =
      applicationRepository.save(
          Application.builder()
            .number(new SecureRandom().nextLong())
            .leadId(request.getLeadId())
            .leadNumber(request.getLeadNumber())
            .status(ApplicationStatus.SUBMITTED)
            .collateral(collateralMapper.convert(request.getCollateral()))
            .applicant(applicantMapper.convert(request.getApplicant()))
            .amount(request.getAmount())
            .tenor(request.getTenor())
            .installmentAmount(request.getInstallmentAmount())
            .productId(request.getProductId())
            .branch(matchedBranch)
            .build()
        );

    // Invoke workflow
    ProcessInstance newProcess = runtimeService.startProcessInstanceByKey(
      // Value of map is the workflow KEY
      WorkflowConstants.PRODUCT_TO_WORKFLOW_MAP.get(application.getProductId()),
      // Variables to be attached to workflow
      new HashMap<String, Object>() {
        {
          // Branch Key
          put(WorkflowConstants.APPLICATION_BRANCH_VARIABLE_KEY, application.getBranch().getKey());
          // Application ID
          put(WorkflowConstants.APPLICATION_ID_VARIABLE_KEY, application.getId());
        }
      }
    );

    // Update application with process ID
    application.setProcessId(UUID.fromString(newProcess.getProcessInstanceId()));
    applicationRepository.save(application);

    // return response DTO
    return ApplicationCreateResponse
      .builder()
      .applicationId(application.getId())
      .applicationNumber(application.getNumber())
      .processId(UUID.fromString(newProcess.getProcessInstanceId()))
      .build();
  }

  @Override
  public List<ApplicationResponse> findAll() {
    List<Application> applications = Streamable.of(applicationRepository.findAllByActiveIsTrue()).toList();

    List<ApplicationResponse> result = new ArrayList<>();
    applications.forEach(application -> {
      result.add(
        ApplicationResponse
          .builder()
          .applicationId(application.getId())
          .applicationNumber(application.getNumber().toString())
          .leadId(application.getLeadId())
          .leadNumber(application.getLeadNumber())
          .applicationStatus(application.getStatus())
          .leadNumber(application.getLeadNumber())
          .collateral(applicationMapper.convertToApplicationCollateralResponse(application.getCollateral()))
          .applicant(applicationMapper.convertToApplicationApplicantResponse(application.getApplicant()))
          .amount(application.getAmount())
          .tenor(application.getTenor())
          .installmentAmount(application.getInstallmentAmount())
          .productId(application.getProductId())
          .branchId(application.getBranch().getId())
          .processId(application.getProcessId())
          .build()
      );
    });

    return result;
  }

  @Override
  public ApplicationResponse findById(UUID id) {
    Application application = applicationRepository
      .findByIdAndActiveIsTrue(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return ApplicationResponse
      .builder()
      .applicationId(application.getId())
      .applicationNumber(application.getNumber().toString())
      .leadId(application.getLeadId())
      .leadNumber(application.getLeadNumber())
      .applicationStatus(application.getStatus())
      .leadNumber(application.getLeadNumber())
      .collateral(applicationMapper.convertToApplicationCollateralResponse(application.getCollateral()))
      .applicant(applicationMapper.convertToApplicationApplicantResponse(application.getApplicant()))
      .amount(application.getAmount())
      .tenor(application.getTenor())
      .installmentAmount(application.getInstallmentAmount())
      .productId(application.getProductId())
      .branchId(application.getBranch().getId())
      .processId(application.getProcessId())
      .build();
  }

  @Override
  public List<ApplicationCollateralResponse> findAllCollateral() {
    List<Collateral> collaterals = Streamable.of(collateralRepository.findAllByActiveIsTrue()).toList();

    List<ApplicationCollateralResponse> result = new ArrayList<>();
    collaterals.forEach(collateral -> {
      result.add(
        ApplicationCollateralResponse
          .builder()
          .collateralId(collateral.getId())
          .brandCode(collateral.getBrandCode())
          .brandName(collateral.getBrandName())
          .modelCode(collateral.getModelCode())
          .modelName(collateral.getModelName())
          .variantCode(collateral.getVariantCode())
          .variantName(collateral.getVariantName())
          .yearMade(collateral.getYearMade())
          .valueEstimate(collateral.getValueEstimate())
          .licenseNumber(collateral.getLicenseNumber())
          .registrationNumber(collateral.getRegistrationNumber())
          .registrationPhoto(collateral.getRegistrationPhoto())
          .build()
      );
    });
    return result;
  }

  @Override
  public ApplicationCollateralResponse findByCollateralId(ApplicationCollateralByIdRequest idRequest) {
    Collateral collateral = collateralRepository.findCollateralById(idRequest.getCollateralId()).orElseThrow(
      ()->new ResponseStatusException(HttpStatus.NOT_FOUND)
    );
    collateral = collateralRepository.save(collateral);
    return ApplicationCollateralResponse
      .builder()
      .collateralId(collateral.getId())
      .brandCode(collateral.getBrandCode())
      .brandName(collateral.getBrandName())
      .modelCode(collateral.getModelCode())
      .modelName(collateral.getModelName())
      .variantCode(collateral.getVariantCode())
      .variantName(collateral.getVariantName())
      .yearMade(collateral.getYearMade())
      .valueEstimate(collateral.getValueEstimate())
      .licenseNumber(collateral.getLicenseNumber())
      .registrationNumber(collateral.getRegistrationNumber())
      .registrationPhoto(collateral.getRegistrationPhoto())
      .build();
  }
}

package com.bfi.bravo.service.impl;

import com.bfi.bravo.constant.AppConstants;
import com.bfi.bravo.constant.NotificationConstants.ActionType;
import com.bfi.bravo.constant.NotificationConstants.NotificationStatus;
import com.bfi.bravo.constant.NotificationConstants.ReadStatus;
import com.bfi.bravo.constant.SurveyorConstants.AssignmentStatus;
import com.bfi.bravo.dto.notification.request.SurveyorNotificationCreateRequest;
import com.bfi.bravo.dto.notification.response.SurveyorNotificationCreateResponse;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentCreateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentPhysicalDocumentSubmitUpdateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentPhysicalDocumentSubmitsUpdateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentSurveyDoneUpdateRequest;
import com.bfi.bravo.dto.surveyor.response.*;
import com.bfi.bravo.entity.Application;
import com.bfi.bravo.entity.Branch;
import com.bfi.bravo.entity.SurveyorAssignment;
import com.bfi.bravo.entity.SurveyorAssignmentCollateralInformation;
import com.bfi.bravo.entity.SurveyorAssignmentDocumentSign;
import com.bfi.bravo.entity.SurveyorAssignmentEmergencyContact;
import com.bfi.bravo.entity.SurveyorAssignmentLoanInformation;
import com.bfi.bravo.entity.SurveyorAssignmentOccupationData;
import com.bfi.bravo.entity.SurveyorAssignmentPersonalData;
import com.bfi.bravo.entity.SurveyorAssignmentPhysicalDocument;
import com.bfi.bravo.repository.ApplicationRepository;
import com.bfi.bravo.repository.BranchRepository;
import com.bfi.bravo.repository.SurveyorAssignmentCollateralInformationRepository;
import com.bfi.bravo.repository.SurveyorAssignmentDocumentSignRepository;
import com.bfi.bravo.repository.SurveyorAssignmentEmergencyContactRepository;
import com.bfi.bravo.repository.SurveyorAssignmentLoanInformationRepository;
import com.bfi.bravo.repository.SurveyorAssignmentOccupationDataRepository;
import com.bfi.bravo.repository.SurveyorAssignmentPersonalDataRepository;
import com.bfi.bravo.repository.SurveyorAssignmentPhysicalDocumentRepository;
import com.bfi.bravo.repository.SurveyorAssignmentRepository;
import com.bfi.bravo.service.SurveyorAssignmentService;
import com.bfi.bravo.service.SurveyorNotificationService;
import com.bfi.bravo.utils.DateUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
public class SurveyorAssignmentServiceImpl implements SurveyorAssignmentService {

  @Autowired
  private SurveyorAssignmentRepository surveyorAssignmentRepository;

  @Autowired
  private ApplicationRepository applicationRepository;

  @Autowired
  private BranchRepository branchRepository;

  @Autowired
  private SurveyorAssignmentCollateralInformationRepository surveyorAssignmentCollateralInformationRepository;

  @Autowired
  private SurveyorAssignmentDocumentSignRepository surveyorAssignmentDocumentSignRepository;

  @Autowired
  private SurveyorAssignmentLoanInformationRepository surveyorAssignmentLoanInformationRepository;

  @Autowired
  private SurveyorAssignmentPersonalDataRepository surveyorAssignmentPersonalDataRepository;

  @Autowired
  private SurveyorAssignmentPhysicalDocumentRepository surveyorAssignmentPhysicalDocumentRepository;

  @Autowired
  private SurveyorAssignmentOccupationDataRepository surveyorAssignmentOccupationDataRepository;

  @Autowired
  private SurveyorAssignmentEmergencyContactRepository surveyorAssignmentEmergencyContactRepository;

  @Autowired
  private SurveyorNotificationService surveyorNotificationService;

  @Autowired
  private RuntimeService runtimeService;

  @Autowired
  private TaskService taskService;

  @Override
  public SurveyorAssignmentCreateResponse create(SurveyorAssignmentCreateRequest request) {
    Application application = applicationRepository
      .findByIdAndActiveIsTrue(request.getApplicationId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    Branch branch = branchRepository
      .findByIdAndActiveIsTrue(request.getBranchId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    SurveyorAssignment surveyorAssignment = surveyorAssignmentRepository.save(
      SurveyorAssignment
        .builder()
        .application(application)
        .applicationNumber(request.getApplicationNumber())
        .leadId(request.getLeadId())
        .leadNumber(request.getLeadNumber())
        .surveyorId(request.getSurveyorId())
        .assignmentType(request.getAssignmentType())
        .assignmentStatus(AssignmentStatus.WIP)
        .branch(branch)
        .productId(request.getProductId())
        .build()
    );

    //Surveyor Assignment Collateral Information
    SurveyorAssignmentCollateralInformation surveyorAssignmentCollateralInformation = surveyorAssignmentCollateralInformationRepository.save(
      SurveyorAssignmentCollateralInformation.builder().assignment(surveyorAssignment).build()
    );

    surveyorAssignmentCollateralInformation.setBrandCode(application.getCollateral().getBrandCode());
    surveyorAssignmentCollateralInformation.setBrandName(application.getCollateral().getBrandName());
    surveyorAssignmentCollateralInformation.setModelCode(application.getCollateral().getModelCode());
    surveyorAssignmentCollateralInformation.setModelName(application.getCollateral().getModelName());
    surveyorAssignmentCollateralInformation.setVariantCode(application.getCollateral().getVariantCode());
    surveyorAssignmentCollateralInformation.setVariantName(application.getCollateral().getVariantName());
    surveyorAssignmentCollateralInformation.setYearMade(application.getCollateral().getYearMade());
    surveyorAssignmentCollateralInformation.setLicenseNumber(application.getCollateral().getLicenseNumber());
    surveyorAssignmentCollateralInformation.setVehicleRegistrationPhoto(
      application.getCollateral().getRegistrationPhoto()
    );
    surveyorAssignmentCollateralInformationRepository.save(surveyorAssignmentCollateralInformation);

    //Surveyor Assignment Document Sign
    SurveyorAssignmentDocumentSign surveyorAssignmentDocumentSign = surveyorAssignmentDocumentSignRepository.save(
      SurveyorAssignmentDocumentSign.builder().assignment(surveyorAssignment).build()
    );

    //Surveyor Assignment Loan Information
    SurveyorAssignmentLoanInformation surveyorAssignmentLoanInformation = surveyorAssignmentLoanInformationRepository.save(
      SurveyorAssignmentLoanInformation.builder().assignment(surveyorAssignment).build()
    );

    surveyorAssignmentLoanInformation.setAmount(application.getAmount());
    surveyorAssignmentLoanInformation.setTenor(application.getTenor());
    surveyorAssignmentLoanInformation.setInstallmentAmount(application.getInstallmentAmount());
    surveyorAssignmentLoanInformationRepository.save(surveyorAssignmentLoanInformation);

    //Surveyor Assignment Personal Data
    SurveyorAssignmentPersonalData surveyorAssignmentPersonalData = surveyorAssignmentPersonalDataRepository.save(
      SurveyorAssignmentPersonalData.builder().assignment(surveyorAssignment).build()
    );

    surveyorAssignmentPersonalData.setCustomerId(application.getApplicant().getCustomerId());
    surveyorAssignmentPersonalData.setCustomerName(application.getApplicant().getFullName());
    surveyorAssignmentPersonalData.setCustomerDomicileAddress(application.getApplicant().getAddress());
    surveyorAssignmentPersonalData.setCustomerDomicileAdditionalAddress(
      application.getApplicant().getAdditionalAddress()
    );
    surveyorAssignmentPersonalData.setCustomerDomicileProvinceCode(application.getApplicant().getProvinceCode());
    surveyorAssignmentPersonalData.setCustomerDomicileProvinceName(application.getApplicant().getProvinceName());
    surveyorAssignmentPersonalData.setCustomerDomicileCityCode(application.getApplicant().getCityCode());
    surveyorAssignmentPersonalData.setCustomerDomicileCityName(application.getApplicant().getCityName());
    surveyorAssignmentPersonalData.setCustomerDomicileDistrictCode(application.getApplicant().getDistrictCode());
    surveyorAssignmentPersonalData.setCustomerDomicileDistrictName(application.getApplicant().getDistrictName());
    surveyorAssignmentPersonalData.setCustomerDomicileSubdistrictCode(application.getApplicant().getSubdistrictCode());
    surveyorAssignmentPersonalData.setCustomerDomicileSubdistrictName(application.getApplicant().getSubdistrictName());
    surveyorAssignmentPersonalData.setCustomerDomicileZipcode(application.getApplicant().getZipcode());
    surveyorAssignmentPersonalData.setCustomerDomicileLongitude(application.getApplicant().getLongitude());
    surveyorAssignmentPersonalData.setCustomerDomicileLatitude(application.getApplicant().getLatitude());
    surveyorAssignmentPersonalData.setCustomerPhoneNumber(application.getApplicant().getPhoneNumber());
    surveyorAssignmentPersonalData.setCustomerSelfiePhoto(application.getApplicant().getSelfiePhoto());
    surveyorAssignmentPersonalData.setCustomerIdentityCardPhoto(application.getApplicant().getIdentityPhoto());
    surveyorAssignmentPersonalData.setCustomerSpouseIdentityCardPhoto(
      application.getApplicant().getSpouseIdentityPhoto()
    );
    surveyorAssignmentPersonalDataRepository.save(surveyorAssignmentPersonalData);

    //Surveyor Assignment Physical Document
    SurveyorAssignmentPhysicalDocument surveyorAssignmentPhysicalDocument = surveyorAssignmentPhysicalDocumentRepository.save(
      SurveyorAssignmentPhysicalDocument.builder().assignment(surveyorAssignment).build()
    );

    //Surveyor Assignment Occupation Data
    SurveyorAssignmentOccupationData surveyorAssignmentOccupationData = surveyorAssignmentOccupationDataRepository.save(
      SurveyorAssignmentOccupationData.builder().assignment(surveyorAssignment).build()
    );

    //Surveyor Assignment Emergency Contact
    SurveyorAssignmentEmergencyContact surveyorAssignmentEmergencyContact = surveyorAssignmentEmergencyContactRepository.save(
      SurveyorAssignmentEmergencyContact.builder().assignment(surveyorAssignment).build()
    );

    //Surveyor Notification
    SurveyorNotificationCreateResponse surveyorNotificationCreateResponse = surveyorNotificationService.create(
      SurveyorNotificationCreateRequest
        .builder()
        .surveyorId(request.getSurveyorId())
        .title("New Assignment")
        .message(String.format("You got new assignment with id : %s", String.valueOf(surveyorAssignment.getId())))
        .notificationStatus(NotificationStatus.ACTIVE)
        .readStatus(ReadStatus.UNREAD)
        .actionType(ActionType.BPKB)
        .build()
    );

    return SurveyorAssignmentCreateResponse.builder().assignmentId(surveyorAssignment.getId()).build();
  }

  @Override
  public SurveyorAssignmentSurveyDoneUpdateResponse surveyDone(SurveyorAssignmentSurveyDoneUpdateRequest request) {
    SurveyorAssignment surveyorAssignment = surveyorAssignmentRepository
      .findByIdAndActiveIsTrue(request.getAssignmentId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    List<Task> tasks = taskService
      .createTaskQuery()
      .processInstanceId(surveyorAssignment.getApplication().getProcessId().toString())
      .list();

    Task task = tasks.get(0);
    Map<String, Object> inputForm = new HashMap<>();
    inputForm.put("surveyResult", "success");
    taskService.complete(task.getId(), inputForm);

    surveyorAssignment.setAssignmentStatus(AssignmentStatus.COMPLETE);
    surveyorAssignmentRepository.save(surveyorAssignment);

    return SurveyorAssignmentSurveyDoneUpdateResponse.builder().assignmentId(surveyorAssignment.getId()).build();
  }

  @Override
  public SurveyorAssignmentPhysicalDocumentSubmitUpdateResponse physicalDocumentSubmit(
    SurveyorAssignmentPhysicalDocumentSubmitUpdateRequest request
  ) {
    SurveyorAssignment surveyorAssignment = surveyorAssignmentRepository
      .findByIdAndActiveIsTrue(request.getAssignmentId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    List<Task> tasks = taskService
      .createTaskQuery()
      .processInstanceId(surveyorAssignment.getApplication().getProcessId().toString())
      .list();

    Task task = tasks.get(0);
    Map<String, Object> inputForm = new HashMap<>();
    inputForm.put("documentPickupResult", "success");
    taskService.complete(task.getId(), inputForm);

    surveyorAssignment.setAssignmentStatus(AssignmentStatus.PHYSICAL_DOCUMENT_SUBMITTED);
    surveyorAssignmentRepository.save(surveyorAssignment);

    return SurveyorAssignmentPhysicalDocumentSubmitUpdateResponse
      .builder()
      .assignmentId(surveyorAssignment.getId())
      .build();
  }

  @Override
  public SurveyorAssignmentPhysicalDocumentSubmitsUpdateResponse physicalDocumentSubmits(
    SurveyorAssignmentPhysicalDocumentSubmitsUpdateRequest request
  ) {
    for (Long assignmentId : request.getAssignmentIds()) {
      SurveyorAssignment surveyorAssignment = surveyorAssignmentRepository
        .findByIdAndActiveIsTrue(assignmentId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

      List<Task> tasks = taskService
        .createTaskQuery()
        .processInstanceId(surveyorAssignment.getApplication().getProcessId().toString())
        .list();

      Task task = tasks.get(0);
      Map<String, Object> inputForm = new HashMap<>();
      inputForm.put("documentPickupResult", "success");
      taskService.complete(task.getId(), inputForm);

      surveyorAssignment.setAssignmentStatus(AssignmentStatus.PHYSICAL_DOCUMENT_SUBMITTED);
      surveyorAssignmentRepository.save(surveyorAssignment);
    }
    return SurveyorAssignmentPhysicalDocumentSubmitsUpdateResponse
      .builder()
      .count(Long.valueOf(request.getAssignmentIds().size()))
      .build();
  }

  @Override
  public List<SurveyorAssignmentResponse> findAll() {
    List<SurveyorAssignment> surveyorAssignments = Streamable
      .of(surveyorAssignmentRepository.findAllByActiveIsTrue())
      .toList();

    List<SurveyorAssignmentPersonalData> surveyorAssignmentPersonalDatas = Streamable
      .of(surveyorAssignmentPersonalDataRepository.findAllByActiveIsTrue())
      .toList();

    List<Branch> branches = Streamable.of(branchRepository.findAllByActiveIsTrue()).toList();

    List<SurveyorAssignmentResponse> result = new ArrayList<>();
    surveyorAssignments.forEach(surveyorAssignment -> {
      String branchName = null;
      String customerName = null;
      String customerAddress = null;
      String customerProvinceName = null;
      String customerCityName = null;
      String customerDistrictName = null;
      String customerSubdistrictName = null;
      String customerZipcode = null;
      BigDecimal customerLongitude = null;
      BigDecimal customerLatitude = null;
      String customerPhoneNumber = null;
      for (Branch branch : branches) {
        if (surveyorAssignment.getBranch().getId().longValue() == branch.getId().longValue()) {
          branchName = branch.getName();
        }
      }
      for (SurveyorAssignmentPersonalData surveyorAssignmentPersonalData : surveyorAssignmentPersonalDatas) {
        if (
          surveyorAssignment.getId().longValue() == surveyorAssignmentPersonalData.getAssignment().getId().longValue()
        ) {
          customerName = surveyorAssignmentPersonalData.getCustomerName();
          customerAddress = surveyorAssignmentPersonalData.getCustomerDomicileAddress();
          customerProvinceName = surveyorAssignmentPersonalData.getCustomerDomicileProvinceName();
          customerCityName = surveyorAssignmentPersonalData.getCustomerDomicileCityName();
          customerDistrictName = surveyorAssignmentPersonalData.getCustomerDomicileDistrictName();
          customerSubdistrictName = surveyorAssignmentPersonalData.getCustomerDomicileSubdistrictName();
          customerZipcode = surveyorAssignmentPersonalData.getCustomerDomicileZipcode();
          customerLongitude = surveyorAssignmentPersonalData.getCustomerDomicileLongitude();
          customerLatitude = surveyorAssignmentPersonalData.getCustomerDomicileLatitude();
          customerPhoneNumber = surveyorAssignmentPersonalData.getCustomerPhoneNumber();
        }
      }

      result.add(
        SurveyorAssignmentResponse
          .builder()
          .assignmentDate(DateUtil.formatDatetime(surveyorAssignment.getCreatedDate(), AppConstants.DATE_FORMAT_DATE_2))
          .assignmentId(surveyorAssignment.getId())
          .applicationId(surveyorAssignment.getApplication().getId())
          .applicationNumber(surveyorAssignment.getApplicationNumber())
          .leadId(surveyorAssignment.getLeadId())
          .leadNumber(surveyorAssignment.getLeadNumber())
          .surveyorId(surveyorAssignment.getSurveyorId())
          .assignmentType(surveyorAssignment.getAssignmentType())
          .assignmentStatus(surveyorAssignment.getAssignmentStatus())
          .loaded(surveyorAssignment.isLoaded())
          .branchName(branchName)
          .customerName(customerName)
          .customerAddress(customerAddress)
          .customerProvinceName(customerProvinceName)
          .customerCityName(customerCityName)
          .customerDistrictName(customerDistrictName)
          .customerSubdistrictName(customerSubdistrictName)
          .customerZipcode(customerZipcode)
          .customerLongitude(customerLongitude)
          .customerLatitude(customerLatitude)
          .customerPhoneNumber(customerPhoneNumber)
          .productId(surveyorAssignment.getProductId())
          .build()
      );
    });

    return result;
  }

  @Override
  public SurveyorAssignmentResponse findById(Long id) {
    SurveyorAssignment surveyorAssignment = surveyorAssignmentRepository
      .findByIdAndActiveIsTrue(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    List<SurveyorAssignmentPersonalData> surveyorAssignmentPersonalDatas = Streamable
      .of(surveyorAssignmentPersonalDataRepository.findAllByActiveIsTrue())
      .toList();

    String customerName = null;
    String customerAddress = null;
    String customerProvinceName = null;
    String customerCityName = null;
    String customerDistrictName = null;
    String customerSubdistrictName = null;
    String customerZipcode = null;
    BigDecimal customerLongitude = null;
    BigDecimal customerLatitude = null;
    String customerPhoneNumber = null;
    for (SurveyorAssignmentPersonalData surveyorAssignmentPersonalData : surveyorAssignmentPersonalDatas) {
      if (
        surveyorAssignment.getId().longValue() == surveyorAssignmentPersonalData.getAssignment().getId().longValue()
      ) {
        customerName = surveyorAssignmentPersonalData.getCustomerName();
        customerAddress = surveyorAssignmentPersonalData.getCustomerDomicileAddress();
        customerProvinceName = surveyorAssignmentPersonalData.getCustomerDomicileProvinceName();
        customerCityName = surveyorAssignmentPersonalData.getCustomerDomicileCityName();
        customerDistrictName = surveyorAssignmentPersonalData.getCustomerDomicileDistrictName();
        customerSubdistrictName = surveyorAssignmentPersonalData.getCustomerDomicileSubdistrictName();
        customerZipcode = surveyorAssignmentPersonalData.getCustomerDomicileZipcode();
        customerLongitude = surveyorAssignmentPersonalData.getCustomerDomicileLongitude();
        customerLatitude = surveyorAssignmentPersonalData.getCustomerDomicileLatitude();
        customerPhoneNumber = surveyorAssignmentPersonalData.getCustomerPhoneNumber();
      }
    }

    Branch branch = branchRepository
      .findByIdAndActiveIsTrue(surveyorAssignment.getBranch().getId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return SurveyorAssignmentResponse
      .builder()
      .assignmentDate(DateUtil.formatDatetime(surveyorAssignment.getCreatedDate(), AppConstants.DATE_FORMAT_DATE_2))
      .assignmentId(surveyorAssignment.getId())
      .applicationId(surveyorAssignment.getApplication().getId())
      .applicationNumber(surveyorAssignment.getApplicationNumber())
      .leadId(surveyorAssignment.getLeadId())
      .leadNumber(surveyorAssignment.getLeadNumber())
      .surveyorId(surveyorAssignment.getSurveyorId())
      .assignmentType(surveyorAssignment.getAssignmentType())
      .assignmentStatus(surveyorAssignment.getAssignmentStatus())
      .loaded(surveyorAssignment.isLoaded())
      .branchName(branch.getName())
      .customerName(customerName)
      .customerAddress(customerAddress)
      .customerProvinceName(customerProvinceName)
      .customerCityName(customerCityName)
      .customerDistrictName(customerDistrictName)
      .customerSubdistrictName(customerSubdistrictName)
      .customerZipcode(customerZipcode)
      .customerLongitude(customerLongitude)
      .customerLatitude(customerLatitude)
      .customerPhoneNumber(customerPhoneNumber)
      .productId(surveyorAssignment.getProductId())
      .build();
  }

  @Override
  public List<SurveyorAssignmentResponse> findAllBySurveyorId(String surveyorId) {
    List<SurveyorAssignment> surveyorAssignments = Streamable
      .of(surveyorAssignmentRepository.findAllBySurveyorIdAndActiveIsTrue(surveyorId))
      .toList();

    List<SurveyorAssignmentPersonalData> surveyorAssignmentPersonalDatas = Streamable
      .of(surveyorAssignmentPersonalDataRepository.findAllByActiveIsTrue())
      .toList();

    List<Branch> branches = Streamable.of(branchRepository.findAllByActiveIsTrue()).toList();

    List<SurveyorAssignmentResponse> result = new ArrayList<>();
    surveyorAssignments.forEach(surveyorAssignment -> {
      String branchName = null;
      String customerName = null;
      String customerAddress = null;
      String customerProvinceName = null;
      String customerCityName = null;
      String customerDistrictName = null;
      String customerSubdistrictName = null;
      String customerZipcode = null;
      BigDecimal customerLongitude = null;
      BigDecimal customerLatitude = null;
      String customerPhoneNumber = null;
      for (Branch branch : branches) {
        if (surveyorAssignment.getBranch().getId().longValue() == branch.getId().longValue()) {
          branchName = branch.getName();
        }
      }
      for (SurveyorAssignmentPersonalData surveyorAssignmentPersonalData : surveyorAssignmentPersonalDatas) {
        if (
          surveyorAssignment.getId().longValue() == surveyorAssignmentPersonalData.getAssignment().getId().longValue()
        ) {
          customerName = surveyorAssignmentPersonalData.getCustomerName();
          customerAddress = surveyorAssignmentPersonalData.getCustomerDomicileAddress();
          customerProvinceName = surveyorAssignmentPersonalData.getCustomerDomicileProvinceName();
          customerCityName = surveyorAssignmentPersonalData.getCustomerDomicileCityName();
          customerDistrictName = surveyorAssignmentPersonalData.getCustomerDomicileDistrictName();
          customerSubdistrictName = surveyorAssignmentPersonalData.getCustomerDomicileSubdistrictName();
          customerZipcode = surveyorAssignmentPersonalData.getCustomerDomicileZipcode();
          customerLongitude = surveyorAssignmentPersonalData.getCustomerDomicileLongitude();
          customerLatitude = surveyorAssignmentPersonalData.getCustomerDomicileLatitude();
          customerPhoneNumber = surveyorAssignmentPersonalData.getCustomerPhoneNumber();
        }
      }

      result.add(
        SurveyorAssignmentResponse
          .builder()
          .assignmentDate(DateUtil.formatDatetime(surveyorAssignment.getCreatedDate(), AppConstants.DATE_FORMAT_DATE_2))
          .assignmentId(surveyorAssignment.getId())
          .applicationId(surveyorAssignment.getApplication().getId())
          .applicationNumber(surveyorAssignment.getApplicationNumber())
          .leadId(surveyorAssignment.getLeadId())
          .leadNumber(surveyorAssignment.getLeadNumber())
          .surveyorId(surveyorAssignment.getSurveyorId())
          .assignmentType(surveyorAssignment.getAssignmentType())
          .assignmentStatus(surveyorAssignment.getAssignmentStatus())
          .loaded(surveyorAssignment.isLoaded())
          .branchName(branchName)
          .customerName(customerName)
          .customerAddress(customerAddress)
          .customerProvinceName(customerProvinceName)
          .customerCityName(customerCityName)
          .customerDistrictName(customerDistrictName)
          .customerSubdistrictName(customerSubdistrictName)
          .customerZipcode(customerZipcode)
          .customerLongitude(customerLongitude)
          .customerLatitude(customerLatitude)
          .customerPhoneNumber(customerPhoneNumber)
          .productId(surveyorAssignment.getProductId())
          .build()
      );
    });

    return result;
  }
}

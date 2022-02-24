package com.bfi.bravo.service.impl;

import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentCollateralInformationCreateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentCollateralInformationUpdateRequest;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentCollateralInformationCreateResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentCollateralInformationResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentCollateralInformationUpdateResponse;
import com.bfi.bravo.entity.SurveyorAssignment;
import com.bfi.bravo.entity.SurveyorAssignmentCollateralInformation;
import com.bfi.bravo.repository.SurveyorAssignmentCollateralInformationRepository;
import com.bfi.bravo.repository.SurveyorAssignmentRepository;
import com.bfi.bravo.service.SurveyorAssignmentCollateralInformationService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
public class SurveyorAssignmentCollateralInformationServiceImpl
  implements SurveyorAssignmentCollateralInformationService {

  @Autowired
  private SurveyorAssignmentCollateralInformationRepository surveyorAssignmentCollateralInformationRepository;

  @Autowired
  private SurveyorAssignmentRepository surveyorAssignmentRepository;

  @Override
  public SurveyorAssignmentCollateralInformationCreateResponse create(
    SurveyorAssignmentCollateralInformationCreateRequest request
  ) {
    SurveyorAssignment surveyorAssignment = surveyorAssignmentRepository
      .findByIdAndActiveIsTrue(request.getAssignmentId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    SurveyorAssignmentCollateralInformation surveyorAssignmentCollateralInformation = surveyorAssignmentCollateralInformationRepository.save(
      SurveyorAssignmentCollateralInformation.builder().assignment(surveyorAssignment).build()
    );

    return SurveyorAssignmentCollateralInformationCreateResponse
      .builder()
      .assignmentCollateralInformationId(surveyorAssignmentCollateralInformation.getId())
      .build();
  }

  @Override
  public SurveyorAssignmentCollateralInformationUpdateResponse update(
    SurveyorAssignmentCollateralInformationUpdateRequest request
  ) {
    SurveyorAssignmentCollateralInformation surveyorAssignmentCollateralInformation = surveyorAssignmentCollateralInformationRepository
      .findByIdAndActiveIsTrue(request.getAssignmentCollateralInformationId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    surveyorAssignmentCollateralInformation.setBrandCode(request.getBrandCode());
    surveyorAssignmentCollateralInformation.setBrandName(request.getBrandName());
    surveyorAssignmentCollateralInformation.setModelCode(request.getModelCode());
    surveyorAssignmentCollateralInformation.setModelName(request.getModelName());
    surveyorAssignmentCollateralInformation.setVariantCode(request.getVariantCode());
    surveyorAssignmentCollateralInformation.setVariantName(request.getVariantName());
    surveyorAssignmentCollateralInformation.setYearMade(request.getYearMade());
    surveyorAssignmentCollateralInformation.setLicenseNumber(request.getLicenseNumber());
    surveyorAssignmentCollateralInformation.setVehicleRegistrationPhoto(request.getVehicleRegistrationPhoto());
    surveyorAssignmentCollateralInformation.setVehicleTaxNoticePhoto(request.getVehicleTaxNoticePhoto());
    surveyorAssignmentCollateralInformation.setVehicleLeftSidePhoto(request.getVehicleLeftSidePhoto());
    surveyorAssignmentCollateralInformation.setVehicleRightSidePhoto(request.getVehicleRightSidePhoto());
    surveyorAssignmentCollateralInformation.setVehicleFrontSidePhoto(request.getVehicleFrontSidePhoto());
    surveyorAssignmentCollateralInformation.setVehicleBackSidePhoto(request.getVehicleBackSidePhoto());
    surveyorAssignmentCollateralInformation.setVehicleDashboardSidePhoto(request.getVehicleDashboardSidePhoto());
    surveyorAssignmentCollateralInformationRepository.save(surveyorAssignmentCollateralInformation);

    return SurveyorAssignmentCollateralInformationUpdateResponse
      .builder()
      .assignmentCollateralInformationId(surveyorAssignmentCollateralInformation.getId())
      .assignmentId(surveyorAssignmentCollateralInformation.getAssignment().getId())
      .build();
  }

  @Override
  public List<SurveyorAssignmentCollateralInformationResponse> findAll() {
    List<SurveyorAssignmentCollateralInformation> surveyorAssignmentCollateralInformations = Streamable
      .of(surveyorAssignmentCollateralInformationRepository.findAllByActiveIsTrue())
      .toList();

    List<SurveyorAssignmentCollateralInformationResponse> result = new ArrayList<>();
    surveyorAssignmentCollateralInformations.forEach(surveyorAssignmentCollateralInformation -> {
      result.add(
        SurveyorAssignmentCollateralInformationResponse
          .builder()
          .assignmentCollateralInformationId(surveyorAssignmentCollateralInformation.getId())
          .assignmentId(surveyorAssignmentCollateralInformation.getAssignment().getId())
          .brandCode(surveyorAssignmentCollateralInformation.getBrandCode())
          .brandName(surveyorAssignmentCollateralInformation.getBrandName())
          .modelCode(surveyorAssignmentCollateralInformation.getModelCode())
          .modelName(surveyorAssignmentCollateralInformation.getModelName())
          .variantCode(surveyorAssignmentCollateralInformation.getVariantCode())
          .variantName(surveyorAssignmentCollateralInformation.getVariantName())
          .yearMade(surveyorAssignmentCollateralInformation.getYearMade())
          .licenseNumber(surveyorAssignmentCollateralInformation.getLicenseNumber())
          .vehicleRegistrationPhoto(surveyorAssignmentCollateralInformation.getVehicleRegistrationPhoto())
          .vehicleTaxNoticePhoto(surveyorAssignmentCollateralInformation.getVehicleTaxNoticePhoto())
          .vehicleLeftSidePhoto(surveyorAssignmentCollateralInformation.getVehicleLeftSidePhoto())
          .vehicleRightSidePhoto(surveyorAssignmentCollateralInformation.getVehicleRightSidePhoto())
          .vehicleFrontSidePhoto(surveyorAssignmentCollateralInformation.getVehicleFrontSidePhoto())
          .vehicleBackSidePhoto(surveyorAssignmentCollateralInformation.getVehicleBackSidePhoto())
          .vehicleDashboardSidePhoto(surveyorAssignmentCollateralInformation.getVehicleDashboardSidePhoto())
          .build()
      );
    });

    return result;
  }

  @Override
  public SurveyorAssignmentCollateralInformationResponse findById(Long id) {
    SurveyorAssignmentCollateralInformation surveyorAssignmentCollateralInformation = surveyorAssignmentCollateralInformationRepository
      .findByIdAndActiveIsTrue(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return SurveyorAssignmentCollateralInformationResponse
      .builder()
      .assignmentCollateralInformationId(surveyorAssignmentCollateralInformation.getId())
      .assignmentId(surveyorAssignmentCollateralInformation.getAssignment().getId())
      .brandCode(surveyorAssignmentCollateralInformation.getBrandCode())
      .brandName(surveyorAssignmentCollateralInformation.getBrandName())
      .modelCode(surveyorAssignmentCollateralInformation.getModelCode())
      .modelName(surveyorAssignmentCollateralInformation.getModelName())
      .variantCode(surveyorAssignmentCollateralInformation.getVariantCode())
      .variantName(surveyorAssignmentCollateralInformation.getVariantName())
      .yearMade(surveyorAssignmentCollateralInformation.getYearMade())
      .licenseNumber(surveyorAssignmentCollateralInformation.getLicenseNumber())
      .vehicleRegistrationPhoto(surveyorAssignmentCollateralInformation.getVehicleRegistrationPhoto())
      .vehicleTaxNoticePhoto(surveyorAssignmentCollateralInformation.getVehicleTaxNoticePhoto())
      .vehicleLeftSidePhoto(surveyorAssignmentCollateralInformation.getVehicleLeftSidePhoto())
      .vehicleRightSidePhoto(surveyorAssignmentCollateralInformation.getVehicleRightSidePhoto())
      .vehicleFrontSidePhoto(surveyorAssignmentCollateralInformation.getVehicleFrontSidePhoto())
      .vehicleBackSidePhoto(surveyorAssignmentCollateralInformation.getVehicleBackSidePhoto())
      .vehicleDashboardSidePhoto(surveyorAssignmentCollateralInformation.getVehicleDashboardSidePhoto())
      .build();
  }

  @Override
  public SurveyorAssignmentCollateralInformationResponse findByAssignmentId(Long assignmentId) {
    SurveyorAssignmentCollateralInformation surveyorAssignmentCollateralInformation = surveyorAssignmentCollateralInformationRepository
      .findByAssignmentIdAndActiveIsTrue(assignmentId)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return SurveyorAssignmentCollateralInformationResponse
      .builder()
      .assignmentCollateralInformationId(surveyorAssignmentCollateralInformation.getId())
      .assignmentId(surveyorAssignmentCollateralInformation.getAssignment().getId())
      .brandCode(surveyorAssignmentCollateralInformation.getBrandCode())
      .brandName(surveyorAssignmentCollateralInformation.getBrandName())
      .modelCode(surveyorAssignmentCollateralInformation.getModelCode())
      .modelName(surveyorAssignmentCollateralInformation.getModelName())
      .variantCode(surveyorAssignmentCollateralInformation.getVariantCode())
      .variantName(surveyorAssignmentCollateralInformation.getVariantName())
      .yearMade(surveyorAssignmentCollateralInformation.getYearMade())
      .licenseNumber(surveyorAssignmentCollateralInformation.getLicenseNumber())
      .vehicleRegistrationPhoto(surveyorAssignmentCollateralInformation.getVehicleRegistrationPhoto())
      .vehicleTaxNoticePhoto(surveyorAssignmentCollateralInformation.getVehicleTaxNoticePhoto())
      .vehicleLeftSidePhoto(surveyorAssignmentCollateralInformation.getVehicleLeftSidePhoto())
      .vehicleRightSidePhoto(surveyorAssignmentCollateralInformation.getVehicleRightSidePhoto())
      .vehicleFrontSidePhoto(surveyorAssignmentCollateralInformation.getVehicleFrontSidePhoto())
      .vehicleBackSidePhoto(surveyorAssignmentCollateralInformation.getVehicleBackSidePhoto())
      .vehicleDashboardSidePhoto(surveyorAssignmentCollateralInformation.getVehicleDashboardSidePhoto())
      .build();
  }
}

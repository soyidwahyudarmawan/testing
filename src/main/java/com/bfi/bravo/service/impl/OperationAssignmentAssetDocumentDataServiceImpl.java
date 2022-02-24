package com.bfi.bravo.service.impl;

import com.bfi.bravo.dto.operation.request.*;
import com.bfi.bravo.dto.operation.response.*;
import com.bfi.bravo.entity.OperationAssignment;
import com.bfi.bravo.entity.OperationAssignmentAssetDocumentData;
import com.bfi.bravo.repository.OperationAssignmentAssetDocumentDataRepository;
import com.bfi.bravo.repository.OperationAssignmentRepository;
import com.bfi.bravo.service.OperationAssignmentAssetDocumentDataService;
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
public class OperationAssignmentAssetDocumentDataServiceImpl implements OperationAssignmentAssetDocumentDataService {

  @Autowired
  OperationAssignmentAssetDocumentDataRepository operationalAssignmentAssetDocumentDataRepository;

  @Autowired
  OperationAssignmentRepository operationalAssignmentRepository;

  @Override
  public OperationAssignmentAssetDocumentDataCreateResponse create(
    OperationAssignmentAssetDocumentDataCreateRequest request
  ) {
    OperationAssignment operationalAssignment = operationalAssignmentRepository
      .findById(request.getAssignmentId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    OperationAssignmentAssetDocumentData operationAssignmentAssetDocumentData = operationalAssignmentAssetDocumentDataRepository.save(
      OperationAssignmentAssetDocumentData.builder().assignment(operationalAssignment).build()
    );

    return OperationAssignmentAssetDocumentDataCreateResponse
      .builder()
      .assignmentAssetDocumentDataId(operationAssignmentAssetDocumentData.getId())
      .build();
  }

  @Override
  public OperationAssignmentAssetDocumentDataChecklistUpdateResponse updateChecklist(
    OperationAssignmentAssetDocumentDataChecklistUpdateRequest request
  ) {
    OperationAssignmentAssetDocumentData operationAssignmentAssetDocumentData = operationalAssignmentAssetDocumentDataRepository
      .findByAssignmentIdAndActiveIsTrue(request.getAssignmentId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    operationAssignmentAssetDocumentData.setVehicleOwnershipCompleted(request.isVehicleOwnershipCompleted());
    operationAssignmentAssetDocumentData.setTaxNoticeCompleted(request.isTaxNoticeCompleted());
    operationAssignmentAssetDocumentData.setVehicleRegistrationCompleted(request.isVehicleRegistrationCompleted());
    operationalAssignmentAssetDocumentDataRepository.save(operationAssignmentAssetDocumentData);

    return OperationAssignmentAssetDocumentDataChecklistUpdateResponse
      .builder()
      .assignmentAssetDocumentDataId(operationAssignmentAssetDocumentData.getId())
      .assignmentId(operationAssignmentAssetDocumentData.getAssignment().getId())
      .build();
  }

  @Override
  public OperationAssignmentAssetDocumentDataVehicleOwnershipUpdateResponse updateVehicleOwnership(
    OperationAssignmentAssetDocumentDataVehicleOwnershipUpdateRequest request
  ) {
    OperationAssignmentAssetDocumentData operationAssignmentAssetDocumentData = operationalAssignmentAssetDocumentDataRepository
      .findByAssignmentIdAndActiveIsTrue(request.getAssignmentId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    operationAssignmentAssetDocumentData.setVehicleOwnershipNumber(request.getVehicleOwnershipNumber());
    operationAssignmentAssetDocumentData.setVehicleOwnershipOnBehalfOf(request.getVehicleOwnershipOnBehalfOf());
    operationAssignmentAssetDocumentData.setVehicleOwnershipChassisNumber(request.getVehicleOwnershipChassisNumber());
    operationAssignmentAssetDocumentData.setVehicleOwnershipMachineNumber(request.getVehicleOwnershipMachineNumber());
    operationalAssignmentAssetDocumentDataRepository.save(operationAssignmentAssetDocumentData);

    return OperationAssignmentAssetDocumentDataVehicleOwnershipUpdateResponse
      .builder()
      .assignmentAssetDocumentDataId(operationAssignmentAssetDocumentData.getId())
      .assignmentId(operationAssignmentAssetDocumentData.getAssignment().getId())
      .build();
  }

  @Override
  public OperationAssignmentAssetDocumentDataVehicleRegistrationUpdateResponse updateVehicleRegistration(
    OperationAssignmentAssetDocumentDataVehicleRegistrationUpdateRequest request
  ) {
    OperationAssignmentAssetDocumentData operationAssignmentAssetDocumentData = operationalAssignmentAssetDocumentDataRepository
      .findByAssignmentIdAndActiveIsTrue(request.getAssignmentId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    operationAssignmentAssetDocumentData.setVehicleRegistrationNumber(request.getVehicleRegistrationNumber());
    operationAssignmentAssetDocumentData.setVehicleRegistrationExpiredDate(request.getVehicleRegistrationExpiredDate());
    operationAssignmentAssetDocumentData.setVehicleRegistrationColor(request.getVehicleRegistrationColor());
    operationAssignmentAssetDocumentData.setVehicleRegistrationChassisNumber(request.getVehicleRegistrationChassisNumber());
    operationAssignmentAssetDocumentData.setVehicleRegistrationMachineNumber(request.getVehicleRegistrationMachineNumber());
    operationalAssignmentAssetDocumentDataRepository.save(operationAssignmentAssetDocumentData);

    return OperationAssignmentAssetDocumentDataVehicleRegistrationUpdateResponse
      .builder()
      .assignmentAssetDocumentDataId(operationAssignmentAssetDocumentData.getId())
      .assignmentId(operationAssignmentAssetDocumentData.getAssignment().getId())
      .build();
  }

  @Override
  public OperationAssignmentAssetDocumentDataTaxNoticeUpdateResponse updateTaxNotice(
    OperationAssignmentAssetDocumentDataTaxNoticeUpdateRequest request
  ) {
    OperationAssignmentAssetDocumentData operationAssignmentAssetDocumentData = operationalAssignmentAssetDocumentDataRepository
      .findByAssignmentIdAndActiveIsTrue(request.getAssignmentId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    operationAssignmentAssetDocumentData.setTaxNoticeNumber(request.getTaxNoticeNumber());
    operationAssignmentAssetDocumentData.setTaxNoticeExpiredDate(request.getTaxNoticeExpiredDate());
    operationAssignmentAssetDocumentData.setTaxNoticeColor(request.getTaxNoticeColor());
    operationAssignmentAssetDocumentData.setTaxNoticeChassisNumber(request.getTaxNoticeChassisNumber());
    operationAssignmentAssetDocumentData.setTaxNoticeMachineNumber(request.getTaxNoticeMachineNumber());
    operationalAssignmentAssetDocumentDataRepository.save(operationAssignmentAssetDocumentData);

    return OperationAssignmentAssetDocumentDataTaxNoticeUpdateResponse
      .builder()
      .assignmentAssetDocumentDataId(operationAssignmentAssetDocumentData.getId())
      .assignmentId(operationAssignmentAssetDocumentData.getAssignment().getId())
      .build();
  }

  @Override
  public List<OperationAssignmentAssetDocumentDataResponse> findAll() {
    List<OperationAssignmentAssetDocumentData> operationAssignmentAssetDocumentDatas = Streamable
      .of(operationalAssignmentAssetDocumentDataRepository.findAllByActiveIsTrue())
      .toList();

    List<OperationAssignmentAssetDocumentDataResponse> result = new ArrayList<>();
    operationAssignmentAssetDocumentDatas.forEach(operationAssignmentAssetDocumentData -> {
      result.add(
        OperationAssignmentAssetDocumentDataResponse
          .builder()
          .assignmentAssetDocumentDataId(operationAssignmentAssetDocumentData.getId())
          .assignmentId(operationAssignmentAssetDocumentData.getAssignment().getId())
          .vehicleOwnershipCompleted(operationAssignmentAssetDocumentData.isVehicleOwnershipCompleted())
          .vehicleRegistrationCompleted(operationAssignmentAssetDocumentData.isVehicleRegistrationCompleted())
          .taxNoticeCompleted(operationAssignmentAssetDocumentData.isTaxNoticeCompleted())
          .assetCodeBrand(operationAssignmentAssetDocumentData.getAssetCodeBrand())
          .assetBrandName(operationAssignmentAssetDocumentData.getAssetBrandName())
          .assetCodeModel(operationAssignmentAssetDocumentData.getAssetCodeModel())
          .assetModelName(operationAssignmentAssetDocumentData.getAssetModelName())
          .assetCodeVariant(operationAssignmentAssetDocumentData.getAssetCodeVariant())
          .assetVariantName(operationAssignmentAssetDocumentData.getAssetVariantName())
          .assetYearMade(operationAssignmentAssetDocumentData.getAssetYearMade())
          .licenseNumber(operationAssignmentAssetDocumentData.getLicenseNumber())
          .vehicleOwnershipNumber(operationAssignmentAssetDocumentData.getVehicleOwnershipNumber())
          .vehicleOwnershipOnBehalfOf(operationAssignmentAssetDocumentData.getVehicleOwnershipOnBehalfOf())
          .vehicleOwnershipChassisNumber(operationAssignmentAssetDocumentData.getVehicleOwnershipChassisNumber())
          .vehicleOwnershipMachineNumber(operationAssignmentAssetDocumentData.getVehicleOwnershipMachineNumber())
          .vehicleRegistrationNumber(operationAssignmentAssetDocumentData.getVehicleRegistrationNumber())
          .vehicleRegistrationExpiredDate(operationAssignmentAssetDocumentData.getVehicleRegistrationExpiredDate())
          .vehicleRegistrationColor(operationAssignmentAssetDocumentData.getVehicleRegistrationColor())
          .vehicleRegistrationChassisNumber(operationAssignmentAssetDocumentData.getVehicleRegistrationChassisNumber())
          .vehicleRegistrationMachineNumber(operationAssignmentAssetDocumentData.getVehicleRegistrationMachineNumber())
          .taxNoticeNumber(operationAssignmentAssetDocumentData.getTaxNoticeNumber())
          .taxNoticeExpiredDate(operationAssignmentAssetDocumentData.getTaxNoticeExpiredDate())
          .taxNoticeColor(operationAssignmentAssetDocumentData.getTaxNoticeColor())
          .taxNoticeChassisNumber(operationAssignmentAssetDocumentData.getTaxNoticeChassisNumber())
          .taxNoticeMachineNumber(operationAssignmentAssetDocumentData.getTaxNoticeMachineNumber())
          .build()
      );
    });

    return result;
  }

  @Override
  public OperationAssignmentAssetDocumentDataResponse findById(Long id) {
    OperationAssignmentAssetDocumentData operationAssignmentAssetDocumentData = operationalAssignmentAssetDocumentDataRepository
      .findByIdAndActiveIsTrue(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return OperationAssignmentAssetDocumentDataResponse
      .builder()
      .assignmentAssetDocumentDataId(operationAssignmentAssetDocumentData.getId())
      .assignmentId(operationAssignmentAssetDocumentData.getAssignment().getId())
      .vehicleOwnershipCompleted(operationAssignmentAssetDocumentData.isVehicleOwnershipCompleted())
      .vehicleRegistrationCompleted(operationAssignmentAssetDocumentData.isVehicleRegistrationCompleted())
      .taxNoticeCompleted(operationAssignmentAssetDocumentData.isTaxNoticeCompleted())
      .assetCodeBrand(operationAssignmentAssetDocumentData.getAssetCodeBrand())
      .assetBrandName(operationAssignmentAssetDocumentData.getAssetBrandName())
      .assetCodeModel(operationAssignmentAssetDocumentData.getAssetCodeModel())
      .assetModelName(operationAssignmentAssetDocumentData.getAssetModelName())
      .assetCodeVariant(operationAssignmentAssetDocumentData.getAssetCodeVariant())
      .assetVariantName(operationAssignmentAssetDocumentData.getAssetVariantName())
      .assetYearMade(operationAssignmentAssetDocumentData.getAssetYearMade())
      .licenseNumber(operationAssignmentAssetDocumentData.getLicenseNumber())
      .vehicleOwnershipNumber(operationAssignmentAssetDocumentData.getVehicleOwnershipNumber())
      .vehicleOwnershipOnBehalfOf(operationAssignmentAssetDocumentData.getVehicleOwnershipOnBehalfOf())
      .vehicleOwnershipChassisNumber(operationAssignmentAssetDocumentData.getVehicleOwnershipChassisNumber())
      .vehicleOwnershipMachineNumber(operationAssignmentAssetDocumentData.getVehicleOwnershipMachineNumber())
      .vehicleRegistrationNumber(operationAssignmentAssetDocumentData.getVehicleRegistrationNumber())
      .vehicleRegistrationExpiredDate(operationAssignmentAssetDocumentData.getVehicleRegistrationExpiredDate())
      .vehicleRegistrationColor(operationAssignmentAssetDocumentData.getVehicleRegistrationColor())
      .vehicleRegistrationChassisNumber(operationAssignmentAssetDocumentData.getVehicleRegistrationChassisNumber())
      .vehicleRegistrationMachineNumber(operationAssignmentAssetDocumentData.getVehicleRegistrationMachineNumber())
      .taxNoticeNumber(operationAssignmentAssetDocumentData.getTaxNoticeNumber())
      .taxNoticeExpiredDate(operationAssignmentAssetDocumentData.getTaxNoticeExpiredDate())
      .taxNoticeColor(operationAssignmentAssetDocumentData.getTaxNoticeColor())
      .taxNoticeChassisNumber(operationAssignmentAssetDocumentData.getTaxNoticeChassisNumber())
      .taxNoticeMachineNumber(operationAssignmentAssetDocumentData.getTaxNoticeMachineNumber())
      .build();
  }

  @Override
  public OperationAssignmentAssetDocumentDataResponse findByAssignmentId(Long assignmentId) {
    OperationAssignmentAssetDocumentData operationAssignmentAssetDocumentData = operationalAssignmentAssetDocumentDataRepository
      .findByAssignmentIdAndActiveIsTrue(assignmentId)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return OperationAssignmentAssetDocumentDataResponse
      .builder()
      .assignmentAssetDocumentDataId(operationAssignmentAssetDocumentData.getId())
      .assignmentId(operationAssignmentAssetDocumentData.getAssignment().getId())
      .vehicleOwnershipCompleted(operationAssignmentAssetDocumentData.isVehicleOwnershipCompleted())
      .vehicleRegistrationCompleted(operationAssignmentAssetDocumentData.isVehicleRegistrationCompleted())
      .taxNoticeCompleted(operationAssignmentAssetDocumentData.isTaxNoticeCompleted())
      .assetCodeBrand(operationAssignmentAssetDocumentData.getAssetCodeBrand())
      .assetBrandName(operationAssignmentAssetDocumentData.getAssetBrandName())
      .assetCodeModel(operationAssignmentAssetDocumentData.getAssetCodeModel())
      .assetModelName(operationAssignmentAssetDocumentData.getAssetModelName())
      .assetCodeVariant(operationAssignmentAssetDocumentData.getAssetCodeVariant())
      .assetVariantName(operationAssignmentAssetDocumentData.getAssetVariantName())
      .assetYearMade(operationAssignmentAssetDocumentData.getAssetYearMade())
      .licenseNumber(operationAssignmentAssetDocumentData.getLicenseNumber())
      .vehicleOwnershipNumber(operationAssignmentAssetDocumentData.getVehicleOwnershipNumber())
      .vehicleOwnershipOnBehalfOf(operationAssignmentAssetDocumentData.getVehicleOwnershipOnBehalfOf())
      .vehicleOwnershipChassisNumber(operationAssignmentAssetDocumentData.getVehicleOwnershipChassisNumber())
      .vehicleOwnershipMachineNumber(operationAssignmentAssetDocumentData.getVehicleOwnershipMachineNumber())
      .vehicleRegistrationNumber(operationAssignmentAssetDocumentData.getVehicleRegistrationNumber())
      .vehicleRegistrationExpiredDate(operationAssignmentAssetDocumentData.getVehicleRegistrationExpiredDate())
      .vehicleRegistrationColor(operationAssignmentAssetDocumentData.getVehicleRegistrationColor())
      .vehicleRegistrationChassisNumber(operationAssignmentAssetDocumentData.getVehicleRegistrationChassisNumber())
      .vehicleRegistrationMachineNumber(operationAssignmentAssetDocumentData.getVehicleRegistrationMachineNumber())
      .taxNoticeNumber(operationAssignmentAssetDocumentData.getTaxNoticeNumber())
      .taxNoticeExpiredDate(operationAssignmentAssetDocumentData.getTaxNoticeExpiredDate())
      .taxNoticeColor(operationAssignmentAssetDocumentData.getTaxNoticeColor())
      .taxNoticeChassisNumber(operationAssignmentAssetDocumentData.getTaxNoticeChassisNumber())
      .taxNoticeMachineNumber(operationAssignmentAssetDocumentData.getTaxNoticeMachineNumber())
      .build();
  }
}

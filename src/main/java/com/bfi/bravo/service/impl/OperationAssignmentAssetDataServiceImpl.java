package com.bfi.bravo.service.impl;

import com.bfi.bravo.dto.operation.request.OperationAssignmentAssetDataCreateRequest;
import com.bfi.bravo.dto.operation.request.OperationAssignmentAssetDataUpdateRequest;
import com.bfi.bravo.dto.operation.response.OperationAssignmentAssetDataCreateResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentAssetDataResponse;
import com.bfi.bravo.dto.operation.response.OperationAssignmentAssetDataUpdateResponse;
import com.bfi.bravo.entity.OperationAssignment;
import com.bfi.bravo.entity.OperationAssignmentAssetData;
import com.bfi.bravo.repository.OperationAssignmentAssetDataRepository;
import com.bfi.bravo.repository.OperationAssignmentRepository;
import com.bfi.bravo.service.OperationAssignmentAssetDataService;
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
public class OperationAssignmentAssetDataServiceImpl implements OperationAssignmentAssetDataService {

  @Autowired
  private OperationAssignmentAssetDataRepository operationalAssignmentAssetDataRepository;

  @Autowired
  private OperationAssignmentRepository operationalAssignmentRepository;

  @Override
  public OperationAssignmentAssetDataCreateResponse create(
    OperationAssignmentAssetDataCreateRequest request
  ) {
    OperationAssignment operationalAssignment = operationalAssignmentRepository
      .findByIdAndActiveIsTrue(request.getAssignmentId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    OperationAssignmentAssetData operationalAssignmentAssetData = operationalAssignmentAssetDataRepository.save(
      OperationAssignmentAssetData.builder().assignment(operationalAssignment).build()
    );

    return OperationAssignmentAssetDataCreateResponse
      .builder()
      .assignmentAssetDataId(operationalAssignmentAssetData.getId())
      .build();
  }

  @Override
  public OperationAssignmentAssetDataUpdateResponse update(
    OperationAssignmentAssetDataUpdateRequest request
  ) {
    OperationAssignmentAssetData operationAssignmentAssetData = operationalAssignmentAssetDataRepository
      .findByIdAndActiveIsTrue(request.getAssetDataId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    operationAssignmentAssetData.setAssetBrandChecked(request.getAssetBrandChecked());
    operationAssignmentAssetData.setAssetModelChecked(request.getAssetModelChecked());
    operationAssignmentAssetData.setAssetVariantChecked(request.getAssetVariantChecked());
    operationAssignmentAssetData.setAssetYearMadeChecked(request.getAssetYearMadeChecked());
    operationAssignmentAssetData.setLicenseNumberChecked(request.getLicenseNumberChecked());
    operationAssignmentAssetData.setNokaNosinChecked(request.getNokaNosinChecked());
    operationAssignmentAssetData.setColorChecked(request.getColorChecked());
    operationAssignmentAssetData.setTaxNoticeChecked(request.getTaxNoticeChecked());
    operationalAssignmentAssetDataRepository.save(operationAssignmentAssetData);

    return OperationAssignmentAssetDataUpdateResponse
      .builder()
      .assignmentAssetDataId(operationAssignmentAssetData.getId())
      .assignmentId(operationAssignmentAssetData.getAssignment().getId())
      .build();
  }

  @Override
  public List<OperationAssignmentAssetDataResponse> findAll() {
    List<OperationAssignmentAssetData> operationAssignmentAssetDatas = Streamable
      .of(operationalAssignmentAssetDataRepository.findAllByActiveIsTrue())
      .toList();

    List<OperationAssignmentAssetDataResponse> result = new ArrayList<>();
    operationAssignmentAssetDatas.forEach(operationAssignmentAssetData -> {
      result.add(
        OperationAssignmentAssetDataResponse
          .builder()
          .assignmentAssetDataId(operationAssignmentAssetData.getId())
          .assignmentId(operationAssignmentAssetData.getAssignment().getId())
          .assetBrandChecked(operationAssignmentAssetData.isAssetBrandChecked())
          .assetModelChecked(operationAssignmentAssetData.isAssetModelChecked())
          .assetVariantChecked(operationAssignmentAssetData.isAssetVariantChecked())
          .assetYearMadeChecked(operationAssignmentAssetData.isAssetYearMadeChecked())
          .licenseNumberChecked(operationAssignmentAssetData.isLicenseNumberChecked())
          .nokaNosinChecked(operationAssignmentAssetData.isNokaNosinChecked())
          .colorChecked(operationAssignmentAssetData.isColorChecked())
          .taxNoticeChecked(operationAssignmentAssetData.isTaxNoticeChecked())
          .build()
      );
    });

    return result;
  }

  @Override
  public OperationAssignmentAssetDataResponse findById(Long id) {
    OperationAssignmentAssetData operationAssignmentAssetData = operationalAssignmentAssetDataRepository
      .findByIdAndActiveIsTrue(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return OperationAssignmentAssetDataResponse
      .builder()
      .assignmentAssetDataId(operationAssignmentAssetData.getId())
      .assignmentId(operationAssignmentAssetData.getAssignment().getId())
      .assetBrandChecked(operationAssignmentAssetData.isAssetBrandChecked())
      .assetModelChecked(operationAssignmentAssetData.isAssetModelChecked())
      .assetVariantChecked(operationAssignmentAssetData.isAssetVariantChecked())
      .assetYearMadeChecked(operationAssignmentAssetData.isAssetYearMadeChecked())
      .licenseNumberChecked(operationAssignmentAssetData.isLicenseNumberChecked())
      .nokaNosinChecked(operationAssignmentAssetData.isNokaNosinChecked())
      .colorChecked(operationAssignmentAssetData.isColorChecked())
      .taxNoticeChecked(operationAssignmentAssetData.isTaxNoticeChecked())
      .build();
  }

  @Override
  public OperationAssignmentAssetDataResponse findByAssignmentId(Long assignmentId) {
    OperationAssignmentAssetData operationAssignmentAssetData = operationalAssignmentAssetDataRepository
      .findByAssignmentIdAndActiveIsTrue(assignmentId)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return OperationAssignmentAssetDataResponse
      .builder()
      .assignmentAssetDataId(operationAssignmentAssetData.getId())
      .assignmentId(operationAssignmentAssetData.getAssignment().getId())
      .assetBrandChecked(operationAssignmentAssetData.isAssetBrandChecked())
      .assetModelChecked(operationAssignmentAssetData.isAssetModelChecked())
      .assetVariantChecked(operationAssignmentAssetData.isAssetVariantChecked())
      .assetYearMadeChecked(operationAssignmentAssetData.isAssetYearMadeChecked())
      .licenseNumberChecked(operationAssignmentAssetData.isLicenseNumberChecked())
      .nokaNosinChecked(operationAssignmentAssetData.isNokaNosinChecked())
      .colorChecked(operationAssignmentAssetData.isColorChecked())
      .taxNoticeChecked(operationAssignmentAssetData.isTaxNoticeChecked())
      .build();
  }
}

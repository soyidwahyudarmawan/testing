package com.bfi.bravo.service.impl;

import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentPersonalDataCreateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentPersonalDataUpdateRequest;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentPersonalDataCreateResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentPersonalDataResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentPersonalDataUpdateResponse;
import com.bfi.bravo.entity.SurveyorAssignment;
import com.bfi.bravo.entity.SurveyorAssignmentPersonalData;
import com.bfi.bravo.repository.SurveyorAssignmentPersonalDataRepository;
import com.bfi.bravo.repository.SurveyorAssignmentRepository;
import com.bfi.bravo.service.SurveyorAssignmentPersonalDataService;
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
public class SurveyorAssignmentPersonalDataServiceImpl implements SurveyorAssignmentPersonalDataService {

  @Autowired
  private SurveyorAssignmentPersonalDataRepository surveyorAssignmentPersonalDataRepository;

  @Autowired
  private SurveyorAssignmentRepository surveyorAssignmentRepository;

  @Override
  public SurveyorAssignmentPersonalDataCreateResponse create(SurveyorAssignmentPersonalDataCreateRequest request) {
    SurveyorAssignment surveyorAssignment = surveyorAssignmentRepository
      .findByIdAndActiveIsTrue(request.getAssignmentId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    SurveyorAssignmentPersonalData surveyorAssignmentPersonalData = surveyorAssignmentPersonalDataRepository.save(
      SurveyorAssignmentPersonalData.builder().assignment(surveyorAssignment).build()
    );

    return SurveyorAssignmentPersonalDataCreateResponse
      .builder()
      .assignmentPersonalDataId(surveyorAssignmentPersonalData.getId())
      .build();
  }

  @Override
  public SurveyorAssignmentPersonalDataUpdateResponse update(SurveyorAssignmentPersonalDataUpdateRequest request) {
    SurveyorAssignmentPersonalData surveyorAssignmentPersonalData = surveyorAssignmentPersonalDataRepository
      .findByIdAndActiveIsTrue(request.getAssignmentPersonalDataId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    surveyorAssignmentPersonalData.setCustomerName(request.getCustomerName());
    surveyorAssignmentPersonalData.setCustomerDomicileAddress(request.getCustomerDomicileAddress());
    surveyorAssignmentPersonalData.setCustomerDomicileAdditionalAddress(request.getCustomerDomicileAdditionalAddress());
    surveyorAssignmentPersonalData.setCustomerDomicileProvinceCode(request.getCustomerDomicileProvinceCode());
    surveyorAssignmentPersonalData.setCustomerDomicileProvinceName(request.getCustomerDomicileProvinceName());
    surveyorAssignmentPersonalData.setCustomerDomicileCityCode(request.getCustomerDomicileCityCode());
    surveyorAssignmentPersonalData.setCustomerDomicileCityName(request.getCustomerDomicileCityName());
    surveyorAssignmentPersonalData.setCustomerDomicileDistrictCode(request.getCustomerDomicileDistrictCode());
    surveyorAssignmentPersonalData.setCustomerDomicileDistrictName(request.getCustomerDomicileDistrictName());
    surveyorAssignmentPersonalData.setCustomerDomicileSubdistrictCode(request.getCustomerDomicileSubdistrictCode());
    surveyorAssignmentPersonalData.setCustomerDomicileSubdistrictName(request.getCustomerDomicileSubdistrictName());
    surveyorAssignmentPersonalData.setCustomerDomicileZipcode(request.getCustomerDomicileZipcode());
    surveyorAssignmentPersonalData.setCustomerDomicileLongitude(request.getCustomerDomicileLongitude());
    surveyorAssignmentPersonalData.setCustomerDomicileLatitude(request.getCustomerDomicileLatitude());
    surveyorAssignmentPersonalData.setSameWithDomicile(request.isSameWithDomicile());
    if (request.isSameWithDomicile()) {
      surveyorAssignmentPersonalData.setCustomerLegalProvinceCode(request.getCustomerDomicileProvinceCode());
      surveyorAssignmentPersonalData.setCustomerLegalProvinceName(request.getCustomerDomicileProvinceName());
      surveyorAssignmentPersonalData.setCustomerLegalCityCode(request.getCustomerDomicileCityCode());
      surveyorAssignmentPersonalData.setCustomerLegalCityName(request.getCustomerDomicileCityName());
      surveyorAssignmentPersonalData.setCustomerLegalDistrictCode(request.getCustomerDomicileDistrictCode());
      surveyorAssignmentPersonalData.setCustomerLegalDistrictName(request.getCustomerDomicileDistrictName());
      surveyorAssignmentPersonalData.setCustomerLegalSubdistrictCode(request.getCustomerDomicileSubdistrictCode());
      surveyorAssignmentPersonalData.setCustomerLegalSubdistrictName(request.getCustomerDomicileSubdistrictName());
      surveyorAssignmentPersonalData.setCustomerLegalZipcode(request.getCustomerDomicileZipcode());
    } else {
      surveyorAssignmentPersonalData.setCustomerLegalProvinceCode(request.getCustomerLegalProvinceCode());
      surveyorAssignmentPersonalData.setCustomerLegalProvinceName(request.getCustomerLegalProvinceName());
      surveyorAssignmentPersonalData.setCustomerLegalCityCode(request.getCustomerLegalCityCode());
      surveyorAssignmentPersonalData.setCustomerLegalCityName(request.getCustomerLegalCityName());
      surveyorAssignmentPersonalData.setCustomerLegalDistrictCode(request.getCustomerLegalDistrictCode());
      surveyorAssignmentPersonalData.setCustomerLegalDistrictName(request.getCustomerLegalDistrictName());
      surveyorAssignmentPersonalData.setCustomerLegalSubdistrictCode(request.getCustomerLegalSubdistrictCode());
      surveyorAssignmentPersonalData.setCustomerLegalSubdistrictName(request.getCustomerLegalSubdistrictName());
      surveyorAssignmentPersonalData.setCustomerLegalZipcode(request.getCustomerLegalZipcode());
    }
    surveyorAssignmentPersonalData.setCustomerPhoneNumber(request.getCustomerPhoneNumber());
    surveyorAssignmentPersonalData.setCustomerSelfiePhoto(request.getCustomerSelfiePhoto());
    surveyorAssignmentPersonalData.setCustomerIdentityCardPhoto(request.getCustomerIdentityCardPhoto());
    surveyorAssignmentPersonalData.setCustomerFamilyCardPhoto(request.getCustomerFamilyCardPhoto());
    surveyorAssignmentPersonalData.setCustomerIsMarried(request.isCustomerIsMarried());
    if (request.isCustomerIsMarried()) {
      surveyorAssignmentPersonalData.setCustomerSpouseName(request.getCustomerSpouseName());
      surveyorAssignmentPersonalData.setCustomerSpouseOccupationCode(request.getCustomerSpouseOccupationCode());
      surveyorAssignmentPersonalData.setCustomerSpouseOccupationName(request.getCustomerSpouseOccupationName());
      surveyorAssignmentPersonalData.setCustomerSpousePhoneNumber(request.getCustomerSpousePhoneNumber());
      surveyorAssignmentPersonalData.setCustomerSpouseIdentityCardPhoto(request.getCustomerSpouseIdentityCardPhoto());
    } else {
      surveyorAssignmentPersonalData.setCustomerSpouseName(null);
      surveyorAssignmentPersonalData.setCustomerSpouseOccupationCode(null);
      surveyorAssignmentPersonalData.setCustomerSpouseOccupationName(null);
      surveyorAssignmentPersonalData.setCustomerSpousePhoneNumber(null);
      surveyorAssignmentPersonalData.setCustomerSpouseIdentityCardPhoto(null);
    }
    surveyorAssignmentPersonalData.setCustomerMotherMaidenName(request.getCustomerMotherMaidenName());
    surveyorAssignmentPersonalData.setCustomerCountDependency(request.getCustomerCountDependency());
    surveyorAssignmentPersonalData.setCustomerHousePhoto(request.getCustomerHousePhoto());
    surveyorAssignmentPersonalData.setCustomerHouseTwoPhoto(request.getCustomerHouseTwoPhoto());
    surveyorAssignmentPersonalDataRepository.save(surveyorAssignmentPersonalData);

    return SurveyorAssignmentPersonalDataUpdateResponse
      .builder()
      .assignmentPersonalDataId(surveyorAssignmentPersonalData.getId())
      .assignmentId(surveyorAssignmentPersonalData.getAssignment().getId())
      .build();
  }

  @Override
  public List<SurveyorAssignmentPersonalDataResponse> findAll() {
    List<SurveyorAssignmentPersonalData> surveyorAssignmentPersonalDatas = Streamable
      .of(surveyorAssignmentPersonalDataRepository.findAllByActiveIsTrue())
      .toList();

    List<SurveyorAssignmentPersonalDataResponse> result = new ArrayList<>();
    surveyorAssignmentPersonalDatas.forEach(surveyorAssignmentPersonalData -> {
      result.add(
        SurveyorAssignmentPersonalDataResponse
          .builder()
          .assignmentPersonalDataId(surveyorAssignmentPersonalData.getId())
          .assignmentId(surveyorAssignmentPersonalData.getAssignment().getId())
          .customerName(surveyorAssignmentPersonalData.getCustomerName())
          .customerDomicileAddress(surveyorAssignmentPersonalData.getCustomerDomicileAddress())
          .customerDomicileAdditionalAddress(surveyorAssignmentPersonalData.getCustomerDomicileAdditionalAddress())
          .customerDomicileProvinceCode(surveyorAssignmentPersonalData.getCustomerDomicileProvinceCode())
          .customerDomicileProvinceName(surveyorAssignmentPersonalData.getCustomerDomicileProvinceName())
          .customerDomicileCityCode(surveyorAssignmentPersonalData.getCustomerDomicileCityCode())
          .customerDomicileCityName(surveyorAssignmentPersonalData.getCustomerDomicileCityName())
          .customerDomicileDistrictCode(surveyorAssignmentPersonalData.getCustomerDomicileDistrictCode())
          .customerDomicileDistrictName(surveyorAssignmentPersonalData.getCustomerDomicileDistrictName())
          .customerDomicileSubdistrictCode(surveyorAssignmentPersonalData.getCustomerDomicileSubdistrictCode())
          .customerDomicileSubdistrictName(surveyorAssignmentPersonalData.getCustomerDomicileSubdistrictName())
          .customerDomicileZipcode(surveyorAssignmentPersonalData.getCustomerDomicileZipcode())
          .customerDomicileLongitude(surveyorAssignmentPersonalData.getCustomerDomicileLongitude())
          .customerDomicileLatitude(surveyorAssignmentPersonalData.getCustomerDomicileLatitude())
          .sameWithDomicile(surveyorAssignmentPersonalData.isSameWithDomicile())
          .customerLegalProvinceCode(surveyorAssignmentPersonalData.getCustomerLegalProvinceCode())
          .customerLegalProvinceName(surveyorAssignmentPersonalData.getCustomerLegalProvinceName())
          .customerLegalCityCode(surveyorAssignmentPersonalData.getCustomerLegalCityCode())
          .customerLegalCityName(surveyorAssignmentPersonalData.getCustomerLegalCityName())
          .customerLegalDistrictCode(surveyorAssignmentPersonalData.getCustomerLegalDistrictCode())
          .customerLegalDistrictName(surveyorAssignmentPersonalData.getCustomerLegalDistrictName())
          .customerLegalSubdistrictCode(surveyorAssignmentPersonalData.getCustomerLegalSubdistrictCode())
          .customerLegalSubdistrictName(surveyorAssignmentPersonalData.getCustomerLegalSubdistrictName())
          .customerLegalZipcode(surveyorAssignmentPersonalData.getCustomerLegalZipcode())
          .customerPhoneNumber(surveyorAssignmentPersonalData.getCustomerPhoneNumber())
          .customerSelfiePhoto(surveyorAssignmentPersonalData.getCustomerSelfiePhoto())
          .customerIdentityCardPhoto(surveyorAssignmentPersonalData.getCustomerIdentityCardPhoto())
          .customerFamilyCardPhoto(surveyorAssignmentPersonalData.getCustomerFamilyCardPhoto())
          .customerIsMarried(surveyorAssignmentPersonalData.isCustomerIsMarried())
          .customerSpouseName(surveyorAssignmentPersonalData.getCustomerSpouseName())
          .customerSpouseOccupationCode(surveyorAssignmentPersonalData.getCustomerSpouseOccupationCode())
          .customerSpouseOccupationName(surveyorAssignmentPersonalData.getCustomerSpouseOccupationName())
          .customerSpousePhoneNumber(surveyorAssignmentPersonalData.getCustomerSpousePhoneNumber())
          .customerSpouseIdentityCardPhoto(surveyorAssignmentPersonalData.getCustomerSpouseIdentityCardPhoto())
          .customerMotherMaidenName(surveyorAssignmentPersonalData.getCustomerMotherMaidenName())
          .customerCountDependency(surveyorAssignmentPersonalData.getCustomerCountDependency())
          .customerHousePhoto(surveyorAssignmentPersonalData.getCustomerHousePhoto())
          .customerHouseTwoPhoto(surveyorAssignmentPersonalData.getCustomerHouseTwoPhoto())
          .build()
      );
    });

    return result;
  }

  @Override
  public SurveyorAssignmentPersonalDataResponse findById(Long id) {
    SurveyorAssignmentPersonalData surveyorAssignmentPersonalData = surveyorAssignmentPersonalDataRepository
      .findByIdAndActiveIsTrue(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return SurveyorAssignmentPersonalDataResponse
      .builder()
      .assignmentPersonalDataId(surveyorAssignmentPersonalData.getId())
      .assignmentId(surveyorAssignmentPersonalData.getAssignment().getId())
      .customerName(surveyorAssignmentPersonalData.getCustomerName())
      .customerDomicileAddress(surveyorAssignmentPersonalData.getCustomerDomicileAddress())
      .customerDomicileAdditionalAddress(surveyorAssignmentPersonalData.getCustomerDomicileAdditionalAddress())
      .customerDomicileProvinceCode(surveyorAssignmentPersonalData.getCustomerDomicileProvinceCode())
      .customerDomicileProvinceName(surveyorAssignmentPersonalData.getCustomerDomicileProvinceName())
      .customerDomicileCityCode(surveyorAssignmentPersonalData.getCustomerDomicileCityCode())
      .customerDomicileCityName(surveyorAssignmentPersonalData.getCustomerDomicileCityName())
      .customerDomicileDistrictCode(surveyorAssignmentPersonalData.getCustomerDomicileDistrictCode())
      .customerDomicileDistrictName(surveyorAssignmentPersonalData.getCustomerDomicileDistrictName())
      .customerDomicileSubdistrictCode(surveyorAssignmentPersonalData.getCustomerDomicileSubdistrictCode())
      .customerDomicileSubdistrictName(surveyorAssignmentPersonalData.getCustomerDomicileSubdistrictName())
      .customerDomicileZipcode(surveyorAssignmentPersonalData.getCustomerDomicileZipcode())
      .customerDomicileLongitude(surveyorAssignmentPersonalData.getCustomerDomicileLongitude())
      .customerDomicileLatitude(surveyorAssignmentPersonalData.getCustomerDomicileLatitude())
      .sameWithDomicile(surveyorAssignmentPersonalData.isSameWithDomicile())
      .customerLegalProvinceCode(surveyorAssignmentPersonalData.getCustomerLegalProvinceCode())
      .customerLegalProvinceName(surveyorAssignmentPersonalData.getCustomerLegalProvinceName())
      .customerLegalCityCode(surveyorAssignmentPersonalData.getCustomerLegalCityCode())
      .customerLegalCityName(surveyorAssignmentPersonalData.getCustomerLegalCityName())
      .customerLegalDistrictCode(surveyorAssignmentPersonalData.getCustomerLegalDistrictCode())
      .customerLegalDistrictName(surveyorAssignmentPersonalData.getCustomerLegalDistrictName())
      .customerLegalSubdistrictCode(surveyorAssignmentPersonalData.getCustomerLegalSubdistrictCode())
      .customerLegalSubdistrictName(surveyorAssignmentPersonalData.getCustomerLegalSubdistrictName())
      .customerLegalZipcode(surveyorAssignmentPersonalData.getCustomerLegalZipcode())
      .customerPhoneNumber(surveyorAssignmentPersonalData.getCustomerPhoneNumber())
      .customerSelfiePhoto(surveyorAssignmentPersonalData.getCustomerSelfiePhoto())
      .customerIdentityCardPhoto(surveyorAssignmentPersonalData.getCustomerIdentityCardPhoto())
      .customerFamilyCardPhoto(surveyorAssignmentPersonalData.getCustomerFamilyCardPhoto())
      .customerIsMarried(surveyorAssignmentPersonalData.isCustomerIsMarried())
      .customerSpouseName(surveyorAssignmentPersonalData.getCustomerSpouseName())
      .customerSpouseOccupationCode(surveyorAssignmentPersonalData.getCustomerSpouseOccupationCode())
      .customerSpouseOccupationName(surveyorAssignmentPersonalData.getCustomerSpouseOccupationName())
      .customerSpousePhoneNumber(surveyorAssignmentPersonalData.getCustomerSpousePhoneNumber())
      .customerSpouseIdentityCardPhoto(surveyorAssignmentPersonalData.getCustomerSpouseIdentityCardPhoto())
      .customerMotherMaidenName(surveyorAssignmentPersonalData.getCustomerMotherMaidenName())
      .customerCountDependency(surveyorAssignmentPersonalData.getCustomerCountDependency())
      .customerHousePhoto(surveyorAssignmentPersonalData.getCustomerHousePhoto())
      .customerHouseTwoPhoto(surveyorAssignmentPersonalData.getCustomerHouseTwoPhoto())
      .build();
  }

  @Override
  public SurveyorAssignmentPersonalDataResponse findByAssignmentId(Long assignmentId) {
    SurveyorAssignmentPersonalData surveyorAssignmentPersonalData = surveyorAssignmentPersonalDataRepository
      .findByAssignmentIdAndActiveIsTrue(assignmentId)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return SurveyorAssignmentPersonalDataResponse
      .builder()
      .assignmentPersonalDataId(surveyorAssignmentPersonalData.getId())
      .assignmentId(surveyorAssignmentPersonalData.getAssignment().getId())
      .customerName(surveyorAssignmentPersonalData.getCustomerName())
      .customerDomicileAddress(surveyorAssignmentPersonalData.getCustomerDomicileAddress())
      .customerDomicileAdditionalAddress(surveyorAssignmentPersonalData.getCustomerDomicileAdditionalAddress())
      .customerDomicileProvinceCode(surveyorAssignmentPersonalData.getCustomerDomicileProvinceCode())
      .customerDomicileProvinceName(surveyorAssignmentPersonalData.getCustomerDomicileProvinceName())
      .customerDomicileCityCode(surveyorAssignmentPersonalData.getCustomerDomicileCityCode())
      .customerDomicileCityName(surveyorAssignmentPersonalData.getCustomerDomicileCityName())
      .customerDomicileDistrictCode(surveyorAssignmentPersonalData.getCustomerDomicileDistrictCode())
      .customerDomicileDistrictName(surveyorAssignmentPersonalData.getCustomerDomicileDistrictName())
      .customerDomicileSubdistrictCode(surveyorAssignmentPersonalData.getCustomerDomicileSubdistrictCode())
      .customerDomicileSubdistrictName(surveyorAssignmentPersonalData.getCustomerDomicileSubdistrictName())
      .customerDomicileZipcode(surveyorAssignmentPersonalData.getCustomerDomicileZipcode())
      .customerDomicileLongitude(surveyorAssignmentPersonalData.getCustomerDomicileLongitude())
      .customerDomicileLatitude(surveyorAssignmentPersonalData.getCustomerDomicileLatitude())
      .sameWithDomicile(surveyorAssignmentPersonalData.isSameWithDomicile())
      .customerLegalProvinceCode(surveyorAssignmentPersonalData.getCustomerLegalProvinceCode())
      .customerLegalProvinceName(surveyorAssignmentPersonalData.getCustomerLegalProvinceName())
      .customerLegalCityCode(surveyorAssignmentPersonalData.getCustomerLegalCityCode())
      .customerLegalCityName(surveyorAssignmentPersonalData.getCustomerLegalCityName())
      .customerLegalDistrictCode(surveyorAssignmentPersonalData.getCustomerLegalDistrictCode())
      .customerLegalDistrictName(surveyorAssignmentPersonalData.getCustomerLegalDistrictName())
      .customerLegalSubdistrictCode(surveyorAssignmentPersonalData.getCustomerLegalSubdistrictCode())
      .customerLegalSubdistrictName(surveyorAssignmentPersonalData.getCustomerLegalSubdistrictName())
      .customerLegalZipcode(surveyorAssignmentPersonalData.getCustomerLegalZipcode())
      .customerPhoneNumber(surveyorAssignmentPersonalData.getCustomerPhoneNumber())
      .customerSelfiePhoto(surveyorAssignmentPersonalData.getCustomerSelfiePhoto())
      .customerIdentityCardPhoto(surveyorAssignmentPersonalData.getCustomerIdentityCardPhoto())
      .customerFamilyCardPhoto(surveyorAssignmentPersonalData.getCustomerFamilyCardPhoto())
      .customerIsMarried(surveyorAssignmentPersonalData.isCustomerIsMarried())
      .customerSpouseName(surveyorAssignmentPersonalData.getCustomerSpouseName())
      .customerSpouseOccupationCode(surveyorAssignmentPersonalData.getCustomerSpouseOccupationCode())
      .customerSpouseOccupationName(surveyorAssignmentPersonalData.getCustomerSpouseOccupationName())
      .customerSpousePhoneNumber(surveyorAssignmentPersonalData.getCustomerSpousePhoneNumber())
      .customerSpouseIdentityCardPhoto(surveyorAssignmentPersonalData.getCustomerSpouseIdentityCardPhoto())
      .customerMotherMaidenName(surveyorAssignmentPersonalData.getCustomerMotherMaidenName())
      .customerCountDependency(surveyorAssignmentPersonalData.getCustomerCountDependency())
      .customerHousePhoto(surveyorAssignmentPersonalData.getCustomerHousePhoto())
      .customerHouseTwoPhoto(surveyorAssignmentPersonalData.getCustomerHouseTwoPhoto())
      .build();
  }
}

package com.bfi.bravo.service.impl;

import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentOccupationDataCreateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentOccupationDataUpdateRequest;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentOccupationDataCreateResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentOccupationDataResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentOccupationDataUpdateResponse;
import com.bfi.bravo.entity.SurveyorAssignment;
import com.bfi.bravo.entity.SurveyorAssignmentOccupationData;
import com.bfi.bravo.repository.SurveyorAssignmentOccupationDataRepository;
import com.bfi.bravo.repository.SurveyorAssignmentRepository;
import com.bfi.bravo.service.SurveyorAssignmentOccupationDataService;
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
public class SurveyorAssignmentOccupationDataServiceImpl implements SurveyorAssignmentOccupationDataService {

  @Autowired
  private SurveyorAssignmentOccupationDataRepository surveyorAssignmentOccupationDataRepository;

  @Autowired
  private SurveyorAssignmentRepository surveyorAssignmentRepository;

  @Override
  public SurveyorAssignmentOccupationDataCreateResponse create(SurveyorAssignmentOccupationDataCreateRequest request) {
    SurveyorAssignment surveyorAssignment = surveyorAssignmentRepository
      .findByIdAndActiveIsTrue(request.getAssignmentId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    SurveyorAssignmentOccupationData surveyorAssignmentOccupationData = surveyorAssignmentOccupationDataRepository.save(
      SurveyorAssignmentOccupationData.builder().assignment(surveyorAssignment).build()
    );

    return SurveyorAssignmentOccupationDataCreateResponse
      .builder()
      .assignmentOccupationDataId(surveyorAssignmentOccupationData.getId())
      .build();
  }

  @Override
  public SurveyorAssignmentOccupationDataUpdateResponse update(SurveyorAssignmentOccupationDataUpdateRequest request) {
    SurveyorAssignmentOccupationData surveyorAssignmentOccupationData = surveyorAssignmentOccupationDataRepository
      .findByIdAndActiveIsTrue(request.getAssignmentOccupationDataId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    surveyorAssignmentOccupationData.setEconomySectorCode(request.getEconomySectorCode());
    surveyorAssignmentOccupationData.setEconomySectorName(request.getEconomySectorName());
    surveyorAssignmentOccupationData.setIndustryTypeCode(request.getIndustryTypeCode());
    surveyorAssignmentOccupationData.setIndustryTypeName(request.getIndustryTypeName());
    surveyorAssignmentOccupationData.setOccupationCode(request.getOccupationCode());
    surveyorAssignmentOccupationData.setOccupationName(request.getOccupationName());
    surveyorAssignmentOccupationData.setCompanyName(request.getCompanyName());
    surveyorAssignmentOccupationData.setProvinceCode(request.getProvinceCode());
    surveyorAssignmentOccupationData.setProvinceName(request.getProvinceName());
    surveyorAssignmentOccupationData.setCityCode(request.getCityCode());
    surveyorAssignmentOccupationData.setCityName(request.getCityName());
    surveyorAssignmentOccupationData.setDistrictCode(request.getDistrictCode());
    surveyorAssignmentOccupationData.setDistrictName(request.getDistrictName());
    surveyorAssignmentOccupationData.setSubdistrictCode(request.getSubdistrictCode());
    surveyorAssignmentOccupationData.setSubdistrictName(request.getSubdistrictName());
    surveyorAssignmentOccupationData.setZipcode(request.getZipcode());
    surveyorAssignmentOccupationData.setPhoneNumber(request.getPhoneNumber());
    surveyorAssignmentOccupationDataRepository.save(surveyorAssignmentOccupationData);

    return SurveyorAssignmentOccupationDataUpdateResponse
      .builder()
      .assignmentOccupationDataId(surveyorAssignmentOccupationData.getId())
      .assignmentId(surveyorAssignmentOccupationData.getAssignment().getId())
      .build();
  }

  @Override
  public List<SurveyorAssignmentOccupationDataResponse> findAll() {
    List<SurveyorAssignmentOccupationData> surveyorAssignmentOccupationDatas = Streamable
      .of(surveyorAssignmentOccupationDataRepository.findAllByActiveIsTrue())
      .toList();

    List<SurveyorAssignmentOccupationDataResponse> result = new ArrayList<>();
    surveyorAssignmentOccupationDatas.forEach(surveyorAssignmentOccupationData -> {
      result.add(
        SurveyorAssignmentOccupationDataResponse
          .builder()
          .assignmentOccupationDataId(surveyorAssignmentOccupationData.getId())
          .assignmentId(surveyorAssignmentOccupationData.getAssignment().getId())
          .economySectorCode(surveyorAssignmentOccupationData.getEconomySectorCode())
          .economySectorName(surveyorAssignmentOccupationData.getEconomySectorName())
          .industryTypeCode(surveyorAssignmentOccupationData.getIndustryTypeCode())
          .industryTypeName(surveyorAssignmentOccupationData.getIndustryTypeName())
          .occupationCode(surveyorAssignmentOccupationData.getOccupationCode())
          .occupationName(surveyorAssignmentOccupationData.getOccupationName())
          .companyName(surveyorAssignmentOccupationData.getCompanyName())
          .provinceCode(surveyorAssignmentOccupationData.getProvinceCode())
          .provinceName(surveyorAssignmentOccupationData.getProvinceName())
          .cityCode(surveyorAssignmentOccupationData.getCityCode())
          .cityName(surveyorAssignmentOccupationData.getCityName())
          .districtCode(surveyorAssignmentOccupationData.getDistrictCode())
          .districtName(surveyorAssignmentOccupationData.getDistrictName())
          .subdistrictCode(surveyorAssignmentOccupationData.getSubdistrictCode())
          .subdistrictName(surveyorAssignmentOccupationData.getSubdistrictName())
          .zipcode(surveyorAssignmentOccupationData.getZipcode())
          .phoneNumber(surveyorAssignmentOccupationData.getPhoneNumber())
          .build()
      );
    });

    return result;
  }

  @Override
  public SurveyorAssignmentOccupationDataResponse findById(Long id) {
    SurveyorAssignmentOccupationData surveyorAssignmentOccupationData = surveyorAssignmentOccupationDataRepository
      .findByIdAndActiveIsTrue(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return SurveyorAssignmentOccupationDataResponse
      .builder()
      .assignmentOccupationDataId(surveyorAssignmentOccupationData.getId())
      .assignmentId(surveyorAssignmentOccupationData.getAssignment().getId())
      .economySectorCode(surveyorAssignmentOccupationData.getEconomySectorCode())
      .economySectorName(surveyorAssignmentOccupationData.getEconomySectorName())
      .industryTypeCode(surveyorAssignmentOccupationData.getIndustryTypeCode())
      .industryTypeName(surveyorAssignmentOccupationData.getIndustryTypeName())
      .occupationCode(surveyorAssignmentOccupationData.getOccupationCode())
      .occupationName(surveyorAssignmentOccupationData.getOccupationName())
      .companyName(surveyorAssignmentOccupationData.getCompanyName())
      .provinceCode(surveyorAssignmentOccupationData.getProvinceCode())
      .provinceName(surveyorAssignmentOccupationData.getProvinceName())
      .cityCode(surveyorAssignmentOccupationData.getCityCode())
      .cityName(surveyorAssignmentOccupationData.getCityName())
      .districtCode(surveyorAssignmentOccupationData.getDistrictCode())
      .districtName(surveyorAssignmentOccupationData.getDistrictName())
      .subdistrictCode(surveyorAssignmentOccupationData.getSubdistrictCode())
      .subdistrictName(surveyorAssignmentOccupationData.getSubdistrictName())
      .zipcode(surveyorAssignmentOccupationData.getZipcode())
      .phoneNumber(surveyorAssignmentOccupationData.getPhoneNumber())
      .build();
  }

  @Override
  public SurveyorAssignmentOccupationDataResponse findByAssignmentId(Long assignmentId) {
    SurveyorAssignmentOccupationData surveyorAssignmentOccupationData = surveyorAssignmentOccupationDataRepository
      .findByAssignmentIdAndActiveIsTrue(assignmentId)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return SurveyorAssignmentOccupationDataResponse
      .builder()
      .assignmentOccupationDataId(surveyorAssignmentOccupationData.getId())
      .assignmentId(surveyorAssignmentOccupationData.getAssignment().getId())
      .economySectorCode(surveyorAssignmentOccupationData.getEconomySectorCode())
      .economySectorName(surveyorAssignmentOccupationData.getEconomySectorName())
      .industryTypeCode(surveyorAssignmentOccupationData.getIndustryTypeCode())
      .industryTypeName(surveyorAssignmentOccupationData.getIndustryTypeName())
      .occupationCode(surveyorAssignmentOccupationData.getOccupationCode())
      .occupationName(surveyorAssignmentOccupationData.getOccupationName())
      .companyName(surveyorAssignmentOccupationData.getCompanyName())
      .provinceCode(surveyorAssignmentOccupationData.getProvinceCode())
      .provinceName(surveyorAssignmentOccupationData.getProvinceName())
      .cityCode(surveyorAssignmentOccupationData.getCityCode())
      .cityName(surveyorAssignmentOccupationData.getCityName())
      .districtCode(surveyorAssignmentOccupationData.getDistrictCode())
      .districtName(surveyorAssignmentOccupationData.getDistrictName())
      .subdistrictCode(surveyorAssignmentOccupationData.getSubdistrictCode())
      .subdistrictName(surveyorAssignmentOccupationData.getSubdistrictName())
      .zipcode(surveyorAssignmentOccupationData.getZipcode())
      .phoneNumber(surveyorAssignmentOccupationData.getPhoneNumber())
      .build();
  }
}

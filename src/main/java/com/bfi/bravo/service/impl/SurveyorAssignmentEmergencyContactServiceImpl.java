package com.bfi.bravo.service.impl;

import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentEmergencyContactCreateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentEmergencyContactUpdateRequest;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentEmergencyContactCreateResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentEmergencyContactResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentEmergencyContactUpdateResponse;
import com.bfi.bravo.entity.SurveyorAssignment;
import com.bfi.bravo.entity.SurveyorAssignmentEmergencyContact;
import com.bfi.bravo.repository.SurveyorAssignmentEmergencyContactRepository;
import com.bfi.bravo.repository.SurveyorAssignmentRepository;
import com.bfi.bravo.service.SurveyorAssignmentEmergencyContactService;
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
public class SurveyorAssignmentEmergencyContactServiceImpl implements SurveyorAssignmentEmergencyContactService {

  @Autowired
  private SurveyorAssignmentEmergencyContactRepository surveyorAssignmentEmergencyContactRepository;

  @Autowired
  private SurveyorAssignmentRepository surveyorAssignmentRepository;

  @Override
  public SurveyorAssignmentEmergencyContactCreateResponse create(
    SurveyorAssignmentEmergencyContactCreateRequest request
  ) {
    SurveyorAssignment surveyorAssignment = surveyorAssignmentRepository
      .findByIdAndActiveIsTrue(request.getAssignmentId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    SurveyorAssignmentEmergencyContact surveyorAssignmentEmergencyContact = surveyorAssignmentEmergencyContactRepository.save(
      SurveyorAssignmentEmergencyContact.builder().assignment(surveyorAssignment).build()
    );

    return SurveyorAssignmentEmergencyContactCreateResponse
      .builder()
      .assignmentEmergencyContactId(surveyorAssignmentEmergencyContact.getId())
      .build();
  }

  @Override
  public SurveyorAssignmentEmergencyContactUpdateResponse update(
    SurveyorAssignmentEmergencyContactUpdateRequest request
  ) {
    SurveyorAssignmentEmergencyContact surveyorAssignmentEmergencyContact = surveyorAssignmentEmergencyContactRepository
      .findByIdAndActiveIsTrue(request.getAssignmentEmergencyContactId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    surveyorAssignmentEmergencyContact.setCustomerRelationship(request.getCustomerRelationship());
    surveyorAssignmentEmergencyContact.setName(request.getName());
    surveyorAssignmentEmergencyContact.setAddress(request.getAddress());
    surveyorAssignmentEmergencyContact.setProvinceCode(request.getProvinceCode());
    surveyorAssignmentEmergencyContact.setProvinceName(request.getProvinceName());
    surveyorAssignmentEmergencyContact.setCityCode(request.getCityCode());
    surveyorAssignmentEmergencyContact.setCityName(request.getCityName());
    surveyorAssignmentEmergencyContact.setDistrictCode(request.getDistrictCode());
    surveyorAssignmentEmergencyContact.setDistrictName(request.getDistrictName());
    surveyorAssignmentEmergencyContact.setSubdistrictCode(request.getSubdistrictCode());
    surveyorAssignmentEmergencyContact.setSubdistrictName(request.getSubdistrictName());
    surveyorAssignmentEmergencyContact.setZipcode(request.getZipcode());
    surveyorAssignmentEmergencyContact.setPhoneNumber(request.getPhoneNumber());
    surveyorAssignmentEmergencyContactRepository.save(surveyorAssignmentEmergencyContact);

    return SurveyorAssignmentEmergencyContactUpdateResponse
      .builder()
      .assignmentEmergencyContactId(surveyorAssignmentEmergencyContact.getId())
      .assignmentId(surveyorAssignmentEmergencyContact.getAssignment().getId())
      .build();
  }

  @Override
  public List<SurveyorAssignmentEmergencyContactResponse> findAll() {
    List<SurveyorAssignmentEmergencyContact> surveyorAssignmentEmergencyContacts = Streamable
      .of(surveyorAssignmentEmergencyContactRepository.findAllByActiveIsTrue())
      .toList();

    List<SurveyorAssignmentEmergencyContactResponse> result = new ArrayList<>();
    surveyorAssignmentEmergencyContacts.forEach(surveyorAssignmentEmergencyContact -> {
      result.add(
        SurveyorAssignmentEmergencyContactResponse
          .builder()
          .assignmentEmergencyContactId(surveyorAssignmentEmergencyContact.getId())
          .assignmentId(surveyorAssignmentEmergencyContact.getAssignment().getId())
          .customerRelationship(surveyorAssignmentEmergencyContact.getCustomerRelationship())
          .name(surveyorAssignmentEmergencyContact.getName())
          .address(surveyorAssignmentEmergencyContact.getAddress())
          .provinceCode(surveyorAssignmentEmergencyContact.getProvinceCode())
          .provinceName(surveyorAssignmentEmergencyContact.getProvinceName())
          .cityCode(surveyorAssignmentEmergencyContact.getCityCode())
          .cityName(surveyorAssignmentEmergencyContact.getCityName())
          .districtCode(surveyorAssignmentEmergencyContact.getDistrictCode())
          .districtName(surveyorAssignmentEmergencyContact.getDistrictName())
          .subdistrictCode(surveyorAssignmentEmergencyContact.getSubdistrictCode())
          .subdistrictName(surveyorAssignmentEmergencyContact.getSubdistrictName())
          .zipcode(surveyorAssignmentEmergencyContact.getZipcode())
          .phoneNumber(surveyorAssignmentEmergencyContact.getPhoneNumber())
          .build()
      );
    });

    return result;
  }

  @Override
  public SurveyorAssignmentEmergencyContactResponse findById(Long id) {
    SurveyorAssignmentEmergencyContact surveyorAssignmentEmergencyContact = surveyorAssignmentEmergencyContactRepository
      .findByIdAndActiveIsTrue(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return SurveyorAssignmentEmergencyContactResponse
      .builder()
      .assignmentEmergencyContactId(surveyorAssignmentEmergencyContact.getId())
      .assignmentId(surveyorAssignmentEmergencyContact.getAssignment().getId())
      .customerRelationship(surveyorAssignmentEmergencyContact.getCustomerRelationship())
      .name(surveyorAssignmentEmergencyContact.getName())
      .address(surveyorAssignmentEmergencyContact.getAddress())
      .provinceCode(surveyorAssignmentEmergencyContact.getProvinceCode())
      .provinceName(surveyorAssignmentEmergencyContact.getProvinceName())
      .cityCode(surveyorAssignmentEmergencyContact.getCityCode())
      .cityName(surveyorAssignmentEmergencyContact.getCityName())
      .districtCode(surveyorAssignmentEmergencyContact.getDistrictCode())
      .districtName(surveyorAssignmentEmergencyContact.getDistrictName())
      .subdistrictCode(surveyorAssignmentEmergencyContact.getSubdistrictCode())
      .subdistrictName(surveyorAssignmentEmergencyContact.getSubdistrictName())
      .zipcode(surveyorAssignmentEmergencyContact.getZipcode())
      .phoneNumber(surveyorAssignmentEmergencyContact.getPhoneNumber())
      .build();
  }

  @Override
  public SurveyorAssignmentEmergencyContactResponse findByAssignmentId(Long assignmentId) {
    SurveyorAssignmentEmergencyContact surveyorAssignmentEmergencyContact = surveyorAssignmentEmergencyContactRepository
      .findByAssignmentIdAndActiveIsTrue(assignmentId)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return SurveyorAssignmentEmergencyContactResponse
      .builder()
      .assignmentEmergencyContactId(surveyorAssignmentEmergencyContact.getId())
      .assignmentId(surveyorAssignmentEmergencyContact.getAssignment().getId())
      .customerRelationship(surveyorAssignmentEmergencyContact.getCustomerRelationship())
      .name(surveyorAssignmentEmergencyContact.getName())
      .address(surveyorAssignmentEmergencyContact.getAddress())
      .provinceCode(surveyorAssignmentEmergencyContact.getProvinceCode())
      .provinceName(surveyorAssignmentEmergencyContact.getProvinceName())
      .cityCode(surveyorAssignmentEmergencyContact.getCityCode())
      .cityName(surveyorAssignmentEmergencyContact.getCityName())
      .districtCode(surveyorAssignmentEmergencyContact.getDistrictCode())
      .districtName(surveyorAssignmentEmergencyContact.getDistrictName())
      .subdistrictCode(surveyorAssignmentEmergencyContact.getSubdistrictCode())
      .subdistrictName(surveyorAssignmentEmergencyContact.getSubdistrictName())
      .zipcode(surveyorAssignmentEmergencyContact.getZipcode())
      .phoneNumber(surveyorAssignmentEmergencyContact.getPhoneNumber())
      .build();
  }
}

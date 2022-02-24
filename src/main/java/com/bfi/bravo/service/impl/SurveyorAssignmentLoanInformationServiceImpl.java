package com.bfi.bravo.service.impl;

import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentLoanInformationCreateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentLoanInformationUpdateRequest;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentLoanInformationCreateResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentLoanInformationResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentLoanInformationUpdateResponse;
import com.bfi.bravo.entity.SurveyorAssignment;
import com.bfi.bravo.entity.SurveyorAssignmentLoanInformation;
import com.bfi.bravo.repository.SurveyorAssignmentLoanInformationRepository;
import com.bfi.bravo.repository.SurveyorAssignmentRepository;
import com.bfi.bravo.service.SurveyorAssignmentLoanInformationService;
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
public class SurveyorAssignmentLoanInformationServiceImpl implements SurveyorAssignmentLoanInformationService {

  @Autowired
  private SurveyorAssignmentLoanInformationRepository surveyorAssignmentLoanInformationRepository;

  @Autowired
  private SurveyorAssignmentRepository surveyorAssignmentRepository;

  @Override
  public SurveyorAssignmentLoanInformationCreateResponse create(
    SurveyorAssignmentLoanInformationCreateRequest request
  ) {
    SurveyorAssignment surveyorAssignment = surveyorAssignmentRepository
      .findByIdAndActiveIsTrue(request.getAssignmentId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    SurveyorAssignmentLoanInformation surveyorAssignmentLoanInformation = surveyorAssignmentLoanInformationRepository.save(
      SurveyorAssignmentLoanInformation.builder().assignment(surveyorAssignment).build()
    );

    return SurveyorAssignmentLoanInformationCreateResponse
      .builder()
      .assignmentLoanInformationId(surveyorAssignmentLoanInformation.getId())
      .build();
  }

  @Override
  public SurveyorAssignmentLoanInformationUpdateResponse update(
    SurveyorAssignmentLoanInformationUpdateRequest request
  ) {
    SurveyorAssignmentLoanInformation surveyorAssignmentLoanInformation = surveyorAssignmentLoanInformationRepository
      .findByIdAndActiveIsTrue(request.getAssignmentLoanInformationId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    surveyorAssignmentLoanInformation.setAmount(request.getAmount());
    surveyorAssignmentLoanInformation.setTenor(request.getTenor());
    surveyorAssignmentLoanInformation.setInstallmentAmount(request.getInstallmentAmount());
    surveyorAssignmentLoanInformationRepository.save(surveyorAssignmentLoanInformation);

    return SurveyorAssignmentLoanInformationUpdateResponse
      .builder()
      .assignmentLoanInformationId(surveyorAssignmentLoanInformation.getId())
      .assignmentId(surveyorAssignmentLoanInformation.getAssignment().getId())
      .build();
  }

  @Override
  public List<SurveyorAssignmentLoanInformationResponse> findAll() {
    List<SurveyorAssignmentLoanInformation> surveyorAssignmentLoanInformations = Streamable
      .of(surveyorAssignmentLoanInformationRepository.findAllByActiveIsTrue())
      .toList();

    List<SurveyorAssignmentLoanInformationResponse> result = new ArrayList<>();
    surveyorAssignmentLoanInformations.forEach(surveyorAssignmentLoanInformation -> {
      result.add(
        SurveyorAssignmentLoanInformationResponse
          .builder()
          .assignmentLoanInformationId(surveyorAssignmentLoanInformation.getId())
          .assignmentId(surveyorAssignmentLoanInformation.getAssignment().getId())
          .amount(surveyorAssignmentLoanInformation.getAmount())
          .tenor(surveyorAssignmentLoanInformation.getTenor())
          .installmentAmount(surveyorAssignmentLoanInformation.getInstallmentAmount())
          .build()
      );
    });

    return result;
  }

  @Override
  public SurveyorAssignmentLoanInformationResponse findById(Long id) {
    SurveyorAssignmentLoanInformation surveyorAssignmentLoanInformation = surveyorAssignmentLoanInformationRepository
      .findByIdAndActiveIsTrue(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return SurveyorAssignmentLoanInformationResponse
      .builder()
      .assignmentLoanInformationId(surveyorAssignmentLoanInformation.getId())
      .assignmentId(surveyorAssignmentLoanInformation.getAssignment().getId())
      .amount(surveyorAssignmentLoanInformation.getAmount())
      .tenor(surveyorAssignmentLoanInformation.getTenor())
      .installmentAmount(surveyorAssignmentLoanInformation.getInstallmentAmount())
      .build();
  }

  @Override
  public SurveyorAssignmentLoanInformationResponse findByAssignmentId(Long assignmentId) {
    SurveyorAssignmentLoanInformation surveyorAssignmentLoanInformation = surveyorAssignmentLoanInformationRepository
      .findByAssignmentIdAndActiveIsTrue(assignmentId)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return SurveyorAssignmentLoanInformationResponse
      .builder()
      .assignmentLoanInformationId(surveyorAssignmentLoanInformation.getId())
      .assignmentId(surveyorAssignmentLoanInformation.getAssignment().getId())
      .amount(surveyorAssignmentLoanInformation.getAmount())
      .tenor(surveyorAssignmentLoanInformation.getTenor())
      .installmentAmount(surveyorAssignmentLoanInformation.getInstallmentAmount())
      .build();
  }
}

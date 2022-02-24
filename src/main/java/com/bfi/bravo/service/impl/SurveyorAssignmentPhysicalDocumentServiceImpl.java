package com.bfi.bravo.service.impl;

import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentPhysicalDocumentCreateRequest;
import com.bfi.bravo.dto.surveyor.request.SurveyorAssignmentPhysicalDocumentUpdateRequest;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentPhysicalDocumentCreateResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentPhysicalDocumentResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentPhysicalDocumentUpdateResponse;
import com.bfi.bravo.entity.SurveyorAssignment;
import com.bfi.bravo.entity.SurveyorAssignmentPhysicalDocument;
import com.bfi.bravo.repository.SurveyorAssignmentPhysicalDocumentRepository;
import com.bfi.bravo.repository.SurveyorAssignmentRepository;
import com.bfi.bravo.service.SurveyorAssignmentPhysicalDocumentService;
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
public class SurveyorAssignmentPhysicalDocumentServiceImpl implements SurveyorAssignmentPhysicalDocumentService {

  @Autowired
  private SurveyorAssignmentPhysicalDocumentRepository surveyorAssignmentPhysicalDocumentRepository;

  @Autowired
  private SurveyorAssignmentRepository surveyorAssignmentRepository;

  @Override
  public SurveyorAssignmentPhysicalDocumentCreateResponse create(
    SurveyorAssignmentPhysicalDocumentCreateRequest request
  ) {
    SurveyorAssignment surveyorAssignment = surveyorAssignmentRepository
      .findByIdAndActiveIsTrue(request.getAssignmentId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    SurveyorAssignmentPhysicalDocument surveyorAssignmentPhysicalDocument = surveyorAssignmentPhysicalDocumentRepository.save(
      SurveyorAssignmentPhysicalDocument.builder().assignment(surveyorAssignment).build()
    );

    return SurveyorAssignmentPhysicalDocumentCreateResponse
      .builder()
      .assignmentPhysicalDocumentId(surveyorAssignmentPhysicalDocument.getId())
      .build();
  }

  @Override
  public SurveyorAssignmentPhysicalDocumentUpdateResponse update(
    SurveyorAssignmentPhysicalDocumentUpdateRequest request
  ) {
    SurveyorAssignmentPhysicalDocument surveyorAssignmentPhysicalDocument = surveyorAssignmentPhysicalDocumentRepository
      .findByIdAndActiveIsTrue(request.getAssignmentPhysicalDocumentId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    surveyorAssignmentPhysicalDocument.setVehicleOwnerPhotoOne(request.getVehicleOwnerPhotoOne());
    surveyorAssignmentPhysicalDocument.setVehicleOwnerPhotoTwo(request.getVehicleOwnerPhotoTwo());
    surveyorAssignmentPhysicalDocument.setVehicleOwnerPhotoThree(request.getVehicleOwnerPhotoThree());
    surveyorAssignmentPhysicalDocument.setVehicleOwnerPhotoFour(request.getVehicleOwnerPhotoFour());
    surveyorAssignmentPhysicalDocument.setVehicleOwnershipIdentityCardPhoto(
      request.getVehicleOwnershipIdentityCardPhoto()
    );
    surveyorAssignmentPhysicalDocument.setAdditionalAssetRegistrationPhoto(
      request.getAdditionalAssetRegistrationPhoto()
    );
    surveyorAssignmentPhysicalDocumentRepository.save(surveyorAssignmentPhysicalDocument);

    return SurveyorAssignmentPhysicalDocumentUpdateResponse
      .builder()
      .assignmentPhysicalDocumentId(surveyorAssignmentPhysicalDocument.getId())
      .assignmentId(surveyorAssignmentPhysicalDocument.getAssignment().getId())
      .build();
  }

  @Override
  public List<SurveyorAssignmentPhysicalDocumentResponse> findAll() {
    List<SurveyorAssignmentPhysicalDocument> surveyorAssignmentPhysicalDocuments = Streamable
      .of(surveyorAssignmentPhysicalDocumentRepository.findAllByActiveIsTrue())
      .toList();

    List<SurveyorAssignmentPhysicalDocumentResponse> result = new ArrayList<>();
    surveyorAssignmentPhysicalDocuments.forEach(surveyorAssignmentPhysicalDocument -> {
      result.add(
        SurveyorAssignmentPhysicalDocumentResponse
          .builder()
          .assignmentPhysicalDocumentId(surveyorAssignmentPhysicalDocument.getId())
          .assignmentId(surveyorAssignmentPhysicalDocument.getAssignment().getId())
          .vehicleOwnerPhotoOne(surveyorAssignmentPhysicalDocument.getVehicleOwnerPhotoOne())
          .vehicleOwnerPhotoTwo(surveyorAssignmentPhysicalDocument.getVehicleOwnerPhotoTwo())
          .vehicleOwnerPhotoThree(surveyorAssignmentPhysicalDocument.getVehicleOwnerPhotoThree())
          .vehicleOwnerPhotoFour(surveyorAssignmentPhysicalDocument.getVehicleOwnerPhotoFour())
          .vehicleOwnershipIdentityCardPhoto(surveyorAssignmentPhysicalDocument.getVehicleOwnershipIdentityCardPhoto())
          .additionalAssetRegistrationPhoto(surveyorAssignmentPhysicalDocument.getAdditionalAssetRegistrationPhoto())
          .build()
      );
    });

    return result;
  }

  @Override
  public SurveyorAssignmentPhysicalDocumentResponse findById(Long id) {
    SurveyorAssignmentPhysicalDocument surveyorAssignmentPhysicalDocument = surveyorAssignmentPhysicalDocumentRepository
      .findByIdAndActiveIsTrue(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return SurveyorAssignmentPhysicalDocumentResponse
      .builder()
      .assignmentPhysicalDocumentId(surveyorAssignmentPhysicalDocument.getId())
      .assignmentId(surveyorAssignmentPhysicalDocument.getAssignment().getId())
      .vehicleOwnerPhotoOne(surveyorAssignmentPhysicalDocument.getVehicleOwnerPhotoOne())
      .vehicleOwnerPhotoTwo(surveyorAssignmentPhysicalDocument.getVehicleOwnerPhotoTwo())
      .vehicleOwnerPhotoThree(surveyorAssignmentPhysicalDocument.getVehicleOwnerPhotoThree())
      .vehicleOwnerPhotoFour(surveyorAssignmentPhysicalDocument.getVehicleOwnerPhotoFour())
      .vehicleOwnershipIdentityCardPhoto(surveyorAssignmentPhysicalDocument.getVehicleOwnershipIdentityCardPhoto())
      .additionalAssetRegistrationPhoto(surveyorAssignmentPhysicalDocument.getAdditionalAssetRegistrationPhoto())
      .build();
  }

  @Override
  public SurveyorAssignmentPhysicalDocumentResponse findByAssignmentId(Long assignmentId) {
    SurveyorAssignmentPhysicalDocument surveyorAssignmentPhysicalDocument = surveyorAssignmentPhysicalDocumentRepository
      .findByAssignmentIdAndActiveIsTrue(assignmentId)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return SurveyorAssignmentPhysicalDocumentResponse
      .builder()
      .assignmentPhysicalDocumentId(surveyorAssignmentPhysicalDocument.getId())
      .assignmentId(surveyorAssignmentPhysicalDocument.getAssignment().getId())
      .vehicleOwnerPhotoOne(surveyorAssignmentPhysicalDocument.getVehicleOwnerPhotoOne())
      .vehicleOwnerPhotoTwo(surveyorAssignmentPhysicalDocument.getVehicleOwnerPhotoTwo())
      .vehicleOwnerPhotoThree(surveyorAssignmentPhysicalDocument.getVehicleOwnerPhotoThree())
      .vehicleOwnerPhotoFour(surveyorAssignmentPhysicalDocument.getVehicleOwnerPhotoFour())
      .vehicleOwnershipIdentityCardPhoto(surveyorAssignmentPhysicalDocument.getVehicleOwnershipIdentityCardPhoto())
      .additionalAssetRegistrationPhoto(surveyorAssignmentPhysicalDocument.getAdditionalAssetRegistrationPhoto())
      .build();
  }
}

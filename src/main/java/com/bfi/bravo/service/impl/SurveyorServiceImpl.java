package com.bfi.bravo.service.impl;

import com.bfi.bravo.constant.SurveyorConstants;
import com.bfi.bravo.dto.notification.response.SurveyorNotificationCountUnreadResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorAssignmentResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorSummaryResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorUploadResponse;
import com.bfi.bravo.service.SurveyorAssignmentService;
import com.bfi.bravo.service.SurveyorNotificationService;
import com.bfi.bravo.service.SurveyorService;
import com.bfi.bravo.utils.DateUtil;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.io.FileInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.IOException;
import java.util.List;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class SurveyorServiceImpl implements SurveyorService {

  @Autowired
  private SurveyorNotificationService surveyorNotificationService;

  @Autowired
  private SurveyorAssignmentService surveyorAssignmentService;

  @Autowired
  private RestTemplate restTemplate;

  @Value("${google.cloud.storage.file-key}")
  private String googleCloudStorageFileKey;

  @Value("${google.cloud.storage.project-id}")
  private String googleCloudStorageProjectId;

  @Value("${google.cloud.storage.bucket-name}")
  private String googleCloudStorageBucketName;

  @Value("${plugin.identity.keycloak.clientId}")
  private String keycloakClientId;

  @Value("${plugin.identity.keycloak.clientSecret}")
  private String keycloakClientSecret;

  @Override
  public SurveyorSummaryResponse getSummary(String surveyorId) {
    SurveyorNotificationCountUnreadResponse surveyorNotificationCountUnreadResponse = surveyorNotificationService.getCountUnread(
      surveyorId
    );

    List<SurveyorAssignmentResponse> surveyorAssignmentResponses = surveyorAssignmentService.findAllBySurveyorId(
      surveyorId
    );

    long countNewAssignment = 0;
    long countOpenAssignment = 0;
    long countDraftSaved = 0;
    long countDocumentSubmission = 0;

    for (SurveyorAssignmentResponse surveyorAssignmentResponse : surveyorAssignmentResponses) {
      if (!surveyorAssignmentResponse.isLoaded()) {
        countNewAssignment += 1;
      }

      if (
        surveyorAssignmentResponse.isLoaded() &&
        surveyorAssignmentResponse.getAssignmentStatus().equals(SurveyorConstants.AssignmentStatus.WIP)
      ) {
        countOpenAssignment += 1;
      }

      if (surveyorAssignmentResponse.getAssignmentStatus().equals(SurveyorConstants.AssignmentStatus.WIP)) {
        countDraftSaved += 1;
      }

      if (surveyorAssignmentResponse.getAssignmentStatus().equals(SurveyorConstants.AssignmentStatus.COMPLETE)) {
        countDocumentSubmission += 1;
      }
    }

    return SurveyorSummaryResponse
      .builder()
      .countUnreadNotification(surveyorNotificationCountUnreadResponse.getCountUnreadNotification())
      .countNewAssignment(countNewAssignment)
      .countOpenAssignment(countOpenAssignment)
      .countDraftSaved(countDraftSaved)
      .countDocumentSubmission(countDocumentSubmission)
      .build();
  }

  @Override
  public SurveyorUploadResponse upload(MultipartFile file) {
    try {
      Credentials credentials = GoogleCredentials.fromStream(new FileInputStream(googleCloudStorageFileKey));
      Storage storage = StorageOptions
        .newBuilder()
        .setCredentials(credentials)
        .setProjectId(googleCloudStorageProjectId)
        .build()
        .getService();
      BlobId blobId = BlobId.of(
        googleCloudStorageBucketName,
        String.format("%s-%s", DateUtil.getUnixTimestamp(), file.getOriginalFilename())
      );
      BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
      storage.create(blobInfo, file.getBytes());
      return SurveyorUploadResponse.builder().storageObject(blobId.getName()).build();
    } catch (IOException e) {
      return null;
    }
  }
}

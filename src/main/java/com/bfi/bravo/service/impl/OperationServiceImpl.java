package com.bfi.bravo.service.impl;

import com.bfi.bravo.dto.operation.response.OperationUploadResponse;
import com.bfi.bravo.service.OperationService;
import com.bfi.bravo.utils.DateUtil;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;

@Slf4j
@Service
public class OperationServiceImpl implements OperationService {

  @Value("${google.cloud.storage.file-key}")
  private String googleCloudStorageFileKey;

  @Value("${google.cloud.storage.project-id}")
  private String googleCloudStorageProjectId;

  @Value("${google.cloud.storage.bucket-name}")
  private String googleCloudStorageBucketName;

  @Override
  public OperationUploadResponse upload(MultipartFile file) {
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
      return OperationUploadResponse.builder().storageObject(blobId.getName()).build();
    } catch (IOException e) {
      return null;
    }
  }
}

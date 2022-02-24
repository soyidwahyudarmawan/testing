package com.bfi.bravo.service;

import com.bfi.bravo.dto.operation.response.OperationUploadResponse;
import org.springframework.web.multipart.MultipartFile;

public interface OperationService {
  public OperationUploadResponse upload(MultipartFile file);
}

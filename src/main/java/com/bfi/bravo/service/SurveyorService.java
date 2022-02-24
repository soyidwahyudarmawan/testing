package com.bfi.bravo.service;

import com.bfi.bravo.dto.surveyor.response.SurveyorSummaryResponse;
import com.bfi.bravo.dto.surveyor.response.SurveyorUploadResponse;
import org.springframework.web.multipart.MultipartFile;

public interface SurveyorService {
  public SurveyorSummaryResponse getSummary(String surveyorId);

  public SurveyorUploadResponse upload(MultipartFile file);
}

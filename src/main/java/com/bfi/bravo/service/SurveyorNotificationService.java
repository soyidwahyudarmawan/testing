package com.bfi.bravo.service;

import com.bfi.bravo.dto.notification.request.SurveyorNotificationCreateRequest;
import com.bfi.bravo.dto.notification.request.SurveyorNotificationReadStatusUpdateRequest;
import com.bfi.bravo.dto.notification.request.SurveyorNotificationStatusUpdateRequest;
import com.bfi.bravo.dto.notification.response.SurveyorNotificationCountUnreadResponse;
import com.bfi.bravo.dto.notification.response.SurveyorNotificationCreateResponse;
import com.bfi.bravo.dto.notification.response.SurveyorNotificationReadStatusUpdateResponse;
import com.bfi.bravo.dto.notification.response.SurveyorNotificationResponse;
import com.bfi.bravo.dto.notification.response.SurveyorNotificationStatusUpdateResponse;
import java.util.List;

public interface SurveyorNotificationService {
  public SurveyorNotificationCreateResponse create(SurveyorNotificationCreateRequest request);

  public SurveyorNotificationStatusUpdateResponse updateNotificationStatus(
    SurveyorNotificationStatusUpdateRequest request
  );

  public SurveyorNotificationReadStatusUpdateResponse updateReadStatus(
    SurveyorNotificationReadStatusUpdateRequest request
  );

  public List<SurveyorNotificationResponse> findAll();

  public SurveyorNotificationResponse findById(Long id);

  public List<SurveyorNotificationResponse> findAllBySurveyorId(String surveyorId);

  public SurveyorNotificationCountUnreadResponse getCountUnread(String surveyorId);
}

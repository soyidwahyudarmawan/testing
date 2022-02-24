package com.bfi.bravo.service.impl;

import com.bfi.bravo.constant.AppConstants;
import com.bfi.bravo.constant.NotificationConstants.ReadStatus;
import com.bfi.bravo.dto.notification.request.SurveyorNotificationCreateRequest;
import com.bfi.bravo.dto.notification.request.SurveyorNotificationReadStatusUpdateRequest;
import com.bfi.bravo.dto.notification.request.SurveyorNotificationStatusUpdateRequest;
import com.bfi.bravo.dto.notification.response.SurveyorNotificationCountUnreadResponse;
import com.bfi.bravo.dto.notification.response.SurveyorNotificationCreateResponse;
import com.bfi.bravo.dto.notification.response.SurveyorNotificationReadStatusUpdateResponse;
import com.bfi.bravo.dto.notification.response.SurveyorNotificationResponse;
import com.bfi.bravo.dto.notification.response.SurveyorNotificationStatusUpdateResponse;
import com.bfi.bravo.entity.SurveyorNotification;
import com.bfi.bravo.entity.SurveyorNotification;
import com.bfi.bravo.repository.SurveyorNotificationRepository;
import com.bfi.bravo.repository.SurveyorNotificationRepository;
import com.bfi.bravo.service.SurveyorNotificationService;
import com.bfi.bravo.service.SurveyorNotificationService;
import com.bfi.bravo.utils.DateUtil;
import com.bfi.bravo.utils.DateUtil;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
public class SurveyorNotificationServiceImpl implements SurveyorNotificationService {

  @Autowired
  private SurveyorNotificationRepository surveyorNotificationRepository;

  @Override
  public SurveyorNotificationCreateResponse create(SurveyorNotificationCreateRequest request) {
    SurveyorNotification surveyorNotification = surveyorNotificationRepository.save(
      SurveyorNotification
        .builder()
        .surveyorId(request.getSurveyorId())
        .title(request.getTitle())
        .message(request.getMessage())
        .notificationStatus(request.getNotificationStatus())
        .readStatus(request.getReadStatus())
        .actionType(request.getActionType())
        .notificationData(request.getNotificationData())
        .build()
    );

    return SurveyorNotificationCreateResponse.builder().surveyorNotificationId(surveyorNotification.getId()).build();
  }

  @Override
  public SurveyorNotificationStatusUpdateResponse updateNotificationStatus(
    SurveyorNotificationStatusUpdateRequest request
  ) {
    SurveyorNotification surveyorNotification = surveyorNotificationRepository
      .findByIdAndActiveIsTrue(request.getSurveyorNotificationId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    surveyorNotification.setNotificationStatus(request.getNotificationStatus());

    SurveyorNotification newSurveyorNotification = surveyorNotificationRepository.save(surveyorNotification);

    return SurveyorNotificationStatusUpdateResponse
      .builder()
      .surveyorNotificationId(newSurveyorNotification.getId())
      .notificationStatus(newSurveyorNotification.getNotificationStatus())
      .build();
  }

  @Override
  public SurveyorNotificationReadStatusUpdateResponse updateReadStatus(
    SurveyorNotificationReadStatusUpdateRequest request
  ) {
    SurveyorNotification surveyorNotification = surveyorNotificationRepository
      .findByIdAndActiveIsTrue(request.getSurveyorNotificationId())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    surveyorNotification.setReadStatus(request.getReadStatus());

    SurveyorNotification newSurveyorNotification = surveyorNotificationRepository.save(surveyorNotification);

    return SurveyorNotificationReadStatusUpdateResponse
      .builder()
      .surveyorNotificationId(newSurveyorNotification.getId())
      .readStatus(newSurveyorNotification.getReadStatus())
      .build();
  }

  @Override
  public List<SurveyorNotificationResponse> findAll() {
    List<SurveyorNotification> surveyorNotifications = Streamable
      .of(surveyorNotificationRepository.findAllByActiveIsTrue())
      .toList();

    List<SurveyorNotificationResponse> result = new ArrayList<>();
    surveyorNotifications.forEach(surveyorNotification -> {
      result.add(
        SurveyorNotificationResponse
          .builder()
          .notificationDate(
            DateUtil.formatDatetime(surveyorNotification.getCreatedDate(), AppConstants.DATE_FORMAT_DATE_2)
          )
          .id(surveyorNotification.getId())
          .surveyorId(surveyorNotification.getSurveyorId())
          .title(surveyorNotification.getTitle())
          .message(surveyorNotification.getMessage())
          .notificationStatus(surveyorNotification.getNotificationStatus())
          .readStatus(surveyorNotification.getReadStatus())
          .actionType(surveyorNotification.getActionType())
          .notificationData(surveyorNotification.getNotificationData())
          .build()
      );
    });

    return result;
  }

  @Override
  public SurveyorNotificationResponse findById(Long id) {
    SurveyorNotification surveyorNotification = surveyorNotificationRepository
      .findByIdAndActiveIsTrue(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return SurveyorNotificationResponse
      .builder()
      .notificationDate(DateUtil.formatDatetime(surveyorNotification.getCreatedDate(), AppConstants.DATE_FORMAT_DATE_2))
      .id(surveyorNotification.getId())
      .surveyorId(surveyorNotification.getSurveyorId())
      .title(surveyorNotification.getTitle())
      .message(surveyorNotification.getMessage())
      .notificationStatus(surveyorNotification.getNotificationStatus())
      .readStatus(surveyorNotification.getReadStatus())
      .actionType(surveyorNotification.getActionType())
      .notificationData(surveyorNotification.getNotificationData())
      .build();
  }

  @Override
  public List<SurveyorNotificationResponse> findAllBySurveyorId(String surveyorId) {
    List<SurveyorNotification> surveyorNotifications = Streamable
      .of(surveyorNotificationRepository.findAllBySurveyorIdAndActiveIsTrue(surveyorId))
      .toList();

    List<SurveyorNotificationResponse> result = new ArrayList<>();
    surveyorNotifications.forEach(surveyorNotification -> {
      result.add(
        SurveyorNotificationResponse
          .builder()
          .notificationDate(
            DateUtil.formatDatetime(surveyorNotification.getCreatedDate(), AppConstants.DATE_FORMAT_DATE_2)
          )
          .id(surveyorNotification.getId())
          .surveyorId(surveyorNotification.getSurveyorId())
          .title(surveyorNotification.getTitle())
          .message(surveyorNotification.getMessage())
          .notificationStatus(surveyorNotification.getNotificationStatus())
          .readStatus(surveyorNotification.getReadStatus())
          .actionType(surveyorNotification.getActionType())
          .notificationData(surveyorNotification.getNotificationData())
          .build()
      );
    });

    return result;
  }

  @Override
  public SurveyorNotificationCountUnreadResponse getCountUnread(String surveyorId) {
    long countUnreadNotification = surveyorNotificationRepository.countAllBySurveyorIdAndReadStatusAndActiveIsTrue(
      surveyorId,
      ReadStatus.UNREAD
    );
    return SurveyorNotificationCountUnreadResponse.builder().countUnreadNotification(countUnreadNotification).build();
  }
}

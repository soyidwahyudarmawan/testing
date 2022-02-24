package com.bfi.bravo.repository;

import com.bfi.bravo.constant.NotificationConstants.ReadStatus;
import com.bfi.bravo.entity.SurveyorNotification;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyorNotificationRepository extends CrudRepository<SurveyorNotification, Long> {
  public Iterable<SurveyorNotification> findAllByActiveIsTrue();

  public Optional<SurveyorNotification> findByIdAndActiveIsTrue(Long id);

  public Iterable<SurveyorNotification> findAllBySurveyorIdAndActiveIsTrue(String surveyorId);

  public long countAllBySurveyorIdAndReadStatusAndActiveIsTrue(String surveyorId, ReadStatus readStatus);
}

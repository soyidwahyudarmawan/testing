package com.bfi.bravo.entity;

import com.bfi.bravo.constant.NotificationConstants.ActionType;
import com.bfi.bravo.constant.NotificationConstants.NotificationStatus;
import com.bfi.bravo.constant.NotificationConstants.ReadStatus;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SurveyorNotification {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String surveyorId;

  @Column
  private String title;

  @Column
  private String message;

  @Column
  @Enumerated(EnumType.STRING)
  private NotificationStatus notificationStatus;

  @Column
  @Enumerated(EnumType.STRING)
  private ReadStatus readStatus;

  @Column
  @Enumerated(EnumType.STRING)
  private ActionType actionType;

  @Column
  private String notificationData;

  @Column(columnDefinition = "boolean default TRUE")
  @Builder.Default
  private boolean active = true;

  @CreationTimestamp
  private LocalDateTime createdDate;

  @Column
  private String createdUser;

  @UpdateTimestamp
  private LocalDateTime updatedDate;

  @Column
  private String updatedUser;
}

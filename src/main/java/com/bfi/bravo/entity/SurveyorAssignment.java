package com.bfi.bravo.entity;

import com.bfi.bravo.constant.SurveyorConstants.AssignmentStatus;
import com.bfi.bravo.constant.SurveyorConstants.AssignmentType;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
public class SurveyorAssignment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "application_id", referencedColumnName = "id")
  private Application application;

  @Column
  private String applicationNumber;

  @Column
  private UUID leadId;

  @Column
  private String leadNumber;

  @Column
  private String surveyorId;

  @Column
  @Enumerated(EnumType.STRING)
  private AssignmentType assignmentType;

  @Column
  @Enumerated(EnumType.STRING)
  private AssignmentStatus assignmentStatus;

  @Column(columnDefinition = "boolean default FALSE")
  private boolean loaded;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "branch_id", referencedColumnName = "id")
  private Branch branch;

  @Column
  private Long productId;

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

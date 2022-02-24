package com.bfi.bravo.entity;

import java.time.LocalDateTime;
import javax.persistence.*;

import com.bfi.bravo.constant.AssignmentConstants;
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
public class OperationAssignment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "application_id", referencedColumnName = "id")
  private Application application;

  @Column
  private String applicationNumber;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "surveyor_assignment_id", referencedColumnName = "id")
  private SurveyorAssignment surveyorAssignment;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "branch_id", referencedColumnName = "id")
  private Branch branch;

  @Column
  private LocalDateTime assignmentDate;

  @Column
  @Builder.Default
  private boolean assetDocumentDataCompleted = false;

  @Column
  @Builder.Default
  private boolean documentSignCompleted = false;

  @Column
  @Builder.Default
  private boolean physicalDocumentCompleted = false;

  @Column
  @Builder.Default
  private boolean thirdPartyInformationCompleted = false;

  @Column
  @Builder.Default
  private boolean fundingInformationCompleted = false;

  @Column
  @Builder.Default
  private boolean assetDataCompleted = false;

  // TODO MAKE STATUS TO ENUM
  @Column
  private String assignmentStatus;

  @Column
  private String assignmentBranchStatus;

  @Column
  private String assignmentHeadOfficeStatus;

  @Column
  private String branchPic;

  @Column
  @Enumerated(EnumType.STRING)
  private AssignmentConstants.DataEnrichmentStatus statusEnrichment;

  @Column
  @Enumerated(EnumType.STRING)
  private AssignmentConstants.RequestGoLiveStatus statusGoLive;

  @Column
  private String headOfficeCdpPic;

  @Column
  private String headOfficeRcoPic;

  @Column
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

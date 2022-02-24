package com.bfi.bravo.entity;

import com.bfi.bravo.constant.AssignmentConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "assignment")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Assignment {
  @CreationTimestamp
  private LocalDateTime createdDate;

  @Column
  private String createdUser;

  @UpdateTimestamp
  private LocalDateTime updatedDate;

  @Column
  private String updatedUser;

  // Field on ERD
  // Field in Global Page
  //------Start---------//
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long assignmentId;

  @Column(name = "application_id")
  private UUID applicationId;

  @Column(name = "application_number")
  private String applicationNumber;

  @Column(name = "surveyor_assignment_id")
  private Long surveyorAssignmentId;

  @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
  @JoinColumn(name = "branch_id", referencedColumnName = "id")
  private Branch branch;

  @Column(name = "assignment_date")
  private LocalDateTime assignmentDate;

  @Column(name = "asset_document_data_completed")
  private Boolean assetDocumentDataCompleted;

  @Column(name = "document_sign_completed")
  private Boolean documentSignCompleted;

  @Column(name = "physical_document_completed")
  private Boolean physicalDocumentCompleted;

  @Column(name = "third_party_information_completed")
  private Boolean thirdPartyInformationCompleted;

  @Column(name = "funding_information_completed")
  private Boolean fundingInformationCompleted;

  @Column(name = "asset_data_completed")
  private Boolean assetDataCompleted;

  @Column
  @Enumerated(EnumType.STRING)
  private AssignmentConstants.DataEnrichmentStatus statusEnrichment;

  @Column
  @Enumerated(EnumType.STRING)
  private AssignmentConstants.RequestGoLiveStatus statusGoLive;

  @Column(name = "handler")
  private String handler;

  @Column(name = "head_office_cdp_time")
  @CreationTimestamp
  private Timestamp headOfficeCdpTime;

  //------------END----------------//

  @Column(name = "assignment_status")
  private String assignmentStatus;

  @Column(name = "assignment_branch_status")
  private String assignmentBranchStatus;

  @Column(name = "assignment_head_office_status")
  private String assignmentHeadOfficeStatus;

  @Column(name = "branch_pic")
  private UUID branchPic;

  @Column(name = "head_office_cdp_pic")
  private UUID headOfficeCdpPic;

  @Column(name = "head_office_rco_pic")
  private UUID headOfficeRcoPic;


  @Column(columnDefinition = "boolean default TRUE")
  @Builder.Default
  private boolean active = true;
}

package com.bfi.bravo.entity;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class SurveyorAssignmentDocumentSign {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "assignment_id", referencedColumnName = "id")
  private SurveyorAssignment assignment;

  @Column(columnDefinition = "boolean default FALSE")
  private boolean bankReceiptByCustomer;

  @Column(columnDefinition = "boolean default FALSE")
  private boolean bankReceiptByOwner;

  @Column(columnDefinition = "boolean default FALSE")
  private boolean customerApplicationRequest;

  @Column(columnDefinition = "boolean default FALSE")
  private boolean loanContractAgreementTransferTitle;

  @Column(columnDefinition = "boolean default FALSE")
  private boolean loanControlAgreementFunding;

  @Column(columnDefinition = "boolean default FALSE")
  private boolean fiduciary;

  @Column(columnDefinition = "boolean default FALSE")
  private boolean fppSigned;

  @Column
  private String customerSignDocumentPhoto;

  @Column
  private String surveyorNote;

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

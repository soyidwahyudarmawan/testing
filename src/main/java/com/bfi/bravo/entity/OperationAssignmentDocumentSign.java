package com.bfi.bravo.entity;

import java.time.LocalDateTime;
import javax.persistence.*;

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
public class OperationAssignmentDocumentSign {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "assignment_id", referencedColumnName = "id")
  private OperationAssignment assignment;

  @Column
  @Builder.Default
  private boolean bankReceiptByCustomer = false;

  @Column
  @Builder.Default
  private boolean bankReceiptByOwner = false;

  @Column
  @Builder.Default
  private boolean customerApplicationRequest = false;

  @Column
  @Builder.Default
  private boolean loanContractAgreementTransferTitle = false;

  @Column
  @Builder.Default
  private boolean loanControlAgreementFunding = false;

  @Column
  @Builder.Default
  private boolean fiduciary = false;

  @Column
  @Builder.Default
  private boolean fppSigned = false;

  @Column
  private String customerSignDocumentPhoto;

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

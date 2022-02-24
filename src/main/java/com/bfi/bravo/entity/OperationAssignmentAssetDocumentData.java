package com.bfi.bravo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
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
public class OperationAssignmentAssetDocumentData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "assignment_id", referencedColumnName = "id")
  private OperationAssignment assignment;

  @Column
  @Builder.Default
  private boolean vehicleOwnershipCompleted = false;

  @Column
  @Builder.Default
  private boolean vehicleRegistrationCompleted = false;

  @Column
  @Builder.Default
  private boolean taxNoticeCompleted = false;

  @Column
  private String assetCodeBrand;

  @Column
  private String assetBrandName;

  @Column
  private String assetCodeModel;

  @Column
  private String assetModelName;

  @Column
  private String assetCodeVariant;

  @Column
  private String assetVariantName;

  @Column
  private int assetYearMade;

  @Column
  private String licenseNumber;

  @Column
  private String vehicleOwnershipNumber;

  @Column
  private String vehicleOwnershipOnBehalfOf;

  @Column
  private String vehicleOwnershipChassisNumber;

  @Column
  private String vehicleOwnershipMachineNumber;

  @Column
  private String vehicleRegistrationNumber;

  @Column
  private LocalDate vehicleRegistrationExpiredDate;

  @Column
  private String vehicleRegistrationColor;

  @Column
  private String vehicleRegistrationChassisNumber;

  @Column
  private String vehicleRegistrationMachineNumber;

  @Column
  private String taxNoticeNumber;

  @Column
  private LocalDate taxNoticeExpiredDate;

  @Column
  private String taxNoticeColor;

  @Column
  private String taxNoticeChassisNumber;

  @Column
  private String taxNoticeMachineNumber;

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

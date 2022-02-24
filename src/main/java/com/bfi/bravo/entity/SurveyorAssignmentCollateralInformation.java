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
public class SurveyorAssignmentCollateralInformation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "assignment_id", referencedColumnName = "id")
  private SurveyorAssignment assignment;

  @Column
  private String brandCode;

  @Column
  private String brandName;

  @Column
  private String modelCode;

  @Column
  private String modelName;

  @Column
  private String variantCode;

  @Column
  private String variantName;

  @Column
  private int yearMade;

  @Column
  private String licenseNumber;

  @Column
  private String vehicleRegistrationPhoto;

  @Column
  private String vehicleTaxNoticePhoto;

  @Column
  private String vehicleLeftSidePhoto;

  @Column
  private String vehicleRightSidePhoto;

  @Column
  private String vehicleFrontSidePhoto;

  @Column
  private String vehicleBackSidePhoto;

  @Column
  private String vehicleDashboardSidePhoto;

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

package com.bfi.bravo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
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
public class SurveyorAssignmentPersonalData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "assignment_id", referencedColumnName = "id")
  private SurveyorAssignment assignment;

  @Column
  private UUID customerId;

  @Column
  private String customerName;

  @Column
  private String customerDomicileAddress;

  @Column
  private String customerDomicileAdditionalAddress;

  @Column
  private String customerDomicileProvinceCode;

  @Column
  private String customerDomicileProvinceName;

  @Column
  private String customerDomicileCityCode;

  @Column
  private String customerDomicileCityName;

  @Column
  private String customerDomicileDistrictCode;

  @Column
  private String customerDomicileDistrictName;

  @Column
  private String customerDomicileSubdistrictCode;

  @Column
  private String customerDomicileSubdistrictName;

  @Column
  private String customerDomicileZipcode;

  @Column
  private BigDecimal customerDomicileLongitude;

  @Column
  private BigDecimal customerDomicileLatitude;

  @Column(columnDefinition = "boolean default FALSE")
  private boolean sameWithDomicile;

  @Column
  private String customerLegalProvinceCode;

  @Column
  private String customerLegalProvinceName;

  @Column
  private String customerLegalCityCode;

  @Column
  private String customerLegalCityName;

  @Column
  private String customerLegalDistrictCode;

  @Column
  private String customerLegalDistrictName;

  @Column
  private String customerLegalSubdistrictCode;

  @Column
  private String customerLegalSubdistrictName;

  @Column
  private String customerLegalZipcode;

  @Column
  private String customerPhoneNumber;

  @Column
  private String customerSelfiePhoto;

  @Column
  private String customerIdentityCardPhoto;

  @Column
  private String customerFamilyCardPhoto;

  @Column(columnDefinition = "boolean default FALSE")
  private boolean customerIsMarried;

  @Column
  private String customerSpouseName;

  @Column
  private String customerSpouseOccupationCode;

  @Column
  private String customerSpouseOccupationName;

  @Column
  private String customerSpousePhoneNumber;

  @Column
  private String customerSpouseIdentityCardPhoto;

  @Column
  private String customerMotherMaidenName;

  @Column
  private int customerCountDependency;

  @Column
  private String customerHousePhoto;

  @Column
  private String customerHouseTwoPhoto;

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

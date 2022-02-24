package com.bfi.bravo.entity;

import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.persistence.*;
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
public class SurveyorAssignmentOccupationData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "assignment_id", referencedColumnName = "id")
  private SurveyorAssignment assignment;

  @Column
  private String economySectorCode;

  @Column
  private String economySectorName;

  @Column
  private String industryTypeCode;

  @Column
  private String industryTypeName;

  @Column
  private String occupationCode;

  @Column
  private String occupationName;

  @Column
  private String companyName;

  @Column
  private String provinceCode;

  @Column
  private String provinceName;

  @Column
  private String cityCode;

  @Column
  private String cityName;

  @Column
  private String districtCode;

  @Column
  private String districtName;

  @Column
  private String subdistrictCode;

  @Column
  private String subdistrictName;

  @Column
  private String zipcode;

  @Column
  private String phoneNumber;

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

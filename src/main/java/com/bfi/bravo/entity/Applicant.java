package com.bfi.bravo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Applicant {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private UUID customerId;

  @Column
  private String fullName;

  @Column
  private String phoneNumber;

  @Column
  private String identityNumber;

  @Column
  private String npwpNumber;

  @Column
  private String maritalStatus;

  @Column
  private String gender;

  @Column
  private LocalDate dateOfBirth;

  @Column
  private String placeOfBirth;

  @Column
  private String nationality;

  @Column
  private BigDecimal monthlyIncome;

  @Column
  private String address;

  @Column
  private String additionalAddress;

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
  private BigDecimal longitude;

  @Column
  private BigDecimal latitude;

  @Column
  private String selfiePhoto;

  @Column
  private String identityPhoto;

  @Column
  private String spouseIdentityPhoto;

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

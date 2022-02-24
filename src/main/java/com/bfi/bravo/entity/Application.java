package com.bfi.bravo.entity;

import com.bfi.bravo.constant.ApplicationConstants.ApplicationStatus;
import java.math.BigDecimal;
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
public class Application {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long number;

  @Column
  private UUID leadId;

  @Column
  private String leadNumber;

  @Column
  @Enumerated(EnumType.STRING)
  private ApplicationStatus status;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "collateral_id", referencedColumnName = "id")
  private Collateral collateral;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "applicant_id", referencedColumnName = "id")
  private Applicant applicant;

  @Column
  private BigDecimal amount;

  @Column
  private int tenor;

  @Column
  private BigDecimal installmentAmount;

  @Column
  private Long productId;

  @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
  @JoinColumn(name = "branch_id", referencedColumnName = "id")
  private Branch branch;

  @Column
  private UUID processId;

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

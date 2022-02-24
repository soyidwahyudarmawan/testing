package com.bfi.bravo.entity;

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
public class OperationAssignmentAssetData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "assignment_id", referencedColumnName = "id")
  private OperationAssignment assignment;

  @Column
  @Builder.Default
  private boolean assetBrandChecked = false;

  @Column
  @Builder.Default
  private boolean assetModelChecked = false;

  @Column
  @Builder.Default
  private boolean assetVariantChecked = false;

  @Column
  @Builder.Default
  private boolean assetYearMadeChecked = false;

  @Column
  @Builder.Default
  private boolean licenseNumberChecked = false;

  @Column
  @Builder.Default
  private boolean nokaNosinChecked = false;

  @Column
  @Builder.Default
  private boolean colorChecked = false;

  @Column
  @Builder.Default
  private boolean taxNoticeChecked = false;

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

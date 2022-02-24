package com.bfi.bravo.repository;

import com.bfi.bravo.entity.OperationAssignmentAssetDocumentData;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationAssignmentAssetDocumentDataRepository
  extends CrudRepository<OperationAssignmentAssetDocumentData, Long> {
  public Iterable<OperationAssignmentAssetDocumentData> findAllByActiveIsTrue();

  public Optional<OperationAssignmentAssetDocumentData> findByIdAndActiveIsTrue(Long id);

  public Optional<OperationAssignmentAssetDocumentData> findByAssignmentIdAndActiveIsTrue(Long assignmentId);
}

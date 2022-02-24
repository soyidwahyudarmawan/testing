package com.bfi.bravo.repository;

import com.bfi.bravo.entity.OperationAssignmentAssetData;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationAssignmentAssetDataRepository
  extends CrudRepository<OperationAssignmentAssetData, Long> {
  public Iterable<OperationAssignmentAssetData> findAllByActiveIsTrue();

  public Optional<OperationAssignmentAssetData> findByIdAndActiveIsTrue(Long id);

  public Optional<OperationAssignmentAssetData> findByAssignmentIdAndActiveIsTrue(Long assignmentId);
}

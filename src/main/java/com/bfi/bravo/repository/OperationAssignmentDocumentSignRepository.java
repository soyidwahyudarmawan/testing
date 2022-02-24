package com.bfi.bravo.repository;

import com.bfi.bravo.entity.OperationAssignmentDocumentSign;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperationAssignmentDocumentSignRepository
  extends CrudRepository<OperationAssignmentDocumentSign, Long> {
  public Iterable<OperationAssignmentDocumentSign> findAllByActiveIsTrue();

  public Optional<OperationAssignmentDocumentSign> findByIdAndActiveIsTrue(Long id);

  public Optional<OperationAssignmentDocumentSign> findByAssignmentIdAndActiveIsTrue(Long assignmentId);
}

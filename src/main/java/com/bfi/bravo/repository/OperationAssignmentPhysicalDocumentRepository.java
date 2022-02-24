package com.bfi.bravo.repository;

import com.bfi.bravo.entity.OperationAssignmentPhysicalDocument;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperationAssignmentPhysicalDocumentRepository
  extends CrudRepository<OperationAssignmentPhysicalDocument, Long> {
  public Iterable<OperationAssignmentPhysicalDocument> findAllByActiveIsTrue();

  public Optional<OperationAssignmentPhysicalDocument> findByIdAndActiveIsTrue(Long id);

  public Optional<OperationAssignmentPhysicalDocument> findByAssignmentIdAndActiveIsTrue(Long assignmentId);
}

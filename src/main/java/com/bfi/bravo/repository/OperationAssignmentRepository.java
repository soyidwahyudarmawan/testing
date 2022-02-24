package com.bfi.bravo.repository;

import com.bfi.bravo.entity.OperationAssignment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperationAssignmentRepository extends CrudRepository<OperationAssignment, Long> {
  public Iterable<OperationAssignment> findAllByActiveIsTrue();

  public Optional<OperationAssignment> findByIdAndActiveIsTrue(Long id);
}

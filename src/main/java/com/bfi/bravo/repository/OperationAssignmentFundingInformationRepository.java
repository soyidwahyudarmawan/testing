package com.bfi.bravo.repository;

import com.bfi.bravo.entity.OperationAssignmentFundingInformation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperationAssignmentFundingInformationRepository
  extends CrudRepository<OperationAssignmentFundingInformation, Long> {
  public Iterable<OperationAssignmentFundingInformation> findAllByActiveIsTrue();

  public Optional<OperationAssignmentFundingInformation> findByIdAndActiveIsTrue(Long id);

  public Optional<OperationAssignmentFundingInformation> findByAssignmentIdAndActiveIsTrue(Long assignmentId);
}

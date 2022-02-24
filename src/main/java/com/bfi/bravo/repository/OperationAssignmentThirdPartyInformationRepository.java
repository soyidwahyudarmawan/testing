package com.bfi.bravo.repository;

import com.bfi.bravo.entity.OperationAssignmentThirdPartyInformation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperationAssignmentThirdPartyInformationRepository
  extends CrudRepository<OperationAssignmentThirdPartyInformation, Long> {
  public Iterable<OperationAssignmentThirdPartyInformation> findAllByActiveIsTrue();

  public Optional<OperationAssignmentThirdPartyInformation> findByIdAndActiveIsTrue(Long id);

  public Optional<OperationAssignmentThirdPartyInformation> findByAssignmentIdAndActiveIsTrue(Long assignmentId);
}

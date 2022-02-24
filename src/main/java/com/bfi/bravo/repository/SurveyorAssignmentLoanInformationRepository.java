package com.bfi.bravo.repository;

import com.bfi.bravo.entity.SurveyorAssignmentLoanInformation;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyorAssignmentLoanInformationRepository
  extends CrudRepository<SurveyorAssignmentLoanInformation, Long> {
  public Iterable<SurveyorAssignmentLoanInformation> findAllByActiveIsTrue();

  public Optional<SurveyorAssignmentLoanInformation> findByIdAndActiveIsTrue(Long id);

  public Optional<SurveyorAssignmentLoanInformation> findByAssignmentIdAndActiveIsTrue(Long assignmentId);
}

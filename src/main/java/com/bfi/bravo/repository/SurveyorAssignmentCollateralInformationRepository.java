package com.bfi.bravo.repository;

import com.bfi.bravo.entity.SurveyorAssignmentCollateralInformation;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyorAssignmentCollateralInformationRepository
  extends CrudRepository<SurveyorAssignmentCollateralInformation, Long> {
  public Iterable<SurveyorAssignmentCollateralInformation> findAllByActiveIsTrue();

  public Optional<SurveyorAssignmentCollateralInformation> findByIdAndActiveIsTrue(Long id);

  public Optional<SurveyorAssignmentCollateralInformation> findByAssignmentIdAndActiveIsTrue(Long assignmentId);
}

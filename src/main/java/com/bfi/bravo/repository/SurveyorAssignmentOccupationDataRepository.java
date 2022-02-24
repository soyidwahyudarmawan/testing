package com.bfi.bravo.repository;

import com.bfi.bravo.entity.SurveyorAssignmentOccupationData;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyorAssignmentOccupationDataRepository
  extends CrudRepository<SurveyorAssignmentOccupationData, Long> {
  public Iterable<SurveyorAssignmentOccupationData> findAllByActiveIsTrue();

  public Optional<SurveyorAssignmentOccupationData> findByIdAndActiveIsTrue(Long id);

  public Optional<SurveyorAssignmentOccupationData> findByAssignmentIdAndActiveIsTrue(Long assignmentId);
}

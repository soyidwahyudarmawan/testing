package com.bfi.bravo.repository;

import com.bfi.bravo.entity.SurveyorAssignmentPersonalData;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyorAssignmentPersonalDataRepository extends CrudRepository<SurveyorAssignmentPersonalData, Long> {
  public Iterable<SurveyorAssignmentPersonalData> findAllByActiveIsTrue();

  public Optional<SurveyorAssignmentPersonalData> findByIdAndActiveIsTrue(Long id);

  public Optional<SurveyorAssignmentPersonalData> findByAssignmentIdAndActiveIsTrue(Long assignmentId);
}

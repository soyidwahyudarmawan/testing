package com.bfi.bravo.repository;

import com.bfi.bravo.entity.SurveyorAssignment;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyorAssignmentRepository extends CrudRepository<SurveyorAssignment, Long> {
  public Iterable<SurveyorAssignment> findAllByActiveIsTrue();

  public Optional<SurveyorAssignment> findByIdAndActiveIsTrue(Long id);

  public Iterable<SurveyorAssignment> findAllBySurveyorIdAndActiveIsTrue(String surveyorId);
}

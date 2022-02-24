package com.bfi.bravo.repository;

import com.bfi.bravo.entity.SurveyorAssignmentDocumentSign;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyorAssignmentDocumentSignRepository extends CrudRepository<SurveyorAssignmentDocumentSign, Long> {
  public Iterable<SurveyorAssignmentDocumentSign> findAllByActiveIsTrue();

  public Optional<SurveyorAssignmentDocumentSign> findByIdAndActiveIsTrue(Long id);

  public Optional<SurveyorAssignmentDocumentSign> findByAssignmentIdAndActiveIsTrue(Long assignmentId);
}

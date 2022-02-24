package com.bfi.bravo.repository;

import com.bfi.bravo.entity.SurveyorAssignmentPhysicalDocument;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyorAssignmentPhysicalDocumentRepository
  extends CrudRepository<SurveyorAssignmentPhysicalDocument, Long> {
  public Iterable<SurveyorAssignmentPhysicalDocument> findAllByActiveIsTrue();

  public Optional<SurveyorAssignmentPhysicalDocument> findByIdAndActiveIsTrue(Long id);

  public Optional<SurveyorAssignmentPhysicalDocument> findByAssignmentIdAndActiveIsTrue(Long assignmentId);
}

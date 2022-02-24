package com.bfi.bravo.repository;

import com.bfi.bravo.entity.SurveyorAssignmentEmergencyContact;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyorAssignmentEmergencyContactRepository
  extends CrudRepository<SurveyorAssignmentEmergencyContact, Long> {
  public Iterable<SurveyorAssignmentEmergencyContact> findAllByActiveIsTrue();

  public Optional<SurveyorAssignmentEmergencyContact> findByIdAndActiveIsTrue(Long id);

  public Optional<SurveyorAssignmentEmergencyContact> findByAssignmentIdAndActiveIsTrue(Long assignmentId);
}

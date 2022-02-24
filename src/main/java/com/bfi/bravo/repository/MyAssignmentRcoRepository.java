package com.bfi.bravo.repository;

import com.bfi.bravo.entity.Assignment;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyAssignmentRcoRepository extends CrudRepository<Assignment, Long>
{
  public Iterable<Assignment> findAllByActiveIsTrue();
  public Optional<Assignment> findAllByAssignmentId(Long id);
}

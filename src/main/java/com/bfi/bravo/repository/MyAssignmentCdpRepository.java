package com.bfi.bravo.repository;

import com.bfi.bravo.entity.Assignment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyAssignmentCdpRepository extends CrudRepository<Assignment, Long>
{
  public Iterable<Assignment> findAllByActiveIsTrue();
}

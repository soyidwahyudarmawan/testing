package com.bfi.bravo.repository;

import com.bfi.bravo.entity.Branch;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends CrudRepository<Branch, Long> {
  public Iterable<Branch> findAllByActiveIsTrue();

  public Optional<Branch> findByIdAndActiveIsTrue(Long id);
}

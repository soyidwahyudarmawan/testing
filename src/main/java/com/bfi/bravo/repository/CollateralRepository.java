package com.bfi.bravo.repository;

import com.bfi.bravo.entity.Collateral;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CollateralRepository extends CrudRepository<Collateral, Long> {
  public Optional<Collateral> findCollateralById(Long id);
  public Iterable<Collateral> findAllByActiveIsTrue();
}

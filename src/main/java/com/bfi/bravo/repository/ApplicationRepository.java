package com.bfi.bravo.repository;

import com.bfi.bravo.entity.Application;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends CrudRepository<Application, UUID> {
  public Iterable<Application> findAllByActiveIsTrue();
  public Optional<Application> findByIdAndActiveIsTrue(UUID id);
}

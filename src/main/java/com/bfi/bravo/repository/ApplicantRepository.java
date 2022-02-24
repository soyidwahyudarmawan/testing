package com.bfi.bravo.repository;

import com.bfi.bravo.entity.Applicant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends CrudRepository<Applicant, Long> {}

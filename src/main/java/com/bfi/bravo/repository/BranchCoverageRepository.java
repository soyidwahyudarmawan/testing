package com.bfi.bravo.repository;

import com.bfi.bravo.entity.BranchCoverage;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchCoverageRepository extends CrudRepository<BranchCoverage, Long> {
  public Optional<BranchCoverage> findByProvinceCodeAndCityCodeAndDistrictCodeAndSubdistrictCodeAndZipcode(
    String provinceCode,
    String cityCode,
    String districtCode,
    String subdistrictCode,
    String zipcode
  );
}

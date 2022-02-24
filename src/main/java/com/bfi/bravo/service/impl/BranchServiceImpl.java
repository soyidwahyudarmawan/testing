package com.bfi.bravo.service.impl;

import com.bfi.bravo.entity.Branch;
import com.bfi.bravo.entity.BranchCoverage;
import com.bfi.bravo.repository.BranchCoverageRepository;
import com.bfi.bravo.service.BranchService;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BranchServiceImpl implements BranchService {

  @Autowired
  private BranchCoverageRepository branchCoverageRepository;

  @Override
  public Optional<Branch> mapApplicationBranch(
    String provinceCode,
    String cityCode,
    String districtCode,
    String subdistrictCode,
    String zipcode
  ) {
    Optional<BranchCoverage> matchCoverage = branchCoverageRepository.findByProvinceCodeAndCityCodeAndDistrictCodeAndSubdistrictCodeAndZipcode(
      provinceCode,
      cityCode,
      districtCode,
      subdistrictCode,
      zipcode
    );

    return matchCoverage.isPresent() ? Optional.of(matchCoverage.get().getBranch()) : Optional.empty();
  }
}

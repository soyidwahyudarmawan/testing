package com.bfi.bravo.service;

import com.bfi.bravo.entity.Branch;
import java.util.Optional;

public interface BranchService {
  public Optional<Branch> mapApplicationBranch(
    String provinceCode,
    String cityCode,
    String districtCode,
    String subdistrictCode,
    String zipcode
  );
}

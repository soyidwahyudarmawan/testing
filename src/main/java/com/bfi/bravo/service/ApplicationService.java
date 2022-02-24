package com.bfi.bravo.service;

import com.bfi.bravo.dto.application.request.ApplicationCollateralByIdRequest;
import com.bfi.bravo.dto.application.request.ApplicationCreateRequest;
import com.bfi.bravo.dto.application.response.ApplicationCollateralResponse;
import com.bfi.bravo.dto.application.response.ApplicationCreateResponse;
import com.bfi.bravo.dto.application.response.ApplicationResponse;
import java.util.List;
import java.util.UUID;

public interface ApplicationService {
  public ApplicationCreateResponse create(ApplicationCreateRequest request);

  public List<ApplicationResponse> findAll();

  public ApplicationResponse findById(UUID id);

  public List<ApplicationCollateralResponse> findAllCollateral();

  public ApplicationCollateralResponse findByCollateralId(ApplicationCollateralByIdRequest idRequest);
}

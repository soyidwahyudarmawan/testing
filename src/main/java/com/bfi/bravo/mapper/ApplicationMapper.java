package com.bfi.bravo.mapper;

import com.bfi.bravo.dto.application.response.ApplicationApplicantResponse;
import com.bfi.bravo.dto.application.response.ApplicationCollateralResponse;
import com.bfi.bravo.entity.Applicant;
import com.bfi.bravo.entity.Collateral;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ApplicationMapper {

  private ModelMapper modelMapper;

  public ApplicationMapper() {
    modelMapper = new ModelMapper();
  }

  public ApplicationCollateralResponse convertToApplicationCollateralResponse(Collateral collateral) {
    return modelMapper.map(collateral, ApplicationCollateralResponse.class);
  }

  public ApplicationApplicantResponse convertToApplicationApplicantResponse(Applicant applicant) {
    return modelMapper.map(applicant, ApplicationApplicantResponse.class);
  }
}

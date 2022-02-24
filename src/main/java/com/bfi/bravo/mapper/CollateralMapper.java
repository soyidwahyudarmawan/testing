package com.bfi.bravo.mapper;

import com.bfi.bravo.dto.application.request.ApplicationCollateralRequest;
import com.bfi.bravo.entity.Collateral;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class CollateralMapper {

  private ModelMapper modelMapper;

  public CollateralMapper() {
    modelMapper = new ModelMapper();
    modelMapper.addMappings(
      new PropertyMap<ApplicationCollateralRequest, Collateral>() {
        @Override
        protected void configure() {
          skip().setId(null);
        }
      }
    );
  }

  public Collateral convert(ApplicationCollateralRequest applicationCollateralRequest) {
    return modelMapper.map(applicationCollateralRequest, Collateral.class);
  }
}

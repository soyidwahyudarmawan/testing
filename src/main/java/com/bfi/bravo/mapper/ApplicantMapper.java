package com.bfi.bravo.mapper;

import com.bfi.bravo.dto.application.request.ApplicationApplicantRequest;
import com.bfi.bravo.entity.Applicant;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class ApplicantMapper {

  private ModelMapper modelMapper;

  public ApplicantMapper() {
    modelMapper = new ModelMapper();
    modelMapper.addMappings(
      new PropertyMap<ApplicationApplicantRequest, Applicant>() {
        @Override
        protected void configure() {
          skip().setId(null);
        }
      }
    );
  }

  public Applicant convert(ApplicationApplicantRequest applicationApplicantRequest) {
    return modelMapper.map(applicationApplicantRequest, Applicant.class);
  }
}

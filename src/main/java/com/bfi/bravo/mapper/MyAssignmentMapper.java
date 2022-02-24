package com.bfi.bravo.mapper;

import com.bfi.bravo.dto.assignment.response.BranchResponse;
import com.bfi.bravo.entity.Branch;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MyAssignmentMapper
{
  private ModelMapper modelMapper;

  public BranchResponse convertToBranchResponse(Branch branch)
  {
    return modelMapper.map(branch, BranchResponse.class);
  }
}

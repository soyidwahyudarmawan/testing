package com.bfi.bravo.mapper;

import com.bfi.bravo.dto.operation.response.OperationAssignmentBranchResponse;
import com.bfi.bravo.entity.Branch;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OperationAssignmentMapper {
  private ModelMapper modelMapper;

  public OperationAssignmentBranchResponse convertToBranchResponse(Branch branch)
  {
    return modelMapper.map(branch, OperationAssignmentBranchResponse.class);
  }
}

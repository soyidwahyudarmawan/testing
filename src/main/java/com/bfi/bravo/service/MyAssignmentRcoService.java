package com.bfi.bravo.service;

import com.bfi.bravo.dto.assignment.response.MyAssignmentRcoResponse;
import java.util.List;

public interface MyAssignmentRcoService
{
  public List<MyAssignmentRcoResponse> findAll();
}

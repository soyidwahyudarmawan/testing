package com.bfi.bravo.service;

import com.bfi.bravo.dto.assignment.response.MyAssignmentCdpResponse;
import java.util.List;

public interface MyAssignmentCdpService
{
  public List<MyAssignmentCdpResponse> findAll();
}

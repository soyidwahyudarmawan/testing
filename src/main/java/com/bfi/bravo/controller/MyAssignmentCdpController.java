package com.bfi.bravo.controller;

import com.bfi.bravo.dto.assignment.response.MyAssignmentCdpResponse;
import com.bfi.bravo.service.MyAssignmentCdpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bfi.bravo.constant.AppConstants.DEFAULT_ACCESS_ROLE;

@RestController
@RequestMapping(value = "/v1/my_assignment/CDP")
@Tag(name = "My Assignment API", description = "CRUD application")
public class MyAssignmentCdpController
{
  @Autowired
  private MyAssignmentCdpService service;

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get all Data from role CDP", description = "Get all assignment from role CDP")
  @PreAuthorize("hasRole('ROLE_CDP') or " +DEFAULT_ACCESS_ROLE)
  public List<MyAssignmentCdpResponse> findAll()
  {
    return service.findAll();
  }
}

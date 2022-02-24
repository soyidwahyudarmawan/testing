package com.bfi.bravo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/applicant")
@Tag(name = "Applicant API", description = "CRUD applicant")
public class ApplicantController {}

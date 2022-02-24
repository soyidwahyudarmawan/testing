package com.bfi.bravo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/collateral")
@Tag(name = "Collateral API", description = "CRUD collateral")
public class CollateralController {}

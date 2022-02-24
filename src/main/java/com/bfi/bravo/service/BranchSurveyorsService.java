package com.bfi.bravo.service;

import com.bfi.bravo.dto.branch.workload.BranchSurveyorsWorkload;

public interface BranchSurveyorsService {
  public BranchSurveyorsWorkload getBranchSurveyorsWorkload(String branchKey);
}

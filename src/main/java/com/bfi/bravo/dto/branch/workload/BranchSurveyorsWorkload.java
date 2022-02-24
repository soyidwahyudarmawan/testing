package com.bfi.bravo.dto.branch.workload;

import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BranchSurveyorsWorkload {

  private String branchCode;
  private Map<String, Long> branchUserTasks;
}

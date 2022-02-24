package com.bfi.bravo.constant;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class WorkflowConstants {

  public static String APPLICATION_ID_VARIABLE_KEY = "applicationId";
  public static String APPLICATION_BRANCH_VARIABLE_KEY = "branch";
  public static String WORKFLOW_CREDIT_MODEL_APPROVAL = "creditModelApproval";
  public static String WORKFLOW_CREDIT_MODEL_PERSONA = "creditModelPersona";
  public static String WORKFLOW_STATUS_TO_BE_SET_KEY = "statusToBeSet";
  public static String WORKFLOW_SURVEY_ASSIGNEE = "surveyAssignee";

  public static Map<Long, String> PRODUCT_TO_WORKFLOW_MAP = Collections.unmodifiableMap(
    new HashMap<Long, String>() {
      {
        put(1L, "NDF4W_V1");
      }
    }
  );
}

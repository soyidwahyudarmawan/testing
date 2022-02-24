package com.bfi.bravo.dto.application.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApplicationCreateResponse {

  @JsonProperty("application_id")
  private UUID applicationId;

  @JsonProperty("application_number")
  private Long applicationNumber;

  @JsonProperty("process_id")
  private UUID processId;
}

package com.bfi.bravo.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("server")
public class CORSOriginConfig {

  private Cors cors;

  public Cors getCors() {
    return this.cors;
  }

  public void setCors(Cors cors) {
    this.cors = cors;
  }

  public static class Cors {

    private List<String> origins = new ArrayList<>();

    public List<String> getOrigins() {
      return this.origins;
    }

    public void setOrigins(List<String> origins) {
      this.origins = origins;
    }
  }
}

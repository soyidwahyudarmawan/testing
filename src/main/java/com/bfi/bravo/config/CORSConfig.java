package com.bfi.bravo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CORSConfig {

  @Autowired
  private CORSOriginConfig corsOriginConfig;

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurerAdapter() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        String[] origins = corsOriginConfig.getCors().getOrigins().toArray(String[]::new);

        registry
          .addMapping("/**")
          .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
          .allowedOrigins(origins)
          .allowedHeaders("*");
      }
    };
  }
}

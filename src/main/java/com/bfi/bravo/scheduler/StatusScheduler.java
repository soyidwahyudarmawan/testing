package com.bfi.bravo.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class StatusScheduler {
  private static final Logger log = LoggerFactory.getLogger(StatusScheduler.class);
  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  @Scheduled(cron = "59 23 13 * *")
  public void reportTime() {
//    log.info("Report time {}", dateFormat.format(new Date()));
    log.info("Report time is :: " + Calendar.getInstance().getTime());
  }
}

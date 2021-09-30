package com.mabsapps.spring5webapp.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimeLog {

	public static final Logger log = LoggerFactory.getLogger(Scheduled.class);
	public static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 5000)

	public void reportCurrentTime() {
		log.info("Current Time: {}", dateFormat.format(new Date()));
	}
}

package org.danielaguilar.demo.controller;

import java.time.ZonedDateTime;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
	private static final Logger logger = LogManager.getLogger();

	@GetMapping("/test")
	public ZonedDateTime test(HttpServletRequest request) {
		logger.info("Client IP: {}", request.getRemoteAddr());

		ZonedDateTime timestamp = ZonedDateTime.now();
		return timestamp;
	}
}

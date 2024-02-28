package com.olgasemenova.mirowidgets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"controller","service","model", "repository"})
public class MiroWidgetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiroWidgetsApplication.class, args);
	}

}

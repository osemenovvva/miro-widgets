package com.olgasemenova.mirowidgets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"controller","service","model", "repository"})
@ComponentScan
public class MiroWidgetsApplication {
	public static void main(String[] args) {
		SpringApplication.run(MiroWidgetsApplication.class, args);
	}
}

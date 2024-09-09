package com.qr.codeBase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackages={"com.qr.codeBase"})
public class CodeBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeBaseApplication.class, args);
	}

}

package com.learn.OneToOneUniMapping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OneToOneUniMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneUniMappingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (String srgs[]) {
		return runner -> {
			System.out.println("hrllow");
		};
	}
}

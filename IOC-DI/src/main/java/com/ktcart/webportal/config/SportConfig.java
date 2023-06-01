package com.ktcart.webportal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ktcart.webportal.interfaces.ICoach;
import com.ktcart.webportal.services.Golf;

@Configuration
public class SportConfig {

	@Bean("Golf") /* if we eliminate qualifier i.e "Golf" in this case, 
				   * our method name will work as the Bean ID*/
	public ICoach golfCoach() {
		System.out.println("---- golf bean creation ----");
		return new Golf();
	}
}

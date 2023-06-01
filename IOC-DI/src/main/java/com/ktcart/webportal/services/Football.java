package com.ktcart.webportal.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ktcart.webportal.interfaces.ICoach;

@Component
@Qualifier("Football")
@Lazy
/* @Scope(configurableBeanFactory.SCOPE_SINGLETON)*/
public class Football implements ICoach{
	
	Football (){
		showBean();
	}
	public void showBean() {
		System.out.println("------inside request----"+ getClass().getSimpleName());
	}
	@Override
	public String getCoachTip() {
		return "Warmup with Football.";
	}
	@Override
	public String getCoachInstructions() {
		return "20 x 50 meters sprints daily.";
	}
	@Override
	public String getCoachDetails() {
		return "Coach name is Xi Jhenga Ponga";
	}
}

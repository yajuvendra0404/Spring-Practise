package com.ktcart.webportal.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ktcart.webportal.interfaces.ICoach;

@Component
@Qualifier("Cricket")
@Lazy
/* @Scope(configurableBeanFactory.SCOPE_SINGLETON)*/

public class Cricket implements ICoach {
	Cricket (){
		showBean();
	}
	public void showBean() {
		System.out.println("------inside request----"+ getClass().getSimpleName());
	}
	@Override
	public String getCoachTip() {
		return "Upload 100 insta post per day.";
	}
	@Override
	public String getCoachInstructions() {
		return "20x5 fingre  Slaps to the guard at Wankhede.";
	}
	@Override
	public String getCoachDetails() {
		return "Thoda der ke liye waha GOTI MUH mai tha.";
	}
}

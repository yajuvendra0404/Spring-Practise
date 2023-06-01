package com.ktcart.webportal.services;

import com.ktcart.webportal.interfaces.ICoach;

public class Golf implements ICoach{

	public Golf (){
		showBean();
	}
	public void showBean() {
		System.out.println("------inside request----"+ getClass().getSimpleName());
	}
	@Override
	public String getCoachTip() {
		return "Rest With Golf Stick Under Shades.";
	}
	@Override
	public String getCoachInstructions() {
		return "Wear Good Clothes and Glasses.";
	}
	@Override
	public String getCoachDetails() {
		return "Coach name is Aaram Bapu";
	}
}

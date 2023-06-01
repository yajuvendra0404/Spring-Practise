package com.ktcart.webportal.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ktcart.webportal.interfaces.ICoach;

//import org.springframework.beans.factory.config.ConfigurableBeanFactory;

@Component /*any class that has '@component' annotation will be considered as a bean by the spring*/
@Qualifier("Hockey")
@Lazy

/* by default all the beans create by spring are "SINGLETON"
 * that means every class which want to use the bean will share the 
 * same instance of the bean. Different type of scope provided by 
 * are mentioned below.*/
/* @Scope(configurableBeanFactory.SCOPE_SINGLETON)*/

/* PROTOTYPE scope means every class which want to use the bean
 *  will have a different instance of the bean*/
/* @Scope(configurableBeanFactory.SCOPE_PROTOTYPE)*/
/* @Scope(configurableBeanFactory.SCOPE_SINGLETON)*/
/* @Scope(configurableBeanFactory.SCOPE_SINGLETON)*/
/* @Scope(configurableBeanFactory.SCOPE_SINGLETON)*/

public class Hockey implements ICoach{
	
	Hockey (){
		showBean();
	}
	
	public void showBean() {
		System.out.println(" ------ inside request ------ "+ getClass().getSimpleName());
	}
	
	@Override
	public String getCoachTip() {
		return "Practise with Hockey stick.";
	}
	
	@Override
	public String getCoachInstructions() {
		return "Run for an hour daily.";
	}
	
	@Override
	public String getCoachDetails() {
		return "Coach name is Raghu Ram Chota-Rajan";
	}
}

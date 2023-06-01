package com.Learn.crudOps.intApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CmdRunner implements CommandLineRunner{
	
	@Override
	public void run(String ...args) {
		System.out.println("---- hellow world ----");
	}
}

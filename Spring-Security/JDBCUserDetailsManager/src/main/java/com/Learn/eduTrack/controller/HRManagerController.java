package com.Learn.eduTrack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.Learn.eduTrack.service.HRManagerService;

@RestController
public class HRManagerController {
	
	private HRManagerService hrManagerService;
	
	@Autowired
	public HRManagerController ( HRManagerService hrManagerService) {
		this.hrManagerService = hrManagerService;
	}
	
	
}

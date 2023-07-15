package com.Learn.eduTrack.service;

import org.springframework.stereotype.Service;

import com.Learn.eduTrack.dao.hrManager.IHRManagerDAO;
import com.Learn.eduTrack.model.HRManagerModel;

import jakarta.servlet.http.HttpSession;

@Service
public class HRManagerService {
	private IHRManagerDAO hrManagerDAOimpl;
	public HRManagerService ( IHRManagerDAO hrManagerDAOimpl ) {
		this.hrManagerDAOimpl = hrManagerDAOimpl;
	}
	
	public HRManagerModel getHRManagerByEmail (String email, HttpSession session) {
		
		System.out.println("-- Service --"+ hrManagerDAOimpl.getHRManagerByEmail(email) );
		
		return null;
	}
	
}

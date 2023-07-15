package com.Learn.eduTrack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Learn.eduTrack.dao.hrManager.HRManagerEntity;
import com.Learn.eduTrack.dao.hrManager.IHRManagerDAO;
import com.Learn.eduTrack.dao.student.IStudentDAO;
import com.Learn.eduTrack.dao.teacher.ITeacherDAO;
import com.Learn.eduTrack.dao.teacher.TeacherEntity;
import com.Learn.eduTrack.model.AuthModel;
import com.Learn.eduTrack.model.HRManagerModel;
import com.Learn.eduTrack.model.StudentModel;
import com.Learn.eduTrack.model.TeacherModel;

import jakarta.servlet.http.HttpSession;

@Service
public class AuthService {
	
	
	private ITeacherDAO teacherDAOimpl;
	private IHRManagerDAO hrManagerDAOimpl;
	private IStudentDAO studentDAOimpl;
	@Autowired
	public AuthService ( 
			ITeacherDAO teacherDAOimpl,
			IHRManagerDAO hrManagerDAOimpl,
			IStudentDAO studentDAOimpl
	) {
		this.teacherDAOimpl = teacherDAOimpl;
		this.hrManagerDAOimpl = hrManagerDAOimpl;
	}
	
	public StudentModel isStudentAuthorized(AuthModel authCredentials) {
		
		return null;
	}
	
	public boolean isTeacherAuthorized(AuthModel authCredentials) {
		
		TeacherEntity teacherEntityData = teacherDAOimpl.getTeacherByEmail(authCredentials.getEmail());
		if(authCredentials.getPassword().equals(teacherEntityData.getPassword()) ) {
			return true;
		}
		return false;
		

	}
	
	public boolean isHrManagerAuthorized(AuthModel authCredentials) {
		HRManagerEntity hrManagerEntityData = hrManagerDAOimpl.getHRManagerByEmail(authCredentials.getEmail());
		if(authCredentials.getPassword().equals(hrManagerEntityData.getPassword()) ) {
			return true;
		}
		return false;
		
	}

}

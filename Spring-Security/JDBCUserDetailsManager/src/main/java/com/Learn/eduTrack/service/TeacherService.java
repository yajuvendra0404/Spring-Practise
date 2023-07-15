package com.Learn.eduTrack.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.Learn.eduTrack.dao.teacher.TeacherDAOImpl;
import com.Learn.eduTrack.model.TeacherModel;

@Service
public class TeacherService {

	private TeacherDAOImpl teacherDAOImpl;
	
	@Autowired
	public TeacherService (TeacherDAOImpl teacherDAOImpl) {
		this.teacherDAOImpl =teacherDAOImpl;
	}
	
	public int addTeacher(TeacherModel teacher) {
		
		return this.teacherDAOImpl.addTeacher(teacher);		
	}

}

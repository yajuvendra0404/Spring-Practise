package com.learn.RESTApi.Services;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.learn.RESTApi.DAOs.Teacher.ITeacherDAO;
import com.learn.RESTApi.Entities.TeacherEntity;
import com.learn.RESTApi.Models.Teacher;

@Service
@Qualifier("TeacherService")
public class TeacherService {
	
	private ITeacherDAO  teacherDAO;
	private Teacher teacherModel = new Teacher();
	@Autowired
	public TeacherService(
			@Qualifier("TeacherDAO") ITeacherDAO teacherDAOImpl
	) {
		this.teacherDAO = teacherDAOImpl;
	}

	public void addTeacher(String module, String firstName, String lastName, String email) {

		this.teacherModel.setFirstName(firstName);
		this.teacherModel.setLastName(lastName);
		this.teacherModel.setEmail(email);
		this.teacherModel.setModule(module);
		
		teacherDAO.save(this.teacherModel);
	}
	
	public List<Teacher> getAllTeacher() {

		List <Teacher> teacherData = new ArrayList<>();
		
		Iterator<TeacherEntity> itr = this.teacherDAO.getAllTeacher().iterator();
		
		while( itr.hasNext() ) {
			TeacherEntity rowData = itr.next();
			this.teacherModel.setEmail(rowData.getEmail());
			this.teacherModel.setFirstName(rowData.getFirstName());
			this.teacherModel.setLastName(rowData.getLastName());
			this.teacherModel.setModule(rowData.getModule());
			
			teacherData.add(this.teacherModel);
		}
		return  null;
	}
	
	public Teacher getTeacherById (int id) {
		return null;
	}
	
}

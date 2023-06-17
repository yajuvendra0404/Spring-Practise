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
	private TeacherEntity teacherEntity;
	private Teacher teacherModel;
	@Autowired
	public TeacherService(
			@Qualifier("TeacherDAO") ITeacherDAO teacherDAOImpl,
			@Qualifier("TeacherEntity") TeacherEntity teacherEntity, /* you should have create interface for this */
			@Qualifier("TeacherModel") Teacher teacherModel 		 /* TeacherEntity & TeacherModel for de-coupling. */
	) {
		this.teacherDAO = teacherDAOImpl;
		this.teacherEntity = teacherEntity; 
		this.teacherModel = teacherModel;
	}

	public void addTeacher(String module, String firstName, String lastName, String email) {

		this.teacherEntity.setFirstName(firstName);
		this.teacherEntity.setLastName(lastName);
		this.teacherEntity.setEmail(email);
		this.teacherEntity.setModule(module);
		
		teacherDAO.save(this.teacherEntity);
	}
	
	public List<Teacher> getAllTeacher() {
		
		List <TeacherEntity> teacherEntityData = this.teacherDAO.getAllTeacher();
		List <Teacher> teacherData = new ArrayList<>();
		
		Iterator<TeacherEntity> itr = teacherEntityData.iterator();
		
		while( itr.hasNext() ) {
			
			this.teacherModel.setEmail(itr.next().getEmail());
			this.teacherModel.setFirstName(itr.next().getFirstName());
			this.teacherModel.setLastName(itr.next().getLastName());
			this.teacherModel.setModule(itr.next().getModule());
			
			teacherData.add(this.teacherModel);
		}
		return  null;
	}
	
	public Teacher getTeacherById (int id) {
		return null;
	}
	
}

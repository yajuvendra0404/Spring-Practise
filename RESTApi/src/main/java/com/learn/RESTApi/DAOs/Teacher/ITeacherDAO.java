package com.learn.RESTApi.DAOs.Teacher;

import java.util.List;

import com.learn.RESTApi.Entities.TeacherEntity;


public interface ITeacherDAO {

	void save(TeacherEntity teacher);

	List<TeacherEntity> getAllTeacher();

	List<TeacherEntity> getTeacherById(int id);

}

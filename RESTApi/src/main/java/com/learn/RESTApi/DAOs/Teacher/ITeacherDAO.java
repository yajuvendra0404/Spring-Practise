package com.learn.RESTApi.DAOs.Teacher;

import java.util.List;

import com.learn.RESTApi.Entities.TeacherEntity;
import com.learn.RESTApi.Models.Teacher;


public interface ITeacherDAO {

	public void save(Teacher teacher);

	public List<TeacherEntity> getAllTeacher();

	public List<TeacherEntity> getTeacherById(int id);

}

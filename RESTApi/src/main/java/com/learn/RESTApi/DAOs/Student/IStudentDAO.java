package com.learn.RESTApi.DAOs.Student;

import java.util.List;

import com.learn.RESTApi.Entities.StudentEntity;
import com.learn.RESTApi.Models.Student;

public interface IStudentDAO {

	public List<StudentEntity> getStudentById(int id);

	public List<StudentEntity> getAllStudent();

	public void save(Student student);

}


package com.learn.RESTApi.DAOs.Student;

import java.util.List;

import com.learn.RESTApi.Entities.StudentEntity;
import com.learn.RESTApi.Models.Student;

public interface IStudentDAO {

	List<StudentEntity> getStudentById(int id);

	List<StudentEntity> getAllStudent();

	void save(StudentEntity student);

}

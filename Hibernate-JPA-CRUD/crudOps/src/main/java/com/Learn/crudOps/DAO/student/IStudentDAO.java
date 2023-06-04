package com.Learn.crudOps.DAO.student;

import java.util.List;

import com.Learn.crudOps.Entity.Student;
import com.Learn.crudOps.enums.SortBy;

public interface IStudentDAO {
	public void save(Student student);
	public Student findById(int id);
	public List<Student> findAll (SortBy sortBy);
	public List<Student> findByLastName(String lastName); 
}

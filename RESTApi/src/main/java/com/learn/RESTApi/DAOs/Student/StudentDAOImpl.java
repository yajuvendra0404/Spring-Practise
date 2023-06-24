package com.learn.RESTApi.DAOs.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.learn.RESTApi.CustomExceptions.StudentNotFoundException;
import com.learn.RESTApi.Entities.StudentEntity;
import com.learn.RESTApi.Models.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Qualifier("StudentDAO")
public class StudentDAOImpl implements IStudentDAO {
	private EntityManager entityManager;
	
	@Autowired
	public StudentDAOImpl(EntityManager entitymanager) {
		this.entityManager = entitymanager;
	}
	
	@Override
	@Transactional
	public void save(Student student) {
		StudentEntity studentEntity = new  StudentEntity(student.getFirstName(),student.getLastName(), student.getEmail(), student.getMarks());
		entityManager.persist(studentEntity);
	}
	
	@Override
	public List<StudentEntity> getAllStudent() {
		String queryString = "FROM StudentEntity";
		TypedQuery<StudentEntity> query = entityManager.createQuery(queryString,StudentEntity.class);
		return query.getResultList();
	}
	
	@Override
	public List<StudentEntity> getStudentById(int id) {
		String queryString= "FROM StudentEntity where id=:param";
		TypedQuery<StudentEntity> query = entityManager.createQuery(queryString, StudentEntity.class);
		query.setParameter("param", id);
		List<StudentEntity> resultset = query.getResultList();
		
		if(resultset.isEmpty()) throw new StudentNotFoundException("Student Data Not Found");
		
		return resultset;	
	}
	
}

package com.Learn.crudOps.DAO.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Learn.crudOps.Entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements IStudentDAO{
	
	private EntityManager entityManager;

	@Autowired				
	public StudentDAOImpl (EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);	
	}
	
	@Override
	public Student findById(int id) {
		return entityManager.find(Student.class, id);
	}
	
}

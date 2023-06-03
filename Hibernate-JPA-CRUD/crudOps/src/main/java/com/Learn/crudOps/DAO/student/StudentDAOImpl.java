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
		System.out.println("-------Persisting Data -----");
//		entityManager.getTransaction().begin();
		entityManager.persist(student);
//		entityManager.getTransaction().commit();
		
	}
}

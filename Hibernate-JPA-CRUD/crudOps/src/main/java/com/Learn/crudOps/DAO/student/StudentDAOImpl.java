package com.Learn.crudOps.DAO.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Learn.crudOps.Entity.Student;
import com.Learn.crudOps.enums.SortBy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
	
	@Override
	public List<Student> findAll(SortBy sortBy) {// String sortBy
		TypedQuery<Student> query; 
		switch (sortBy) {
			case FIRSTNAME:
				System.out.println("------sorting by FIRSTNAME --------");
				query = entityManager.createQuery("FROM Student order by firstName", Student.class); 
				return query.getResultList();
			case LASTNAME:
				System.out.println("------sorting by LASTNAME --------");
				query = entityManager.createQuery("FROM Student order by lastName", Student.class); 
				return query.getResultList();
			case EMAILID:
				System.out.println("------sorting by EMAILID --------");
				query = entityManager.createQuery("FROM Student order by email", Student.class); 
				return query.getResultList();
			default: return null;	
		}

	}
	
	public List<Student> findByLastName (String lastName) {
//		String queryString = "FROM Student Where lastName=:param";
		String queryString = "FROM Student s Where s.lastName LIKE:param";
		TypedQuery<Student> query = entityManager.createQuery(queryString,Student.class);
		query.setParameter("param", "%"+lastName+"%");
		return query.getResultList();
	}
}

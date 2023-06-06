package com.Learn.crudOps.DAO.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Learn.crudOps.Entity.Student;
import com.Learn.crudOps.enums.SortBy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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
	public List<Student> findAll(SortBy sortBy) {
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
	
	@Override
	public List<Student> findByLastName (String lastName) {
//		String queryString = "FROM Student Where lastName=:param";
		String queryString = "FROM Student s Where s.lastName LIKE:param";
		TypedQuery<Student> query = entityManager.createQuery(queryString,Student.class);
		query.setParameter("param", "%"+lastName+"%");
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public boolean update(Student student) {
		entityManager.merge(student);
		return false;
	}

	@Override
	@Transactional
	public boolean delete(int id) {
		/* Delete student using "entityManager.remove(Object o)." */
		
//		Student student = entityManager.find(Student.class, id);
//		entityManager.remove(student);	
//		return false;
		
		/* Delete student using "TypedQuery." 
		 * You cannot use "TypedQuery" interface for non-select query like "UPDATE and DELETE",
		 * for that you have to use Query interface of JPA  */
		
		Query query = entityManager.createQuery("DELETE FROM Student where id=:param");
		query.setParameter("param",id);
		int numRowAffected = query.executeUpdate();
		System.out.println("---updated row number---"+ numRowAffected);
		
		return false;
	}
}

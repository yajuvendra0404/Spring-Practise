package com.learn.RESTApi.DAOs.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.learn.RESTApi.Entities.StudentEntity;

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
	public void save(StudentEntity student) {
		entityManager.persist(student);
	}
	
	@Override
	public List<StudentEntity> getAllStudent() {
		String queryString = "FROM Student";
		TypedQuery<StudentEntity> query = entityManager.createQuery(queryString,StudentEntity.class);
		return query.getResultList();
	}
	
	@Override
	public List<StudentEntity> getStudentById(int id) {
		String queryString= "FROM Student where id=:param";
		TypedQuery<StudentEntity> query = entityManager.createQuery(queryString, StudentEntity.class);
		query.setParameter("param", id);
		return query.getResultList();	
	}
	
}

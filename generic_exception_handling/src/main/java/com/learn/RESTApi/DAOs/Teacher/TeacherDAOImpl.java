package com.learn.RESTApi.DAOs.Teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.learn.RESTApi.Entities.TeacherEntity;
import com.learn.RESTApi.Models.Teacher;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Qualifier("TeacherDAO")
public class TeacherDAOImpl implements ITeacherDAO {

	private EntityManager entityManager;
	
	public TeacherDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public void save(Teacher teacher) {
		TeacherEntity teacherEntity = new TeacherEntity(teacher.getFirstName(), teacher.getLastName(), teacher.getEmail(), teacher.getModule());
		entityManager.persist(teacherEntity);
	}
	
//	String firstName, String lastName, String email, String module
	
	@Override
	public List<TeacherEntity> getAllTeacher() {
		String queryString = "FROM TeacherEntity";
		TypedQuery<TeacherEntity> query = entityManager.createQuery(queryString, TeacherEntity.class);
		return query.getResultList();
	}
	
	@Override
	public List<TeacherEntity> getTeacherById (int id) {
		String queryString = "FROM TeacherEntity where id=:param";
		TypedQuery<TeacherEntity> query= entityManager.createQuery(queryString,TeacherEntity.class);
		query.setParameter("param", id);
		return query.getResultList();
	}
	
}

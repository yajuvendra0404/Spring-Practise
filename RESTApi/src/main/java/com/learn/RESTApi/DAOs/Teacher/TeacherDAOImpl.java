package com.learn.RESTApi.DAOs.Teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.learn.RESTApi.Entities.TeacherEntity;

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
	public void save(TeacherEntity teacher) {
		entityManager.persist(teacher);
	}
	
	@Override
	public List<TeacherEntity> getAllTeacher() {
		String queryString = "FROM Teacher";
		TypedQuery<TeacherEntity> query = entityManager.createQuery(queryString, TeacherEntity.class);
		return query.getResultList();
	}
	
	@Override
	public List<TeacherEntity> getTeacherById (int id) {
		String queryString = "FROM Teacher where id=:param";
		TypedQuery<TeacherEntity> query= entityManager.createQuery(queryString,TeacherEntity.class);
		query.setParameter("param", id);
		return query.getResultList();
	}
	
}

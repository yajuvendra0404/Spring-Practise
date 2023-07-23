package com.learn.OneToOneUniMapping.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.OneToOneUniMapping.Entity.Instructor;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImpl implements IAppDAO {
	
	private EntityManager entityManager;

	@Autowired
	public AppDAOImpl (EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public void save(Instructor instructor) {
		entityManager.persist(instructor);
	}	
}

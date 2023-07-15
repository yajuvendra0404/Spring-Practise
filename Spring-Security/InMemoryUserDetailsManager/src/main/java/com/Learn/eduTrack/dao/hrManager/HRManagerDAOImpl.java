package com.Learn.eduTrack.dao.hrManager;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.Learn.eduTrack.model.HRManagerModel;

@Repository
public class HRManagerDAOImpl implements IHRManagerDAO{

	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public HRManagerDAOImpl (JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate =jdbcTemplate;
	}
	
	@Override
	public HRManagerEntity getHRManagerByEmail(String email) {
		
		Object[] args= {email};
		String query = "select * from hr_manager where email=? ";
		return jdbcTemplate.queryForObject(query, new RowMapper<HRManagerEntity>() {

			@Override
			public HRManagerEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				HRManagerEntity entity = new HRManagerEntity();
				
				entity.setAddress(rs.getString("address"));
				entity.setCompany(rs.getString("company"));
				entity.setEmail(rs.getString("email"));
				entity.setName(rs.getString("name"));
				entity.setPassword(rs.getString("password"));
				entity.setPhoneNumber(rs.getString("phone_number"));

				return entity;
				
			}
			
		}, args);
		
	}
	
}

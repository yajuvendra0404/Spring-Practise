package com.Learn.eduTrack.dao.teacher;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.Learn.eduTrack.dao.hrManager.HRManagerEntity;
import com.Learn.eduTrack.model.TeacherModel;
import com.Learn.eduTrack.utils.EmailSender;

@Repository
public class TeacherDAOImpl implements ITeacherDAO{
	private JdbcTemplate jdbcTemplate;
	private EmailSender emailSender;

	@Autowired
	public TeacherDAOImpl (
			JdbcTemplate jdbcTemplate,
			EmailSender emailSender ) {
		this.jdbcTemplate =jdbcTemplate;
		this.emailSender= emailSender;
	}
	
	@Override
	public TeacherEntity getTeacherByEmail(String email) {
		// TODO Auto-generated method stub
		Object[] args= {email};
		String query = "select * from teacher where email=? ";
		return jdbcTemplate.queryForObject(query, new RowMapper<TeacherEntity>() {

			@Override
			public TeacherEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				TeacherEntity entity = new TeacherEntity();
				
				entity.setAddress(rs.getString("address"));
				entity.setEmail(rs.getString("email"));
				entity.setName(rs.getString("name"));
				entity.setPassword(rs.getString("password"));
				entity.setQualification(rs.getString("qualification"));

				return entity;
				
			}
			
		}, args);
	}
	

	@Override
	public int addTeacher(TeacherModel teacher) {
		int tempPass = (int) (Math.random() * ( 100000-10000+1 )+ 10000);
		Object[] args = {
					teacher.getName(),
					teacher.getEmail(),
					tempPass,
					teacher.getQualification(),
					teacher.getDepartment(),
					teacher.getAddress(),
					teacher.getPhone(),
					teacher.getAge()
				};
		String query = "insert into teacher ( name,email,password,qualification,department,address,phone,age ) values(?,?,?,?,?,?,?,?)";
		int result = this.jdbcTemplate.update(query, args);
		if( result != 0 ) {
			this.emailSender.sendSimpleMessage(teacher.getEmail(), tempPass);
		}
		return result;
	}

}

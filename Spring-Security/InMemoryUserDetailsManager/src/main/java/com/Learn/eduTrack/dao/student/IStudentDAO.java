package com.Learn.eduTrack.dao.student;

import com.Learn.eduTrack.model.StudentModel;

public interface IStudentDAO {

	public StudentModel getStudentByEmail(String email);
}

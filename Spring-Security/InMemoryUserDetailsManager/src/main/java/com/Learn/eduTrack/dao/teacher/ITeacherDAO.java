package com.Learn.eduTrack.dao.teacher;

import com.Learn.eduTrack.model.TeacherModel;

public interface ITeacherDAO {
	
	public TeacherEntity getTeacherByEmail(String email);
	public int addTeacher(TeacherModel teacherModel);
	
}

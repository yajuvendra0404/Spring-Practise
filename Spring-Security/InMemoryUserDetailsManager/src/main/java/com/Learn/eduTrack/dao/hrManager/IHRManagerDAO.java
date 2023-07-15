package com.Learn.eduTrack.dao.hrManager;

import com.Learn.eduTrack.model.HRManagerModel;

public interface IHRManagerDAO {
	
	public HRManagerEntity getHRManagerByEmail(String email);
	
}

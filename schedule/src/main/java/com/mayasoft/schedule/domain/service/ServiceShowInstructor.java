package com.mayasoft.schedule.domain.service;

import java.util.List;

import com.mayasoft.schedule.domain.adapter.dao.DaoInstructorMySql;
import com.mayasoft.schedule.domain.model.dto.Instructor;

public class ServiceShowInstructor {
	
	private final DaoInstructorMySql daoInstructorMySql;
	
	public ServiceShowInstructor(DaoInstructorMySql daoInstructorMySql) {
		this.daoInstructorMySql = daoInstructorMySql;
	}
	
	public List<Instructor> obtainAllInstructor(){
		return daoInstructorMySql.listAllInstructor();
	}
	
	public Instructor obtainById(Long id) {
		return daoInstructorMySql.obtainById(id);
	}
}

package com.mayasoft.schedule.domain.adapter.dao;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.mayasoft.schedule.domain.model.dto.Instructor;
import com.mayasoft.schedule.infraestructure.adapter.repository.entity.InstructorEntity;
import com.mayasoft.schedule.infraestructure.jpa.RepositoryInstructorJPA;

@Repository
public class DaoInstructorMySql {
	
	private final RepositoryInstructorJPA repositoryInstructorJPA;
    private ModelMapper modelMapper = new ModelMapper();
    
	public DaoInstructorMySql(RepositoryInstructorJPA repositoryInstructorJPA) {
		this.repositoryInstructorJPA = repositoryInstructorJPA;
	}

	public List<Instructor> listAllInstructor(){
		List<Instructor> instructors = new ArrayList<>();
		List<InstructorEntity> entitys = repositoryInstructorJPA.findAll();
		for(InstructorEntity entity : entitys) {
			Instructor instructor = modelMapper.map(entity, Instructor.class);
			instructors.add(instructor);
		}
		return instructors;
	}
	
	public Instructor obtainById(Long id) {
		InstructorEntity instructorEntity = repositoryInstructorJPA.getInstructorById(Long.valueOf(id));
		if(null != instructorEntity) {
			return modelMapper.map(instructorEntity, Instructor.class);
		}
		return new Instructor();
	}
}
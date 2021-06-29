package com.mayasoft.schedule.domain.adapter.repository;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.mayasoft.schedule.domain.model.dto.Event;
import com.mayasoft.schedule.infraestructure.adapter.repository.entity.EventEntity;
import com.mayasoft.schedule.infraestructure.adapter.repository.entity.InstructorEntity;
import com.mayasoft.schedule.infraestructure.jpa.RepositoryEventJPA;

@Repository
public class RepositoryEventMySql {
	
	private final RepositoryEventJPA repositoryEventJPA;
    private ModelMapper modelMapper = new ModelMapper();
    
	public RepositoryEventMySql(RepositoryEventJPA repositoryEventJPA) {
		this.repositoryEventJPA = repositoryEventJPA;
	}

	public void insert(Event event) {
		EventEntity eventEntity = modelMapper.map(event, EventEntity.class);
		InstructorEntity instructorEntity = modelMapper.map(event.getInstructor(), InstructorEntity.class);
		eventEntity.setInstructorEntity(instructorEntity);
		repositoryEventJPA.save(eventEntity);
	}
	
	public void update(Event event) {
		EventEntity eventEntity = modelMapper.map(event, EventEntity.class);
		InstructorEntity instructorEntity = modelMapper.map(event.getInstructor(), InstructorEntity.class);
		eventEntity.setInstructorEntity(instructorEntity);
		repositoryEventJPA.update(eventEntity.getDescription(), eventEntity.getType(),
				eventEntity.getStart(), eventEntity.getEnd(), eventEntity.getDurationDays(),
				eventEntity.getIdEvent());
	}
	
	public void delete(Event event) {
		EventEntity entityEntity = modelMapper.map(event, EventEntity.class);
		InstructorEntity instructorEntity = modelMapper.map(event.getInstructor(), InstructorEntity.class);
		entityEntity.setInstructorEntity(instructorEntity);
		repositoryEventJPA.delete(entityEntity);
	}
}
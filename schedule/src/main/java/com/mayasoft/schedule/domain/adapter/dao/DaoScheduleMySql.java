package com.mayasoft.schedule.domain.adapter.dao;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.mayasoft.schedule.domain.model.dto.Event;
import com.mayasoft.schedule.infraestructure.adapter.repository.entity.EventEntity;
import com.mayasoft.schedule.infraestructure.jpa.RepositoryEventJPA;

@Repository
public class DaoScheduleMySql {
	
	private final RepositoryEventJPA repositoryEventJPA;
    private ModelMapper modelMapper = new ModelMapper();

	public DaoScheduleMySql(RepositoryEventJPA repositoryEventJPA) {
		this.repositoryEventJPA = repositoryEventJPA;
	}

	public List<Event> listAllEvents(Long id){
		List<Event> events = new ArrayList<>();
		List<EventEntity> entitys = repositoryEventJPA.findEventsByIdInstructor(id);
		for(EventEntity entity : entitys) {
			Event event = modelMapper.map(entity, Event.class);
			events.add(event);
		}		
		return events;
	}
}
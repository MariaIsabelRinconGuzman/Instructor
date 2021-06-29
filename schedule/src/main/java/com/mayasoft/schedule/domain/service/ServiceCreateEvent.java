package com.mayasoft.schedule.domain.service;

import com.mayasoft.schedule.domain.adapter.repository.RepositoryEventMySql;
import com.mayasoft.schedule.domain.model.dto.Event;

public class ServiceCreateEvent {
	
	private final RepositoryEventMySql repositoryEventMySql;
	
	public ServiceCreateEvent(RepositoryEventMySql repositoryEventMySql) {
		this.repositoryEventMySql = repositoryEventMySql;
	}

	public void insert(Event event) {
		repositoryEventMySql.insert(event);		
	}
}

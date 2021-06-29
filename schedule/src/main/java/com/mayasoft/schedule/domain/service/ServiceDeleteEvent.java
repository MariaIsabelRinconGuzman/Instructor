package com.mayasoft.schedule.domain.service;

import com.mayasoft.schedule.domain.adapter.repository.RepositoryEventMySql;
import com.mayasoft.schedule.domain.model.dto.Event;

public class ServiceDeleteEvent {
	
	private final RepositoryEventMySql repositoryEventMySql;

	public ServiceDeleteEvent(RepositoryEventMySql repositoryEventMySql) {
		this.repositoryEventMySql = repositoryEventMySql;
	}

	public void delete(Event event) {
		repositoryEventMySql.delete(event);
	}
}

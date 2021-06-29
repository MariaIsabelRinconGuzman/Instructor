package com.mayasoft.schedule.domain.service;

import com.mayasoft.schedule.domain.adapter.repository.RepositoryEventMySql;
import com.mayasoft.schedule.domain.model.dto.Event;

public class ServiceEditEvent {
	
	private final RepositoryEventMySql repositoryEventMySql;

	public ServiceEditEvent(RepositoryEventMySql repositoryEventMySql) {
		this.repositoryEventMySql = repositoryEventMySql;
	}
	
	public void edit(Event event) {
		repositoryEventMySql.update(event);
	}
}

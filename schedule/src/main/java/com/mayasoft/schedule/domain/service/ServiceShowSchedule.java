package com.mayasoft.schedule.domain.service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.mayasoft.schedule.domain.adapter.dao.DaoScheduleMySql;
import com.mayasoft.schedule.domain.model.dto.Event;

public class ServiceShowSchedule {
	
	private final DaoScheduleMySql daoScheduleMySql;

	public ServiceShowSchedule(DaoScheduleMySql daoScheduleMySql) {
		this.daoScheduleMySql = daoScheduleMySql;
	}
	
	public List<Event> obtain(Long id){
		List<Event> events = daoScheduleMySql.listAllEvents(id);
		if(events.size() == 0) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "There are no events for this instructor");
		}
		int currentMonthValue = LocalDate.now().getMonthValue();
		events
		.stream()
		.filter(event -> event.getStart().getMonthValue() == currentMonthValue|| 
				event.getEnd().getMonthValue() == currentMonthValue)
		.collect(Collectors.toList());		
		return events;
	}
}

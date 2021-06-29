package com.mayasoft.schedule.application.comand.factory;

import org.springframework.stereotype.Component;

import com.mayasoft.schedule.application.comand.ComandEvent;
import com.mayasoft.schedule.domain.model.dto.Event;

@Component
public class FactoryEvent {

	public Event create(ComandEvent comandEvent) {
		return new Event(comandEvent.getIdEvent(), comandEvent.getType(), comandEvent.getDescription(), comandEvent.getStart(),
				comandEvent.getEnd(), comandEvent.getDurationDays(), comandEvent.getInstructor());
	}
}

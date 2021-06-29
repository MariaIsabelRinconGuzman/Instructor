package com.mayasoft.schedule.application.comand.handler;

import org.springframework.stereotype.Component;

import com.mayasoft.schedule.application.comand.ComandEvent;
import com.mayasoft.schedule.application.comand.factory.FactoryEvent;
import com.mayasoft.schedule.domain.model.dto.Event;
import com.mayasoft.schedule.domain.service.ServiceDeleteEvent;

@Component
public class HandlerDeleteEvent {

	private ServiceDeleteEvent serviceDeleteEvent;	
	private FactoryEvent factoryEvent;

	public HandlerDeleteEvent(ServiceDeleteEvent serviceDeleteEvent, FactoryEvent factoryEvent) {
		this.serviceDeleteEvent = serviceDeleteEvent;
		this.factoryEvent = factoryEvent;
	}

	public void run(ComandEvent comandEvent){
		Event event = factoryEvent.create(comandEvent);
		serviceDeleteEvent.delete(event);
	}
}

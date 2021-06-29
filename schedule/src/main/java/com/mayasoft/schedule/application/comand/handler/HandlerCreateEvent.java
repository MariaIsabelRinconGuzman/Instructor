package com.mayasoft.schedule.application.comand.handler;

import org.springframework.stereotype.Component;

import com.mayasoft.schedule.application.comand.ComandEvent;
import com.mayasoft.schedule.application.comand.factory.FactoryEvent;
import com.mayasoft.schedule.domain.model.dto.Event;
import com.mayasoft.schedule.domain.service.ServiceCreateEvent;

@Component
public class HandlerCreateEvent {

	private ServiceCreateEvent serviceCreateEvent;	
	private FactoryEvent factoryEvent;

	public HandlerCreateEvent(ServiceCreateEvent serviceCreateEvent, FactoryEvent factoryEvent) {
		this.serviceCreateEvent = serviceCreateEvent;
		this.factoryEvent = factoryEvent;
	}

	public void run(ComandEvent comandEvent){
		Event event = factoryEvent.create(comandEvent);
		serviceCreateEvent.insert(event);
	}
}

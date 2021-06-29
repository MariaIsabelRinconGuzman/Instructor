package com.mayasoft.schedule.application.comand.handler;

import org.springframework.stereotype.Component;

import com.mayasoft.schedule.application.comand.ComandEvent;
import com.mayasoft.schedule.application.comand.factory.FactoryEvent;
import com.mayasoft.schedule.domain.model.dto.Event;
import com.mayasoft.schedule.domain.service.ServiceEditEvent;

@Component
public class HandlerEditEvent {

	private ServiceEditEvent serviceEditEvent;
	private FactoryEvent factoryEvent;
	
	public HandlerEditEvent(ServiceEditEvent serviceEditEvent, FactoryEvent factoryEvent) {
		this.serviceEditEvent = serviceEditEvent;
		this.factoryEvent = factoryEvent;
	}

	public void run(ComandEvent comandEvent){
		Event event = factoryEvent.create(comandEvent);
		serviceEditEvent.edit(event);
	}
}

package com.mayasoft.schedule.application.comand.handler;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mayasoft.schedule.domain.model.dto.Event;
import com.mayasoft.schedule.domain.service.ServiceShowSchedule;

@Component
public class HandlerShowSchedule {

	private ServiceShowSchedule serviceShowSchedule; 	

	public HandlerShowSchedule(ServiceShowSchedule serviceShowSchedule) {
		this.serviceShowSchedule = serviceShowSchedule;
	}

	public List<Event> run(Long id){
		return serviceShowSchedule.obtain(id);
	}
}

package com.mayasoft.schedule.application.comand.handler;

import org.springframework.stereotype.Component;

import com.mayasoft.schedule.domain.model.dto.Instructor;
import com.mayasoft.schedule.domain.service.ServiceShowInstructor;

@Component
public class HandlerShowInstructor {

	private ServiceShowInstructor serviceShowInstructor;
	
	public HandlerShowInstructor(ServiceShowInstructor serviceShowInstructor) {
		this.serviceShowInstructor = serviceShowInstructor;
	}

	public Instructor run(Long id){
		return serviceShowInstructor.obtainById(id);
	}
}

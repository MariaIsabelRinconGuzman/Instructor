package com.mayasoft.schedule.application.comand.handler;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mayasoft.schedule.domain.model.dto.Instructor;
import com.mayasoft.schedule.domain.service.ServiceShowInstructor;

@Component
public class HandlerShowAllInstructor {

	private ServiceShowInstructor serviceShowInstructor;
	
	public HandlerShowAllInstructor(ServiceShowInstructor serviceShowInstructor) {
		this.serviceShowInstructor = serviceShowInstructor;
	}

	public List<Instructor> run(){
		return serviceShowInstructor.obtainAllInstructor();
	}
}

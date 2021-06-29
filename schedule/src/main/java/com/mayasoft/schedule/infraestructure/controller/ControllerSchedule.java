package com.mayasoft.schedule.infraestructure.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mayasoft.schedule.application.comand.handler.HandlerShowSchedule;
import com.mayasoft.schedule.domain.model.dto.Event;

@RestController
@RequestMapping(value = "/schedule")
public class ControllerSchedule {
	private final HandlerShowSchedule handlerShowSchedule;

	public ControllerSchedule(HandlerShowSchedule handlerShowSchedule) {
		this.handlerShowSchedule = handlerShowSchedule;
	}

	@CrossOrigin()
	@GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Event> showEventsByIdInstructor(@PathVariable Long id){
        return handlerShowSchedule.run(id);
    }
}

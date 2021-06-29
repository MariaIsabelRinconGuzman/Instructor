package com.mayasoft.schedule.infraestructure.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mayasoft.schedule.application.comand.handler.HandlerShowAllInstructor;
import com.mayasoft.schedule.application.comand.handler.HandlerShowInstructor;
import com.mayasoft.schedule.domain.model.dto.Instructor;

@RestController
@RequestMapping(value = "/instructor")
public class ControllerInstructor {
	private final HandlerShowInstructor handlerShowInstructor;
	private final HandlerShowAllInstructor handlerShowAllInstructor;

	public ControllerInstructor(HandlerShowInstructor handlerShowInstructor,
			HandlerShowAllInstructor handlerShowAllInstructor) {
		this.handlerShowInstructor = handlerShowInstructor;
		this.handlerShowAllInstructor = handlerShowAllInstructor;
	}

	@GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Instructor showInstructorById(@PathVariable Long id){
        return handlerShowInstructor.run(id);
    }
	
	@CrossOrigin()
	@GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Instructor> showInstructor(){
        return handlerShowAllInstructor.run();
    }
}

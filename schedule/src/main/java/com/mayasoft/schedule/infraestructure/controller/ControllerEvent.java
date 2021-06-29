package com.mayasoft.schedule.infraestructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.mayasoft.schedule.application.comand.ComandEvent;
import com.mayasoft.schedule.application.comand.handler.*;

@RestController
@RequestMapping(value = "/event")
public class ControllerEvent {
	private final HandlerCreateEvent handlerCreateEvent;
	private final HandlerEditEvent handlerEditEvent;
	private final HandlerDeleteEvent handlerDeleteEvent;

	public ControllerEvent(HandlerCreateEvent handlerCreateEvent, HandlerEditEvent handlerEditEvent,
			HandlerDeleteEvent handlerDeleteEvent) {
		super();
		this.handlerCreateEvent = handlerCreateEvent;
		this.handlerEditEvent = handlerEditEvent;
		this.handlerDeleteEvent = handlerDeleteEvent;
	}

	@CrossOrigin()
	@PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createEvent(@RequestBody ComandEvent comandEvent){
        this.handlerCreateEvent.run(comandEvent);
    }
	
	@CrossOrigin()
	@PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void editEvent(@RequestBody ComandEvent comandEvent){
        this.handlerEditEvent.run(comandEvent);
    }
	
	@CrossOrigin()
	@DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteEvent(@RequestBody ComandEvent comandEvent){
        this.handlerDeleteEvent.run(comandEvent);
    }
}

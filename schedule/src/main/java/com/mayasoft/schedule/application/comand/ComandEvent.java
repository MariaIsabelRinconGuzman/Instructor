package com.mayasoft.schedule.application.comand;

import java.time.LocalDate;

import com.mayasoft.schedule.domain.model.dto.Instructor;

public class ComandEvent {

	private Long idEvent;
	private String type;
	private String description;
	private LocalDate start;
	private LocalDate end;
	private int durationDays;
	private Instructor instructor;
	
	public ComandEvent() {
	}

	public ComandEvent(String type, String description, LocalDate start, LocalDate end, int durationDays, Instructor instructor) {
		this.type = type;
		this.description = description;
		this.start = start;
		this.end = end;
		this.durationDays = durationDays;
		this.instructor = instructor;
	}
	

	public ComandEvent(Long idEvent, String type, String description, LocalDate start, LocalDate end, int durationDays,
			Instructor instructor) {
		this.idEvent = idEvent;
		this.type = type;
		this.description = description;
		this.start = start;
		this.end = end;
		this.durationDays = durationDays;
		this.instructor = instructor;
	}
	
	

	public Long getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(Long idEvent) {
		this.idEvent = idEvent;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}

	public int getDurationDays() {
		return durationDays;
	}

	public void setDurationDays(int durationDays) {
		this.durationDays = durationDays;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
}

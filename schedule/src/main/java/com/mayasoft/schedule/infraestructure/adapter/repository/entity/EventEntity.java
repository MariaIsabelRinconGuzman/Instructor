package com.mayasoft.schedule.infraestructure.adapter.repository.entity;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "event")
public class EventEntity {
	@Id
    @GeneratedValue
    private Long idEvent;
	@Column
	private String description;
	@Column
    private char type; 
	@Column
	private LocalDate start;
	@Column
	private LocalDate end;
	@Column
	private int durationDays;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idInstructor")
	private InstructorEntity instructorEntity;
	
	public EventEntity() {
	}
	public EventEntity(Long idEvent, String description, char type, LocalDate start, LocalDate end, int durationDays,
			InstructorEntity instructorEntity) {
		this.idEvent = idEvent;
		this.description = description;
		this.type = type;
		this.start = start;
		this.end = end;
		this.durationDays = durationDays;
		this.instructorEntity = instructorEntity;
	}
	public Long getIdEvent() {
		return idEvent;
	}
	public void setIdEvent(Long idEvent) {
		this.idEvent = idEvent;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
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
	public InstructorEntity getInstructorEntity() {
		return instructorEntity;
	}
	public void setInstructorEntity(InstructorEntity instructorEntity) {
		this.instructorEntity = instructorEntity;
	}
 }

package com.mayasoft.schedule.domain.model.dto;

import java.time.LocalDate;

public class Instructor {
	
	private Long idInstructor;
	private String name;
	private String surname;
	private LocalDate birth;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public LocalDate getBirth() {
		return birth;
	}
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
	public Long getIdInstructor() {
		return idInstructor;
	}
	public void setIdInstructor(Long idInstructor) {
		this.idInstructor = idInstructor;
	}
	public Instructor() {
	}
	public Instructor(Long idInstructor, String name, String surname, LocalDate birth) {
		this.idInstructor = idInstructor;
		this.name = name;
		this.surname = surname;
		this.birth = birth;
	}
}

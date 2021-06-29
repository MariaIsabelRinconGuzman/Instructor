package com.mayasoft.schedule.infraestructure.adapter.repository.entity;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "instructor")
public class InstructorEntity {
	@Id
	@Column
    private Long idInstructor;
	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private LocalDate birth;
	
	public InstructorEntity() {
	}

	public InstructorEntity(Long idInstructor, String name, String surname, LocalDate birth) {
		this.idInstructor = idInstructor;
		this.name = name;
		this.surname = surname;
		this.birth = birth;
	}

	

	public Long getIdInstructor() {
		return idInstructor;
	}

	public void setIdInstructor(Long idInstructor) {
		this.idInstructor = idInstructor;
	}

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
}

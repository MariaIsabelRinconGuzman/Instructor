package com.mayasoft.schedule.infraestructure.jpa;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mayasoft.schedule.infraestructure.adapter.repository.entity.InstructorEntity;

@Repository
public interface RepositoryInstructorJPA extends JpaRepository<InstructorEntity, Serializable>{
	
	@Query("select i from InstructorEntity i where i.idInstructor = :id")
	InstructorEntity getInstructorById(@Param("id") Long id);
}

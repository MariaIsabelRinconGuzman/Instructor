package com.mayasoft.schedule.infraestructure.jpa;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mayasoft.schedule.infraestructure.adapter.repository.entity.EventEntity;

@Repository
public interface RepositoryEventJPA extends JpaRepository<EventEntity, Serializable>{
	
	@Query("select e from EventEntity e, InstructorEntity i where i.idInstructor = :idInstructor and e.instructorEntity = i.idInstructor")
    List<EventEntity> findEventsByIdInstructor(@Param("idInstructor") Long idInstructor);
	
	@Transactional(readOnly=false)
	@Modifying
	@Query("update EventEntity e set e.description = :description, e.type = :type, e.start = :start, e.end = :end,"
			+ "e.durationDays = :durationDays WHERE e.idEvent = :id")
	void update(@Param(value = "description") String description, @Param(value = "type") char type, 
			@Param(value = "start") LocalDate start, @Param(value = "end") LocalDate end, 
			@Param(value = "durationDays") int durationDays, @Param(value = "id") Long id);

}
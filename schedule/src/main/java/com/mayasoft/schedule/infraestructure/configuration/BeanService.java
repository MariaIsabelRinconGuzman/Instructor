package com.mayasoft.schedule.infraestructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mayasoft.schedule.domain.adapter.dao.DaoInstructorMySql;
import com.mayasoft.schedule.domain.adapter.dao.DaoScheduleMySql;
import com.mayasoft.schedule.domain.adapter.repository.RepositoryEventMySql;
import com.mayasoft.schedule.domain.service.ServiceCreateEvent;
import com.mayasoft.schedule.domain.service.ServiceDeleteEvent;
import com.mayasoft.schedule.domain.service.ServiceEditEvent;
import com.mayasoft.schedule.domain.service.ServiceShowInstructor;
import com.mayasoft.schedule.domain.service.ServiceShowSchedule;

@Configuration
public class BeanService {
	
	@Bean
	public ServiceCreateEvent serviceCreateEvent(RepositoryEventMySql repositoryEventMySql) {
		return new ServiceCreateEvent(repositoryEventMySql);		
	}
	
	@Bean
	public ServiceDeleteEvent serviceDeleteEvent(RepositoryEventMySql repositoryEventMySql) {
		return new ServiceDeleteEvent(repositoryEventMySql);
	}
	
	@Bean
	public ServiceEditEvent serviceEditEvent(RepositoryEventMySql repositoryEventMySql) {
		return new ServiceEditEvent(repositoryEventMySql);
	}
	
	@Bean
	public ServiceShowInstructor serviceShowInstructor(DaoInstructorMySql daoInstructorMySql) {
		return new ServiceShowInstructor(daoInstructorMySql);
	}
	
	@Bean
	public ServiceShowSchedule serviceShowSchedule(DaoScheduleMySql daoScheduleMySql) {
		return new ServiceShowSchedule(daoScheduleMySql);
	}
}

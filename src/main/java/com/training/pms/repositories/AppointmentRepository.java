package com.training.pms.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.training.pms.model.Appointment;
import com.training.pms.model.Patient;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer>{

	List<Appointment> findByUsername(String username);
	
	
}



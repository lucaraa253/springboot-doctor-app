package com.training.pms.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.training.pms.model.Patient;



public interface PatientRepository extends CrudRepository<Patient, Integer>{
	Optional<Patient> findByUsername(String username);
}

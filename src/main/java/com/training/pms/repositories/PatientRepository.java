package com.training.pms.repositories;

import org.springframework.data.repository.CrudRepository;

import com.training.pms.model.Patient;



public interface PatientRepository extends CrudRepository<Patient, Integer>{

}

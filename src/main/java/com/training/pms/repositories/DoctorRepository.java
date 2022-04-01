package com.training.pms.repositories;

import org.springframework.data.repository.CrudRepository;

import com.training.pms.model.Doctor;
import com.training.pms.model.Product;

public interface DoctorRepository extends CrudRepository<Doctor, Integer>{

}

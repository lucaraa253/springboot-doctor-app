package com.training.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.training.pms.model.Doctor;

import com.training.pms.repositories.DoctorRepository;

public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	DoctorRepository doctorRepo;
	
	@Override
	public String addDoctor(Doctor doctor) {
		System.out.println("Adding doctor");
		doctorRepo.save(doctor);
		return "Doctor was saved";
	}

	@Override
	public String updateDoctor(int doctorId, Doctor doctor) {
		System.out.println("Updating doctor");
		doctorRepo.save(doctor);
		return "Doctor was updated";
	}

	@Override
	public String deleteDoctor(int doctorId) {
		doctorRepo.deleteById(doctorId);
		return "Doctor deleted successfully";
	}

	@Override
	public List<Doctor> getDoctors() {
		System.out.println("Getting doctors method");
		return (List<Doctor>) doctorRepo.findAll();
	}

	@Override
	public Doctor getDoctor(int doctorId) {
		Optional<Doctor> doctor = doctorRepo.findById(doctorId);
		return doctor.get();
	}

	@Override
	public boolean isDoctorExists(int doctorId) {
		Optional<Doctor> doctor = doctorRepo.findById(doctorId);
		return doctor.isPresent();
	}

	

}

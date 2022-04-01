package com.training.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import com.training.pms.model.Patient;

import com.training.pms.repositories.PatientRepository;

public class PatientServiceImpl implements PatientService{
	
	@Autowired
	PatientRepository patientRepo;

	@Override
	public String addPatient(Patient patient) {
		System.out.println("Adding doctor");
		patientRepo.save(patient);
		return "Patient was saved";
	}

	@Override
	public String updatePatient(int patientId, Patient patient) {
		System.out.println("Updating doctor");
		patientRepo.save(patient);
		return "Patient was updated";
	}

	@Override
	public String deletePatient(int patientId) {
		patientRepo.deleteById(patientId);
		return "Patient deleted successfully";
	}

	@Override
	public List<Patient> getPatients() {
		System.out.println("Getting patients method");
		return (List<Patient>) patientRepo.findAll();
	}

	@Override
	public Patient getPatient(int patientId) {
		Optional<Patient> patient = patientRepo.findById(patientId);
		return patient.get();
	}

	@Override
	public boolean isPatientExists(int patientId) {
		Optional<Patient> patient = patientRepo.findById(patientId);
		return patient.isPresent();
	}

	

}

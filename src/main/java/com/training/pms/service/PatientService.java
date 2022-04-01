package com.training.pms.service;

import java.util.List;

import com.training.pms.model.Patient;


public interface PatientService {
	public String addPatient(Patient patient);
	public String updatePatient(int patientId, Patient patient);
	public String deletePatient(int patientId);
	public List<Patient> getPatients();
	public Patient getPatient(int patientId);
	public boolean isPatientExists(int patientId);

}

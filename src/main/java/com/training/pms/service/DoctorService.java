package com.training.pms.service;

import java.util.List;

import com.training.pms.model.Doctor;
import com.training.pms.model.Patient;
import com.training.pms.model.Product;

public interface DoctorService {
	public String addDoctor(Doctor doctor);
	public String updateDoctor(int doctorId, Doctor doctor);
	public String deleteDoctor(int doctorId);
	public List<Doctor> getDoctors();
	public Doctor getDoctor(int doctorId);
	public boolean isDoctorExists(int doctorId);
	
}

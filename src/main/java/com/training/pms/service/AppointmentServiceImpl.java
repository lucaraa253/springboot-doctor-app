package com.training.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.pms.model.Appointment;
import com.training.pms.model.Doctor;
import com.training.pms.model.Patient;
import com.training.pms.repositories.AppointmentRepository;
import com.training.pms.repositories.DoctorRepository;
import com.training.pms.repositories.PatientRepository;
@Service
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	AppointmentRepository appointmentRepo;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Override
	public String addAppointment(Appointment appointment) {
		System.out.println("Adding appointment");
		System.out.println("Appointement data recieved"+appointment);
		//patientRepository.save(appointment.getPatient());
		appointmentRepo.save(appointment);
		return "Appointment was saved";
	}

	@Override
	public String updateAppointment(int appointmentId, Appointment appointment) {
		System.out.println("Adding appointment");
		appointmentRepo.save(appointment);
		return "Appointment was updated";
	}

	@Override
	public String deleteAppointment(int appointmentId) {
		appointmentRepo.deleteById(appointmentId);
		return "Appointment deleted successfully";
	}

	@Override
	public List<Appointment> getAppointments() {
		System.out.println("Getting appointments method");
		return (List<Appointment>) appointmentRepo.findAll();
	}
	
	@Override
	public Appointment getAppointment(int appointmentId) {
		Optional<Appointment> appointment = appointmentRepo.findById(appointmentId);
		return appointment.get();
	}
	
	@Override
	public List<Appointment> getAppointmentByUsername(String username) {
		
		return (List<Appointment>) appointmentRepo.findByUsername(username);
	}

	@Override
	public boolean isAppointmentExists(int appointmentId) {
		Optional<Appointment> appointment = appointmentRepo.findById(appointmentId);
		return appointment.isPresent();
	}

	

}

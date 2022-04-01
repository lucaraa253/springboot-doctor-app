package com.training.pms.service;

import java.util.List;

import com.training.pms.model.Appointment;



public interface AppointmentService {
	public String addAppointment(Appointment appointment);
	public String updateAppointment(int appointmentId, Appointment appointment);
	public String deleteAppointment(int appointmentId);
	public List<Appointment> getAppointments();
	public Appointment getAppointment(int appointmentId);
	public boolean isAppointmentExists(int appointmentId);
	public List<Appointment> getAppointmentByUsername(String username);

}

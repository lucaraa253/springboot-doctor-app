package com.training.pms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.pms.model.Doctor;
import com.training.pms.repositories.DoctorRepository;

@RestController
//used at method or class level
@RequestMapping("doctor")
@CrossOrigin(origins = "http://localhost:4200")
public class DoctorController {
	
	@Autowired
	DoctorRepository doctorRepo;
	
	@GetMapping
	public ResponseEntity<List<Doctor>> getDoctors() { //localhost:5050/patient   -GET
//		
		List<Doctor> allDoctors = (List<Doctor>)doctorRepo.findAll();
		return new ResponseEntity<List<Doctor>>(allDoctors, HttpStatus.OK);

	}
	
	@GetMapping("{doctorId}")
	public ResponseEntity<Doctor> getDoctor(@PathVariable("doctorId") int doctorId) { //localhost:5050/patient   -GET
		Optional<Doctor> doctor = doctorRepo.findById(doctorId);
		return new ResponseEntity<Doctor>(doctor.get(), HttpStatus.OK);
	}

	
	@PostMapping
	public ResponseEntity<String> saveDoctor(@RequestBody Doctor doctor) {     //localhost:5050/product   -Post
		doctorRepo.save(doctor);
		return new ResponseEntity<String>("Doctor saved sucessfully", HttpStatus.CREATED);
		
	}
	
	@PutMapping("{doctorId}")
	public ResponseEntity<String> updatePatient(@PathVariable("patientId") int doctorId, @RequestBody Doctor doctor) {    //localhost:5050/product   -Put
		doctorRepo.save(doctor);
		return new ResponseEntity<String>("Doctor updated sucessfully", HttpStatus.OK);
		

	}

	
	@DeleteMapping("{doctorId}")
	public ResponseEntity<String> deleteDoctor(@PathVariable("doctorId")int doctorId) {    //localhost:5050/product   -Delete
		doctorRepo.deleteById(doctorId);
		return new ResponseEntity<String>("Doctor deleted sucessfully", HttpStatus.OK);
	}

}

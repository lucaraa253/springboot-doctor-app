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
import com.training.pms.model.Patient;
import com.training.pms.repositories.PatientRepository;



@RestController
@RequestMapping("patient")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {
	
	@Autowired
	PatientRepository patientRepo;
	
	
	@GetMapping
	public ResponseEntity<List<Patient>> getPatients() { //localhost:5050/patient   -GET
		List<Patient> allPatients = (List<Patient>)patientRepo.findAll();
		return new ResponseEntity<List<Patient>>(allPatients, HttpStatus.OK);
	}
	
	@GetMapping("{patientId}")
	public ResponseEntity<Patient> getPatient(@PathVariable("patientId") int patientId) { //localhost:5050/patient   -GET
		Optional<Patient> patient = patientRepo.findById(patientId);
		return new ResponseEntity<Patient>(patient.get(), HttpStatus.OK);
	}
		

	
	@PostMapping
	public ResponseEntity<String> savePatient(@RequestBody Patient patient) {     //localhost:5050/product   -Post
		patientRepo.save(patient);
		return new ResponseEntity<String>("Patient saved sucessfully", HttpStatus.CREATED);
	}
	
	@PutMapping("{patientId}")
	public ResponseEntity<String> updatePatient(@PathVariable("patientId") int patientId, @RequestBody Patient patient) {    //localhost:5050/product   -Put
		patientRepo.save(patient);
		return new ResponseEntity<String>("Patient updated sucessfully", HttpStatus.OK);
	}


	@DeleteMapping("{patientId}")
	public ResponseEntity<String> deletePatient(@PathVariable("id")int patientId) {    //localhost:5050/product   -Delete
		patientRepo.deleteById(patientId);
		return new ResponseEntity<String>("Patient deleted sucessfully", HttpStatus.OK);
	}
	
}


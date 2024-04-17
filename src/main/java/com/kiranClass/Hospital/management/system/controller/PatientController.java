package com.kiranClass.Hospital.management.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiranClass.Hospital.management.system.doclogin.repository.AppointmentRepository;
import com.kiranClass.Hospital.management.system.entity.Patient;
import com.kiranClass.Hospital.management.system.repository.PatientRepository;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PatientController {
	
	
	private PatientRepository patientRepository;

	public PatientController(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}

	@RequestMapping("/patients")
	public Patient createPatient(@RequestBody Patient patient) {
		return patientRepository.save(patient);
	}
	
	@GetMapping("/patients")
	public List<Patient> getAllPatients(){
		return patientRepository.findAll();
	}
	
	@GetMapping("/patients/{id}")
	public ResponseEntity<Patient>getPatientById(@PathVariable long id) throws AttributeNotFoundException{
		Patient patient = patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Patient not found with this id"));
		return ResponseEntity.ok(patient);
	}
	
	@DeleteMapping("/patients/{id}")
	public ResponseEntity<Map<String, Boolean>>deletePatient(@PathVariable long id) throws AttributeNotFoundException{
		Patient patient = patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Patient not found with this id"));
		patientRepository.delete(patient);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/patients/{id}")
	public ResponseEntity<Patient>updatePatientById(@PathVariable long id,@RequestBody Patient patientDetails)  throws AttributeNotFoundException{
		Patient patient = patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Patient not found with this id"));
		
		patient.setAge(patientDetails.getAge());
		patient.setBlood_group(patientDetails.getBlood_group());
		patient.setFees(patientDetails.getFees());
		patient.setName(patientDetails.getName());
		patient.setPrescription(patientDetails.getPrescription());
		patient.setUrgency(patientDetails.getUrgency());
		
		Patient savedPatient = patientRepository.save(patient);
		return ResponseEntity.ok(savedPatient);
		

	}
	
	

}

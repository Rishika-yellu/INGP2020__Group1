package com.controller;


import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.ResourceNotFoundException;
import com.model.Visamodel;
import com.repository.Visarepository;

@RestController
@RequestMapping("/api/v1")
public class Visacontroller {
	@Autowired
	private Visarepository visarepository;

	@GetMapping("/applicants")
	public List<Visamodel> getAllApplicants() {
		return visarepository.findAll();
	}

	@PostMapping("/applicants")
	public Visamodel createApplicant(@Valid @RequestBody Visamodel applicant) {
		return visarepository.save(applicant);
	}
	@GetMapping("/applicant/{passid}")
	public ResponseEntity<Visamodel> getApplicantBypassId(@PathVariable(value = "passid") Long passId)
			throws ResourceNotFoundException {
		Visamodel applicant = visarepository.findById(passId)
				.orElseThrow(() -> new ResourceNotFoundException("Applicant not found"+passId));
		return ResponseEntity.ok().body(applicant);
	} 
	@PutMapping("/applicants/{passid}")
	public ResponseEntity<Visamodel> updateVisamodel(@PathVariable(value = "passid") Long passId,
			@Valid @RequestBody Visamodel applicantdetails) throws ResourceNotFoundException {
		Visamodel applicant = visarepository.findById(passId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + passId));

		applicant.setEmailId(applicantdetails.getEmailId());
		applicant.setApplicantName(applicantdetails.getApplicantName());
		final Visamodel updatedVisamodel = visarepository.save(applicant);
		return ResponseEntity.ok(updatedVisamodel);
	}

	@DeleteMapping("/applicants/{passid}")
	public Map<String, Boolean> deleteVisamodel(@PathVariable(value = "passid") Long passId)
			throws ResourceNotFoundException {
		Visamodel employee = visarepository.findById(passId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + passId));

		visarepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}

package com.careManager.OutPatientAPI.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.constraints.Min;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.careManager.OutPatientAPI.domain.OutPatient;
import com.careManager.OutPatientAPI.service.OutPatientService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin
@RestController
@RequestMapping("/outpatient")
public class OutPatientController {

	@Autowired
	OutPatientService outPatientService;

	private static final Logger LOGGER = LoggerFactory.getLogger(OutPatientController.class);


	@GetMapping("/fetch")
	public ResponseEntity<?> getAll(){
		List<OutPatient> result=outPatientService.findAll();
		LOGGER.info("OutPatientController :  Getting all the outpatient data");
		return new ResponseEntity(result, HttpStatus.OK);
	}

	@GetMapping("/{patientName}")
	public ResponseEntity<?>  getByPatientName(@PathVariable("patientName") String patientName){
		LOGGER.info("  OutPatientController :  Getting outpatient data for the patient  ==> "+patientName);
		List<OutPatient> result = new ArrayList<OutPatient>();

		result = outPatientService.findByPatientName(patientName);
		if(result.isEmpty()){
			LOGGER.info("  OutPatientController :  No data found for the  patient   ==> "+patientName);
			throw new OutPatientNotFound(patientName);
		}

		return new ResponseEntity(result, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> insertOrUpdatePatientDetails( @RequestBody OutPatient outPatient){
		LOGGER.info("OutPatientController :  insertOrUpdatePatientDetails ==> "+outPatient);
		if(validateData(outPatient)) {
			outPatientService.saveOrUpdateOutPatient(outPatient);
			return new ResponseEntity("Details added/updated succcessfully", HttpStatus.OK);
		}else {
			return new ResponseEntity("Please provide a proper data", HttpStatus.BAD_REQUEST);
		}
	}

	private boolean validateData(OutPatient outPatient)  {

		LOGGER.info("OutPatientController :  validateData for  ==> "+outPatient);
		boolean isValidData=true;
		final String regex = "(\\d{4})-(\\d{2})-(\\d{2}) (\\d{2}):(\\d{2})";
		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(outPatient.getAppointmentDate());
		if(!matcher.find()|| outPatient.getPatientName().trim().isEmpty()) {
			isValidData=false;
		}
		return isValidData;
	}

	@DeleteMapping
	public void deletePatientDetails(@RequestParam("id") @Min(10) String id) {
		outPatientService.deleteOutPatient(id);
	}

}

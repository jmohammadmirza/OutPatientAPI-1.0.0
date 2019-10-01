package com.careManager.OutPatientAPI.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.careManager.OutPatientAPI.domain.OutPatient;

public interface OutPatientRepository extends MongoRepository<OutPatient,String>{
	
	List<OutPatient> findByPatientName(String patientName);
	
	//List<Expense> findByYear(int year);

}

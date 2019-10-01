package com.careManager.OutPatientAPI.service;

import java.util.List;

import com.careManager.OutPatientAPI.domain.OutPatient;

public interface OutPatientService {

	List<OutPatient> findAll();

	List<OutPatient> findByPatientName(String patientName);

	void saveOrUpdateOutPatient(OutPatient expense);

	void deleteOutPatient(String id);


}

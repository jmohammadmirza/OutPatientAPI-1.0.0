package com.careManager.OutPatientAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careManager.OutPatientAPI.domain.OutPatient;
import com.careManager.OutPatientAPI.repositories.OutPatientRepository;

@Service
public class OutPatientServiceImpl implements OutPatientService{

	@Autowired
	OutPatientRepository outPatientRepository;
	@Override
	public List<OutPatient> findAll() {

		return outPatientRepository.findAll();
	}

	@Override
	public List<OutPatient> findByPatientName(String patientName) {
		return outPatientRepository.findByPatientName(patientName);
	}

	@Override
	public void saveOrUpdateOutPatient(OutPatient outPatient) {

		outPatientRepository.save(outPatient);

	}
	@Override
	public void deleteOutPatient(String id) {
		outPatientRepository.deleteById(id);

	}



}

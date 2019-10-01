package com.careManager.OutPatientAPI.controller;

public class OutPatientNotFound  extends RuntimeException {

    public OutPatientNotFound(String patientName) {
        super("OutPatient Details not Found in the System : " + patientName);
    }

}

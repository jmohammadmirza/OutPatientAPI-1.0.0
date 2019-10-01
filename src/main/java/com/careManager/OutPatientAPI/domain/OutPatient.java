/**
 * 
 */
package com.careManager.OutPatientAPI.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author S787962
 *
 */
@Document
public class OutPatient {

	@Id
	String id;
	@NotEmpty(message = "Please provide a valid patient name")
	String patientName;
	@NotEmpty(message = "Please provide a valid patient appointment Date")
	@Pattern(regexp = "(\\\\d{4})-(\\\\d{2})-(\\\\d{2}) (\\\\d{2}):(\\\\d{2})")
	String appointmentDate;
	String comments;


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "patientName= "+patientName+" appointmentDate= "+appointmentDate+" comments= "+comments;
	}
}

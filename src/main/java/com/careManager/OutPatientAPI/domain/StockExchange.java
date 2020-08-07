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
public class StockExchange {

	@Id
	String id;
	@NotEmpty(message = "Please provide a valid order id")
	String order_id;
	@NotEmpty(message = "Please provide a valid stock name")
	String stockName;
	String type;


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getType() {
		return type;
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
}

package com.anuj.response;


import java.util.ArrayList;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *  author anuj.parmar
 */

public class DealResponse implements Serializable{

	private static final long serialVersionUID = 7779605372696056274L;

	private int id;
	private String source;
	private String destination;
	private String price;
	private Date start_date;
	private Date return_date;
	private int status;
	
	private int vehicle_id;
	private int transporter_id;
	
	

	public DealResponse() {
		super();
	}

	public DealResponse(int id) {
		super();
		this.id = id;
	}

	public DealResponse(int id, String source, String destination, String price, Date start_date, Date return_date,int status,
			int vehicle_id, int transporter_id) {
		super();
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.price = price;
		this.start_date = start_date;
		this.return_date = return_date;
		this.status=status;
		this.vehicle_id = vehicle_id;
		this.transporter_id = transporter_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getReturn_date() {
		return return_date;
	}

	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public int getTransporter_id() {
		return transporter_id;
	}

	public void setTransporter_id(int transporter_id) {
		this.transporter_id = transporter_id;
	}

	@Override
	public String toString() {
		return "DealResponse [id=" + id + ", source=" + source + ", destination=" + destination + ", price=" + price
				+ ", start_date=" + start_date + ", return_date=" + return_date + ", vehicle_id=" + vehicle_id
				+ ", transporter_id=" + transporter_id + "]";
	}



}

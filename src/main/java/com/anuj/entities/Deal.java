package com.anuj.entities;


import java.util.ArrayList;
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

@Entity
public class Deal {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String source;
	private String destination;
	private String price;
	private Date start_date;
	private Date return_date;
	private int status;
	
	
	@ManyToOne
	private Vehicle vehicle;
	
	@ManyToOne
	private Transporter transporter;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="deal")
	private List<Query> query=new ArrayList<Query>();
	

	public Deal() {
		super();
	}

	public Deal(int id) {
		super();
		this.id = id;
	}

	public Deal(int id, String source, String destination,String price, Date start_date, Date return_date,int status, Vehicle vehicle,
			Transporter transporter, List<Query> query) {
		super();
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.price=price;
		this.start_date = start_date;
		this.return_date = return_date;
		this.status=status;
		this.vehicle = vehicle;
		this.transporter = transporter;
		this.query = query;
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

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Transporter getTransporter() {
		return transporter;
	}

	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}

	public List<Query> getQuery() {
		return query;
	}

	public void setQuery(List<Query> query) {
		this.query = query;
	}

	

	
}

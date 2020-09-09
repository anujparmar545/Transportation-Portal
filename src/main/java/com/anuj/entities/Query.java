package com.anuj.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Query {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int qid;
	private String message;
	private Integer status;
	private Integer reply_of;
	
	@ManyToOne
	private Transporter transporter;
	
	@ManyToOne	
	private Vehicle vehicle;
	
	@ManyToOne
	private Deal deal;
	
	@ManyToOne
	private Customer customer;
	
	
	

	public Query() {
		super();
	}
	
	public Query(int qid) {
		super();
		this.qid = qid;
	}



	public Query(int qid,  String message,int status,int reply_of, Transporter transporter, Vehicle vehicle, Deal deal,
			Customer customer) {
		super();
		this.qid = qid;
		
		this.message = message;
		this.status=status;
		this.reply_of=reply_of;
		this.transporter = transporter;
		this.vehicle = vehicle;
		this.deal = deal;
		this.customer = customer;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	
	public int getReply_of() {
		return reply_of;
	}

	public void setReply_of(int reply_of) {
		this.reply_of = reply_of;
	}

	public Transporter getTransporter() {
		return transporter;
	}

	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Deal getDeal() {
		return deal;
	}

	public void setDeal(Deal deal) {
		this.deal = deal;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}

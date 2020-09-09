package com.anuj.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Rating{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Integer given_rating;
	private Integer count;
	
	@OneToOne
	private Transporter transporter;
	
	
	public Rating() {
		super();
	}


	public Rating(int id) {
		super();
		this.id = id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	

	public Integer getCount() {
		return count;
	}


	public void setCount(Integer count) {
		this.count = count;
	}


	public Integer getGiven_rating() {
		return given_rating;
	}


	public void setGiven_rating(Integer given_rating) {
		this.given_rating = given_rating;
	}



	public Transporter getTransporter() {
		return transporter;
	}


	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}

	


	
}

package com.anuj.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String brand;
	private int capacity;
	private String fitness_certificate;
	private String registration_card;
	private String insurance;
	private int status;
	
	@ManyToOne
	private Transporter transporter;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="vehicle")
	private List<Deal> deals=new ArrayList<Deal>();
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="vehicle")
	private List<Query> query=new ArrayList<Query>();
	

	public Vehicle() 
	{ 
		super();
	}
	
	public Vehicle(int id) {
		super();
		this.id = id;
	}

	public Vehicle(int id, String name, String brand, int capacity, String fitness_certificate,
			String registration_card, String insurance,int status, Transporter transporter, List<Deal> deals, List<Query> query) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.capacity = capacity;
		this.fitness_certificate = fitness_certificate;
		this.registration_card = registration_card;
		this.insurance = insurance;
		this.transporter = transporter;
		this.deals = deals;
		this.query = query;
		this.status=status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getFitness_certificate() {
		return fitness_certificate;
	}

	public void setFitness_certificate(String fitness_certificate) {
		this.fitness_certificate = fitness_certificate;
	}

	public String getRegistration_card() {
		return registration_card;
	}

	public void setRegistration_card(String registration_card) {
		this.registration_card = registration_card;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	public Transporter getTransporter() {
		return transporter;
	}

	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}

	public List<Deal> getDeals() {
		return deals;
	}

	public void setDeals(List<Deal> deals) {
		this.deals = deals;
	}

	public List<Query> getQuery() {
		return query;
	}

	public void setQuery(List<Query> query) {
		this.query = query;
	}

	

	
	
	
	
}

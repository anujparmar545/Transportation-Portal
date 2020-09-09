package com.anuj.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class VehicleRequest {

	@JsonIgnore
	private int id;
	private String name;
	private String brand;
	private int capacity;
	private String fitness_certificate;
	private String registration_card;
	private String insurance;
	private int status;
	private int  transporter_id;
	
	public VehicleRequest() {
		super();
	}

	public VehicleRequest(int id, String name, String brand, int capacity, String fitness_certificate,
			String registration_card, String insurance, int status, int transporter_id) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.capacity = capacity;
		this.fitness_certificate = fitness_certificate;
		this.registration_card = registration_card;
		this.insurance = insurance;
		this.status = status;
		this.transporter_id = transporter_id;
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

	public int getTransporter_id() {
		return transporter_id;
	}

	public void setTransporter_id(int transporter_id) {
		this.transporter_id = transporter_id;
	}
	
	
	
}

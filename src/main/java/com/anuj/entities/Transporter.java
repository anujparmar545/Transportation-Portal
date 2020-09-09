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
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Email;

@Entity
public class Transporter {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String username;
	private String password;
	private String address;
	private String mobile;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	private String gst_reg;
	private String pancard;
	private int status;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="transporter")
	private List<Vehicle> vehicles=new ArrayList<Vehicle>();
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="transporter")
	private List<Deal> deals=new ArrayList<Deal>();
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="transporter")
	private List<Query> query=new ArrayList<Query>();
	
	@OneToOne(mappedBy="transporter",fetch=FetchType.LAZY)
	private Rating rating;

	public Transporter() {
		super();
	}

	public Transporter(int id) {
		super();
		this.id = id;
	}

	public Transporter(int id, String name, String email, String username, String password, String address,String mobile,
			String city, String state, String country, String zipcode, String gst_reg, String pancard, int status,
			List<Vehicle> vehicles, List<Deal> deals, List<Query> query,Rating rating) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.address = address;
		this.mobile=mobile;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
		this.gst_reg = gst_reg;
		this.pancard = pancard;
		this.status = status;
		this.vehicles = vehicles;
		this.deals = deals;
		this.query = query;
		this.rating=rating;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getGst_reg() {
		return gst_reg;
	}

	public void setGst_reg(String gst_reg) {
		this.gst_reg = gst_reg;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
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

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	

	

	
}

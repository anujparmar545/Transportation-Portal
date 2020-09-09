package com.anuj.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *  author anuj.parmar
 */

public class TransporterRequest implements Serializable{

	private static final long serialVersionUID = -2193303529058552570L;
	
	@JsonIgnore
	private int id;          
	private String  address ;    
	private String city ;       
	private String country ;     
	private String email ;      
	private String gst_reg ;    
	private String mobile ;     
	private String name ;       
	private String pancard ;     
	private String password ;   
	private String state ;      
	private int status ;      
	private String username ;   
	private String zipcode ;
	
	public TransporterRequest(int id, String address, String city, String country, String email, String gst_reg,
			String mobile, String name, String pancard, String password, String state, int status, String username,
			String zipcode) {
		super();
		this.id = id;
		this.address = address;
		this.city = city;
		this.country = country;
		this.email = email;
		this.gst_reg = gst_reg;
		this.mobile = mobile;
		this.name = name;
		this.pancard = pancard;
		this.password = password;
		this.state = state;
		this.status = status;
		this.username = username;
		this.zipcode = zipcode;
	}

	public TransporterRequest() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGst_reg() {
		return gst_reg;
	}

	public void setGst_reg(String gst_reg) {
		this.gst_reg = gst_reg;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
		
}

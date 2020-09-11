package com.anuj.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anuj.entities.Customer;
import com.anuj.entities.Transporter;
import com.anuj.repository.CustomerRepository;
import com.anuj.repository.TransporterRepository;
import com.anuj.response.CustomerResponse;
import com.anuj.response.TransporterResponse;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private TransporterRepository transporterRepository;
	
	
	@Override
	public CustomerResponse loginCustomer(@Valid String username, @Valid String password) {
		
		Customer customer = customerRepository.findByUsernameAndPassword(username, password);
		if(customer!=null)
		{	
		CustomerResponse response =new CustomerResponse();
		response.setId(customer.getId());
		response.setAddress(customer.getAddress());
		response.setCity(customer.getCity());
		response.setCountry(customer.getCountry());
		response.setEmail(customer.getEmail());
		response.setName(customer.getName());
		response.setPassword(customer.getPassword());
		response.setState(customer.getState());
		response.setUsername(customer.getUsername());
		response.setZipcode(customer.getZipcode());
		return response;
		}
		else
			return null;
	}

	@Override
	public TransporterResponse loginTransporter(@Valid String username, @Valid String password) {
		Transporter transporter = transporterRepository.findByUsernameAndPassword(username, password);
		if(transporter!=null)
		{	
			TransporterResponse response= new TransporterResponse();
			response.setId(transporter.getId());
			response.setAddress(transporter.getAddress());
			response.setCity(transporter.getCity());
			response.setCountry(transporter.getCountry());
			response.setEmail(transporter.getEmail());
			response.setGst_reg(transporter.getGst_reg());
			response.setMobile(transporter.getMobile());
			response.setName(transporter.getName());
			response.setPancard(transporter.getPancard());
			response.setPassword(transporter.getPassword());
			response.setState(transporter.getState());
			response.setStatus(transporter.getStatus());
			response.setUsername(transporter.getUsername());
			response.setZipcode(transporter.getZipcode());
			
			
			return response;
		}
		else
			return null;
	}

	@Override
	public Boolean loginAdmin(@Valid String username, @Valid String password) {
		
		if(username.equalsIgnoreCase("admin")&& password.equalsIgnoreCase("admin"))
			return true;
		else
			return false;
	}

}

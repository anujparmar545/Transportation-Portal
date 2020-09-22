package com.anuj.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.anuj.entities.Customer;
import com.anuj.entities.Transporter;
import com.anuj.repository.CustomerRepository;
import com.anuj.repository.TransporterRepository;
import com.anuj.response.CustomerResponse;
import com.anuj.response.TransporterResponse;


@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private CustomerRepository customerRepository; 
	
	@Autowired
	private TransporterRepository transporterRepository;
	
	@Override
	@Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_UNCOMMITTED)
	public List<CustomerResponse> viewAllCustomers() {
		
		List<Customer> customerList= customerRepository.findAll();
		
		List<CustomerResponse> response = new ArrayList<CustomerResponse>();
		customerList.forEach(customer -> {
			
			CustomerResponse resp=new CustomerResponse();
			resp.setAddress(customer.getAddress());
			resp.setCity(customer.getCity());
			resp.setCountry(customer.getCountry());
			resp.setEmail(customer.getEmail());
			resp.setId(customer.getId());
			resp.setName(customer.getName());
			resp.setPassword(customer.getPassword());
			resp.setState(customer.getState());
			resp.setUsername(customer.getUsername());
			resp.setZipcode(customer.getZipcode());
			
			response.add(resp);
			
		});
		return response;
	}

	@Override
	@Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_UNCOMMITTED)
	public List<TransporterResponse> viewAllTransporters() {
		
		List<Transporter> transporterList= transporterRepository.findAllBystatus(1);
		
		List<TransporterResponse> response = new ArrayList<TransporterResponse>();
		transporterList.forEach(transporter -> {
			
			TransporterResponse resp=new TransporterResponse();
			resp.setAddress(transporter.getAddress());
			resp.setCity(transporter.getCity());
			resp.setCountry(transporter.getCountry());
			resp.setEmail(transporter.getEmail());
			resp.setId(transporter.getId());
			resp.setName(transporter.getName());
			resp.setPassword(transporter.getPassword());
			resp.setState(transporter.getState());
			resp.setUsername(transporter.getUsername());
			resp.setZipcode(transporter.getZipcode());
			resp.setGst_reg(transporter.getGst_reg());
			resp.setMobile(transporter.getMobile());
			resp.setPancard(transporter.getPancard());
			resp.setStatus(transporter.getStatus());
			response.add(resp);
			
		});
		return response;
	}

}

package com.anuj.services;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.anuj.entities.City;
import com.anuj.entities.Customer;
import com.anuj.entities.Deal;
import com.anuj.entities.Transporter;
import com.anuj.repository.CityRepository;
import com.anuj.repository.CustomerRepository;
import com.anuj.repository.DealRepo;
import com.anuj.repository.DealRepository;
import com.anuj.request.CustomerRequest;
import com.anuj.response.CustomerResponse;
import com.anuj.response.DealResponse;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private DealRepository dealRepository;

	@Autowired
	private DealRepo dealRepo;

	@Override
	@Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_UNCOMMITTED)
	public CustomerResponse saveCustomer(@Valid CustomerRequest request) {
		
		Customer customer =new Customer();
		customer.setAddress(request.getAddress());
		customer.setCity(request.getCity());
		customer.setCountry(request.getCountry());
		customer.setEmail(request.getEmail());
		customer.setName(request.getName());
		customer.setPassword(request.getPassword());
		customer.setState(request.getState());
		customer.setUsername(request.getUsername());
		customer.setZipcode(request.getZipcode());
		
		Customer customer1 = customerRepository.save(customer);
		CustomerResponse response =new CustomerResponse();
		
		response.setId(customer1.getId());
		response.setAddress(customer1.getAddress());
		response.setCity(customer1.getCity());
		response.setCountry(customer1.getCountry());
		response.setEmail(customer1.getEmail());
		response.setName(customer1.getName());
		response.setPassword(customer1.getPassword());
		response.setState(customer1.getState());
		response.setUsername(customer1.getUsername());
		response.setZipcode(customer1.getZipcode());
		return response;
	}

	@Override
	@Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_UNCOMMITTED)
	public CustomerResponse updateCustomer(@Valid CustomerResponse request) {
		
		Customer customer = customerRepository.findById(request.getId());
		customer.setAddress(request.getAddress());
		customer.setCity(request.getCity());
		customer.setCountry(request.getCountry());
		customer.setEmail(request.getEmail());
		customer.setName(request.getName());
		customer.setPassword(request.getPassword());
		customer.setState(request.getState());
		customer.setUsername(request.getUsername());
		customer.setZipcode(request.getZipcode());
		
		Customer customer1 = customerRepository.findById(customer.getId());
		CustomerResponse response = new CustomerResponse();
		
		response.setId(customer1.getId());
		response.setAddress(customer1.getAddress());
		response.setCity(customer1.getCity());
		response.setCountry(customer1.getCountry());
		response.setEmail(customer1.getEmail());
		response.setName(customer1.getName());
		response.setPassword(customer1.getPassword());
		response.setState(customer1.getState());
		response.setUsername(customer1.getUsername());
		response.setZipcode(customer1.getZipcode());
		return response;
	}

	@Override
	@Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_UNCOMMITTED)
	public List<DealResponse> viewCurrentDeals() {
		
		List<DealResponse> response= dealRepo.viewCurrentDeals();
	
		return response;
	}


	

}

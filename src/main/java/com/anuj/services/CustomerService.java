package com.anuj.services;

import java.util.List;

import javax.validation.Valid;

import com.anuj.request.CustomerRequest;
import com.anuj.response.CustomerResponse;
import com.anuj.response.DealResponse;

public interface CustomerService {

	CustomerResponse saveCustomer(@Valid CustomerRequest request);

	CustomerResponse updateCustomer(@Valid CustomerResponse request);

	List<DealResponse> viewCurrentDeals(); 

}

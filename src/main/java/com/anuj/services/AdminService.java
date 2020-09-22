package com.anuj.services;

import java.util.List;

import com.anuj.response.CustomerResponse;
import com.anuj.response.TransporterResponse;

public interface AdminService {

	List<CustomerResponse> viewAllCustomers();

	List<TransporterResponse> viewAllTransporters();

}

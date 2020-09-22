package com.anuj.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anuj.request.CustomerRequest;
import com.anuj.response.CustomerResponse;
import com.anuj.response.MetaData;
import com.anuj.response.ResponseBody;
import com.anuj.response.TransporterResponse;
import com.anuj.services.AdminService;
import com.anuj.services.CustomerService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/admin")
@Api(value="AdminController", description = "Admin related services", tags=("AdminController"))
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/viewAllCustomers")
	public ResponseBody<List<CustomerResponse>, MetaData> viewAllCustomers() {
		logger.info("Entering - AdminController.viewAllCustomers");
		
		List<CustomerResponse> customerResponse =adminService.viewAllCustomers();
		ResponseBody<List<CustomerResponse>, MetaData> response = new ResponseBody<>(customerResponse, new MetaData());
        
		logger.info("Exiting method - AdminController.viewAllCustomers");
        return response;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/viewAllTransporters")
	public ResponseBody<List<TransporterResponse>, MetaData> viewAllTransporters() {
		logger.info("Entering - AdminController.viewAllTransporters");
		
		List<TransporterResponse> customerResponse =adminService.viewAllTransporters();
		ResponseBody<List<TransporterResponse>, MetaData> response = new ResponseBody<>(customerResponse, new MetaData());
        
		logger.info("Exiting method - AdminController.viewAllTransporters");
        return response;
	}
}

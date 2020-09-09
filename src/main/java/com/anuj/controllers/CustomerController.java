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
import com.anuj.request.TransporterRequest;
import com.anuj.response.CustomerResponse;
import com.anuj.response.DealResponse;
import com.anuj.response.MetaData;
import com.anuj.response.ResponseBody;
import com.anuj.response.TransporterResponse;
import com.anuj.services.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/customer")
@Api(value="CustomerController", description = "Customer related services", tags=("CustomerController"))
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(TransporterController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public ResponseBody<CustomerResponse, MetaData> saveCustomer(@Valid @RequestBody final CustomerRequest request) {
		logger.info("Entering - CustomerController.saveTransporter");
		
		CustomerResponse customerResponse =customerService.saveCustomer(request);
		ResponseBody<CustomerResponse, MetaData> response = new ResponseBody<>(customerResponse, new MetaData());
        
		logger.info("Exiting method - CustomerController.saveCustomer");
        return response;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/update")
	public ResponseBody<CustomerResponse, MetaData> updateCustomer(@Valid @RequestBody final CustomerResponse request) {
		logger.info("Entering - CustomerController.updateCustomer");
		
		CustomerResponse customerResponse =customerService.updateCustomer(request);
		ResponseBody<CustomerResponse, MetaData> response = new ResponseBody<>(customerResponse, new MetaData());
        
		logger.info("Exiting method - CustomerController.updateCustomer");
        return response;
	}
	
	@ApiOperation("View Current Deals ")
   	@RequestMapping(method = RequestMethod.POST, value = "/viewCurrentDeals")
	public ResponseBody<List<DealResponse>, MetaData> viewCurrentDeals() {
		logger.info("Entering - CustomerController.viewCurrentDeals");
		
		List<DealResponse> resp=customerService.viewCurrentDeals();
		ResponseBody<List<DealResponse>, MetaData> response = new ResponseBody<>(resp, new MetaData());
        
		logger.info("Exiting method - CustomerController.viewCurrentDeals");
        return response;
	}
}

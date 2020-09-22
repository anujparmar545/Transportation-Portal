package com.anuj.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.anuj.response.CustomerResponse;
import com.anuj.response.MetaData;
import com.anuj.response.ResponseBody;
import com.anuj.response.TransporterResponse;
import com.anuj.services.LoginService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/login")
@Api(value="LoginController", description = "Login related services", tags=("LoginController"))
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/customer")
	public ResponseBody<CustomerResponse, MetaData> loginCustomer(@Valid @RequestParam final String username,@Valid @RequestParam final String password) {
		logger.info("Entering - LoginController.loginCustomer");
		
		CustomerResponse customerResponse =loginService.loginCustomer(username,password);
		ResponseBody<CustomerResponse, MetaData> response = new ResponseBody<>(customerResponse, new MetaData());
        
		logger.info("Exiting method - LoginController.loginCustomer");
        return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/transporter")
	public ResponseBody<TransporterResponse, MetaData> loginTransporter(@Valid @RequestParam final String username,@Valid @RequestParam final String password) {
		logger.info("Entering - LoginController.loginTransporter");
		
		TransporterResponse transporterResponse =loginService.loginTransporter(username,password);
		ResponseBody<TransporterResponse, MetaData> response = new ResponseBody<>(transporterResponse, new MetaData());
        
		logger.info("Exiting method - LoginController.loginTransporter");
        return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/admin")
	public ResponseBody<Boolean, MetaData> loginAdmin(@Valid @RequestParam final String username,@Valid @RequestParam final String password) {
		logger.info("Entering - LoginController.loginAdmin");
		
		Boolean resp =loginService.loginAdmin(username,password);
		ResponseBody<Boolean, MetaData> response = new ResponseBody<>(resp, new MetaData());
        
		logger.info("Exiting method - LoginController.loginAdmin");
        return response;
	}
}

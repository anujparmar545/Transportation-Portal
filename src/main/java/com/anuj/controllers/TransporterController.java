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

import com.anuj.response.DealResponse;
import com.anuj.response.MetaData;
import com.anuj.response.ResponseBody;
import com.anuj.response.TransporterResponse;
import com.anuj.services.TransporterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import com.anuj.entities.Transporter;
import com.anuj.request.DealRequest;
import com.anuj.request.TransporterRequest;
import com.anuj.response.TransporterResponse;

@RestController
@RequestMapping(value="/transporter")
@Api(value="TransporterController", description = "Transporter related services", tags=("TransporterController"))
public class TransporterController {

	private static final Logger logger = LoggerFactory.getLogger(TransporterController.class);
	
	@Autowired
	private TransporterService transportService;
	
	@ApiOperation("save transporter details")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrieved location details"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "You are not logged in"),
            @ApiResponse(code = 403, message = "Your user ID does not match the user ID specified in the request")
    })
	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public ResponseBody<TransporterResponse, MetaData> saveTransporter(@Valid @RequestBody final TransporterRequest request) {
		logger.info("Entering - TransporterController.saveTransporter");
		
		TransporterResponse transporterResponse=transportService.saveTransporter(request);
		ResponseBody<TransporterResponse, MetaData> response = new ResponseBody<>(transporterResponse, new MetaData());
        
		logger.info("Exiting method - TransporterController.saveTransporter");
        return response;
	}
	
	
	@ApiOperation("verify transporter ")
   	@RequestMapping(method = RequestMethod.POST, value = "/verify")
	public ResponseBody<String, MetaData> verifyTransporter(@Valid @RequestBody final String username) {
		logger.info("Entering - TransporterController.verifyTransporter");
		
		String resp=transportService.verifyTransporter(username);
		ResponseBody<String, MetaData> response = new ResponseBody<>(resp, new MetaData());
        
		logger.info("Exiting method - TransporterController.verifyTransporter");
        return response;
	}
	
	@ApiOperation("post a Deal ")
   	@RequestMapping(method = RequestMethod.POST, value = "/postDeal")
	public ResponseBody<DealResponse, MetaData> postDeal(@Valid @RequestBody final DealRequest request) {
		logger.info("Entering - TransporterController.postDeal");
		
		DealResponse resp=transportService.postDeal(request);
		ResponseBody<DealResponse, MetaData> response = new ResponseBody<>(resp, new MetaData());
        
		logger.info("Exiting method - TransporterController.postDeal");
        return response;
	}
	
	@ApiOperation("update Deal ")
   	@RequestMapping(method = RequestMethod.POST, value = "/updateDeal")
	public ResponseBody<DealResponse, MetaData> updateDeal(@Valid @RequestBody final DealResponse request) {
		logger.info("Entering - TransporterController.updateDeal");
		
		DealResponse resp=transportService.updateDeal(request);
		ResponseBody<DealResponse, MetaData> response = new ResponseBody<>(resp, new MetaData());
        
		logger.info("Exiting method - TransporterController.updateDeal");
        return response;
	}
	
	@ApiOperation("view My Deals ")
   	@RequestMapping(method = RequestMethod.POST, value = "/viewDeals")
	public ResponseBody<List<DealResponse>, MetaData> viewDeals(@Valid @RequestBody final int transporterId) {
		logger.info("Entering - TransporterController.postDeal");
		
		List<DealResponse> resp=transportService.viewDeals(transporterId);
		ResponseBody<List<DealResponse>, MetaData> response = new ResponseBody<>(resp, new MetaData());
        
		logger.info("Exiting method - TransporterController.viewDeals");
        return response;
	}
	
	@ApiOperation("delete a Deal ")
   	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteDeal")
	public ResponseBody<String, MetaData> deleteDeal(@Valid @RequestBody final int dealId) {
		logger.info("Entering - TransporterController.postDeal");
		
		String resp=transportService.deleteDeal(dealId);
		ResponseBody<String, MetaData> response = new ResponseBody<>(resp, new MetaData());
        
		logger.info("Exiting method - TransporterController.deleteDeal");
        return response;
	}
}

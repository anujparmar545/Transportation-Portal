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
import com.anuj.response.MetaData;
import com.anuj.response.ResponseBody;
import com.anuj.response.TransporterResponse;
import com.anuj.response.VehicleResponse;
import com.anuj.services.TransporterService;
import com.anuj.services.VehicleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import com.anuj.entities.Transporter;
import com.anuj.request.TransporterRequest;
import com.anuj.request.VehicleRequest;
import com.anuj.request.VehicleUpdateRequest;
import com.anuj.response.TransporterResponse;

@RestController
@RequestMapping(value="/vehicle")
@Api(value="VehicleController", description = "Vehicle related services", tags=("VehicleController"))
public class VehicleController {

	private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);
	
	@Autowired
	private VehicleService vehicleService;
	
	@ApiOperation("save vehicle details")
    @RequestMapping(method = RequestMethod.POST, value = "/save")
	public ResponseBody<VehicleResponse, MetaData> saveVehicle(@Valid @RequestBody final VehicleRequest request) {
		logger.info("Entering - VehicleController.saveVehicle");
		
		VehicleResponse vehicleResponse=vehicleService.saveVehicle(request);
		ResponseBody<VehicleResponse, MetaData> response = new ResponseBody<>(vehicleResponse, new MetaData());
        
		logger.info("Exiting method - VehicleController.saveVehicle");
        return response;
	}
	
	
	@ApiOperation("verify Vehicle ")
   	@RequestMapping(method = RequestMethod.POST, value = "/verify")
	public ResponseBody<String, MetaData> verifyVehicle(@Valid @RequestBody final int vehicleId) {
		logger.info("Entering - VehicleController.verifyVehicle");
		
		String resp=vehicleService.verifyVehicle(vehicleId);
		ResponseBody<String, MetaData> response = new ResponseBody<>(resp, new MetaData());
        
		logger.info("Exiting method - VehicleController.verifyVehicle");
        return response;
	}
	
	@ApiOperation("update vehicle details")
    @RequestMapping(method = RequestMethod.POST, value = "/update")
	public ResponseBody<VehicleResponse, MetaData> updateVehicle(@Valid @RequestBody final VehicleUpdateRequest request) {
		logger.info("Entering - VehicleController.updateVehicle");
		
		VehicleResponse vehicleResponse=vehicleService.updateVehicle(request);
		ResponseBody<VehicleResponse, MetaData> response = new ResponseBody<>(vehicleResponse, new MetaData());
        
		logger.info("Exiting method - VehicleController.updateVehicle");
        return response;
	}
	
	@ApiOperation("delete vehicle ")
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
	public ResponseBody<String, MetaData> deleteVehicle(@Valid @RequestBody final int vehicleId) {
		logger.info("Entering - VehicleController.deleteVehicle");
		
		String vehicleResponse=vehicleService.deleteVehicle(vehicleId);
		ResponseBody<String, MetaData> response = new ResponseBody<>(vehicleResponse, new MetaData());
        
		logger.info("Exiting method - VehicleController.deleteVehicle");
        return response;
	}
	
	@ApiOperation("view  transporter vehicles")
   	@RequestMapping(method = RequestMethod.POST, value = "/viewTransporterVehicle")
	public ResponseBody<List<VehicleResponse>, MetaData> viewTransporterVehicle(@Valid @RequestBody final int transporterId) {
		logger.info("Entering - VehicleController.viewTransporterVehicle");
		
		List<VehicleResponse> resp=vehicleService.viewTransporterVehicle(transporterId);
		ResponseBody<List<VehicleResponse>, MetaData> response = new ResponseBody<>(resp, new MetaData());
        
		logger.info("Exiting method - VehicleController.viewTransporterVehicle");
        return response;
	}
}

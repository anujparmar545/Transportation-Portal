package com.anuj.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anuj.entities.City;
import com.anuj.services.CityService;
import com.anuj.services.CityServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/city")
@Validated
@Api(value="CityController", description = "Data service operations on transporter", tags=("CityController"))
public class CityController {
	
	
	 @Autowired(required = true)
	 @Qualifier("cityService")
	 private CityService cityService;

	@RequestMapping(method= RequestMethod.GET)
	@ApiOperation(value="Get All Cities", notes="Gets all cities of the system", nickname="getCities")
    public List<City> getAllCities(){
        
	  List<City> cityList= cityService.getAllCities();
        
        return cityList;
    }

	
	
	
}

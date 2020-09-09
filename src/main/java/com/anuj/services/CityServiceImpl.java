package com.anuj.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.anuj.entities.City;
import com.anuj.repository.CityRepository;

@Service("cityService")
public class CityServiceImpl implements CityService {

	@Autowired(required = true)
	 @Qualifier("cityRepository")
	private CityRepository cityRepository;

	
	@Override
	@Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_UNCOMMITTED)
	public List<City> getAllCities() {
		List<City> cityList= (List<City>) cityRepository.findAll();
		return cityList;
	}
	
	

}

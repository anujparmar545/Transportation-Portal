package com.anuj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anuj.entities.City;

@Repository("cityRepository")
public interface CityRepository extends JpaRepository<City, Integer>{

	

}



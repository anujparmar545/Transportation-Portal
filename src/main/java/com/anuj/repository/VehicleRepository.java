package com.anuj.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anuj.entities.Vehicle;
import com.anuj.response.VehicleResponse;
import com.anuj.entities.Transporter;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Integer>{

	
	Vehicle findById(int id);

	List<Vehicle> findByTransporter(Transporter transporter);

}



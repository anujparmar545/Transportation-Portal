package com.anuj.services;

import java.util.List;

import javax.validation.Valid;

import com.anuj.request.VehicleRequest;
import com.anuj.request.VehicleUpdateRequest;
import com.anuj.response.VehicleResponse;

public interface VehicleService {

	VehicleResponse saveVehicle( VehicleRequest request);

	String verifyVehicle( int vehicleId);

	List<VehicleResponse> viewTransporterVehicle( int transporterId);

	VehicleResponse updateVehicle( VehicleUpdateRequest request);

	String deleteVehicle( int vehicleId);

	
}

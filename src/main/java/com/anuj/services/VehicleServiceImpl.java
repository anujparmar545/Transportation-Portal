package com.anuj.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.anuj.entities.Transporter;
import com.anuj.entities.Vehicle;
import com.anuj.repository.TransporterRepository;
import com.anuj.repository.VehicleRepository;
import com.anuj.request.VehicleRequest;
import com.anuj.request.VehicleUpdateRequest;
import com.anuj.response.VehicleResponse;


@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private TransporterRepository transporterRepository;
	
//	@Autowired
//	@Qualifier("entityManagerFactory")
//	@PersistenceContext(unitName = "default")
//	private  EntityManager entityManager;
	
	@Override
	@Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_UNCOMMITTED)
	public VehicleResponse saveVehicle(VehicleRequest request) {
		
		Vehicle vehicle=new Vehicle();
		vehicle.setBrand(request.getBrand());
		vehicle.setCapacity(request.getCapacity());
		vehicle.setFitness_certificate(request.getFitness_certificate());
		vehicle.setInsurance(request.getInsurance());
		vehicle.setName(request.getName());
		vehicle.setRegistration_card(request.getRegistration_card());
		vehicle.setStatus(0);
		Transporter transporter=transporterRepository.findById(request.getTransporter_id());
		vehicle.setTransporter(transporter);
		
		Vehicle vehicle1=vehicleRepository.save(vehicle);
		
		VehicleResponse response= new VehicleResponse();
		response.setId(vehicle1.getId());
		response.setBrand(vehicle1.getBrand());
		response.setCapacity(vehicle1.getCapacity());
		response.setFitness_certificate(vehicle1.getFitness_certificate());
		response.setInsurance(vehicle1.getInsurance());
		response.setName(vehicle1.getName());
		response.setRegistration_card(vehicle1.getRegistration_card());
		response.setStatus(vehicle1.getStatus());
		response.setTransporter_id(vehicle1.getTransporter().getId());
		
		return response;
	}

	@Override
	@Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_UNCOMMITTED)
	public String verifyVehicle(int vehicleId) {
		
		Vehicle vehicle=vehicleRepository.findById(vehicleId);
		if(vehicle!=null)
		{
			vehicle.setStatus(1);
			return "vehicle  verified";
		}
		return "vehicle not verified";
	}

	@Override
	@Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_UNCOMMITTED)
	public List<VehicleResponse> viewTransporterVehicle(int transporterId) {
		
		Transporter transporter=transporterRepository.findById(transporterId);
		List<Vehicle> vehicleList=vehicleRepository.findByTransporter(transporter);
		
		List<VehicleResponse> response=new ArrayList<VehicleResponse>();
		vehicleList.forEach((vehicle) ->{
		VehicleResponse vr=new VehicleResponse();
		vr.setId(vehicle.getId());
		vr.setId(vehicle.getId());
		vr.setBrand(vehicle.getBrand());
		vr.setCapacity(vehicle.getCapacity());
		vr.setFitness_certificate(vehicle.getFitness_certificate());
		vr.setInsurance(vehicle.getInsurance());
		vr.setName(vehicle.getName());
		vr.setRegistration_card(vehicle.getRegistration_card());
		vr.setStatus(vehicle.getStatus());
		vr.setTransporter_id(vehicle.getTransporter().getId());
		
		response.add(vr);
	});
		return response;
	}

	@Override
	@Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_UNCOMMITTED)
	public VehicleResponse updateVehicle(VehicleUpdateRequest request) {
		
		Vehicle vehicle=vehicleRepository.findById(request.getId());
		vehicle.setBrand(request.getBrand());
		vehicle.setCapacity(request.getCapacity());
		vehicle.setFitness_certificate(request.getFitness_certificate());
		vehicle.setInsurance(request.getInsurance());
		vehicle.setName(request.getName());
		vehicle.setRegistration_card(request.getRegistration_card());
		vehicle.setStatus(request.getStatus());
		Transporter transporter=transporterRepository.findById(request.getTransporter_id());
		vehicle.setTransporter(transporter);
		
		Vehicle vehicle1=vehicleRepository.findById(vehicle.getId());
		
		VehicleResponse response= new VehicleResponse();
		response.setId(vehicle1.getId());
		response.setBrand(vehicle1.getBrand());
		response.setCapacity(vehicle1.getCapacity());
		response.setFitness_certificate(vehicle1.getFitness_certificate());
		response.setInsurance(vehicle1.getInsurance());
		response.setName(vehicle1.getName());
		response.setRegistration_card(vehicle1.getRegistration_card());
		response.setStatus(vehicle1.getStatus());
		response.setTransporter_id(vehicle1.getTransporter().getId());
		
		return response;
	}

	@Override
	@Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_UNCOMMITTED)
	public String deleteVehicle(int vehicleId) {
		
	vehicleRepository.deleteById(vehicleId);
		return "Vehicle Deleted";
	}

	

}

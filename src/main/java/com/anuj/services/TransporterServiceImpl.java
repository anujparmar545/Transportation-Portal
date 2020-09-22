package com.anuj.services;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.anuj.controllers.TransporterController;
import com.anuj.entities.Deal;
import com.anuj.entities.Transporter;
import com.anuj.entities.Vehicle;
import com.anuj.repository.DealRepository;
import com.anuj.repository.TransporterRepository;
import com.anuj.repository.VehicleRepository;
import com.anuj.request.DealRequest;
import com.anuj.request.TransporterRequest;
import com.anuj.response.DealResponse;
import com.anuj.response.TransporterResponse;

@Service
public class TransporterServiceImpl implements TransporterService {

	private static final Logger logger = LoggerFactory.getLogger(TransporterController.class);
	
	@Autowired
	private TransporterRepository transporterRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private DealRepository dealRepository;
	
	@Override
	@Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_UNCOMMITTED)
	public TransporterResponse saveTransporter(TransporterRequest request) {
		
		Transporter transporter=new Transporter();
		transporter.setAddress(request.getAddress());
		transporter.setCity(request.getCity());
		transporter.setCountry(request.getCountry());
		transporter.setEmail(request.getEmail());
		transporter.setGst_reg(request.getGst_reg());
		transporter.setMobile(request.getMobile());
		transporter.setName(request.getName());
		transporter.setPancard(request.getPancard());
		transporter.setPassword(request.getPassword());
		transporter.setState(request.getState());
		transporter.setStatus(0);
		transporter.setUsername(request.getUsername());
		transporter.setZipcode(request.getZipcode());
		
		Transporter transporter1=transporterRepository.save(transporter);
		
		TransporterResponse response= new TransporterResponse();
		response.setId(transporter1.getId());
		response.setAddress(transporter1.getAddress());
		response.setCity(transporter1.getCity());
		response.setCountry(transporter1.getCountry());
		response.setEmail(transporter1.getEmail());
		response.setGst_reg(transporter1.getGst_reg());
		response.setMobile(transporter1.getMobile());
		response.setName(transporter1.getName());
		response.setPancard(transporter1.getPancard());
		response.setPassword(transporter1.getPassword());
		response.setState(transporter1.getState());
		response.setStatus(transporter1.getStatus());
		response.setUsername(transporter1.getUsername());
		response.setZipcode(transporter1.getZipcode());
		
		return response;
	}

	@Override
	@Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_UNCOMMITTED)
	public String verifyTransporter(String username) {
		
		Transporter transporter=transporterRepository.findByUsername(username);
		if(transporter!=null)
		{
			transporter.setStatus(1);
			return "transporter  verified";
		}
		return "transporter not verified";
	}

	@Override
	@Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_UNCOMMITTED)
	public DealResponse postDeal(DealRequest request) {
		
		Deal deal =new Deal();
		deal.setDestination(request.getDestination());
		deal.setPrice(request.getPrice());
		deal.setReturn_date(request.getReturn_date());
		deal.setSource(request.getSource());
		deal.setStart_date(request.getStart_date());
		deal.setStatus(0);
		
		Transporter transporter=transporterRepository.findById(request.getTransporter_id());
		deal.setTransporter(transporter);
		Vehicle vehicle=vehicleRepository.findById(request.getVehicle_id());
		deal.setVehicle(vehicle);
		
		Deal deal1=dealRepository.save(deal);
		
		DealResponse response =new DealResponse();
		response.setId(deal1.getId());
		response.setDestination(deal1.getDestination());
		response.setPrice(deal1.getPrice());
		response.setReturn_date(deal1.getReturn_date());
		response.setSource(deal1.getSource());
		response.setStart_date(deal1.getStart_date());
		response.setStatus(deal1.getStatus());
		response.setTransporter_id(deal1.getTransporter().getId());
		response.setVehicle_id(deal1.getVehicle().getId());
		
		return response;
	}

	@Override
	@Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_UNCOMMITTED)
	public List<DealResponse> viewDeals(int transporterId) {
		
		Transporter transporter=transporterRepository.findById(transporterId);
		List<Deal> dealList= dealRepository.findByTransporter(transporter);
		
		List<DealResponse> resp=new ArrayList<DealResponse>();
		dealList.forEach(deal -> {
			DealResponse response =new DealResponse();
			response.setId(deal.getId());
			response.setDestination(deal.getDestination());
			response.setPrice(deal.getPrice());
			response.setReturn_date(deal.getReturn_date());
			response.setSource(deal.getSource());
			response.setStart_date(deal.getStart_date());
			response.setStatus(deal.getStatus());
			response.setTransporter_id(deal.getTransporter().getId());
			response.setVehicle_id(deal.getVehicle().getId());
			
			resp.add(response);
		});
		
		return resp;
	}


	@Override
	public String deleteDeal( int dealId) {
		
		dealRepository.deleteById(dealId);
		Deal deal=dealRepository.findById(dealId);
		if(deal==null)
			return "Deal Deleted";
		else
			return "Deal is not deleted";
	}

	@Override
	public DealResponse updateDeal(@Valid DealResponse request) {
		
		Deal deal = dealRepository.findById(request.getId());
		
		deal.setDestination(request.getDestination());
		deal.setPrice(request.getPrice());
		deal.setReturn_date(request.getReturn_date());
		deal.setSource(request.getSource());
		deal.setStart_date(request.getStart_date());
		
		Transporter transporter=transporterRepository.findById(request.getTransporter_id());
		deal.setTransporter(transporter);
		Vehicle vehicle=vehicleRepository.findById(request.getVehicle_id());
		deal.setVehicle(vehicle);
		
		Deal deal1 = dealRepository.findById(deal.getId());

		DealResponse response =new DealResponse();
		response.setId(deal1.getId());
		response.setDestination(deal1.getDestination());
		response.setPrice(deal1.getPrice());
		response.setReturn_date(deal1.getReturn_date());
		response.setSource(deal1.getSource());
		response.setStart_date(deal1.getStart_date());
		response.setTransporter_id(deal1.getTransporter().getId());
		response.setVehicle_id(deal1.getVehicle().getId());
		
		return response;
	}

	

}

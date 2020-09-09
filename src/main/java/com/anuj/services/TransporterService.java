package com.anuj.services;

import java.util.List;

import javax.validation.Valid;

import com.anuj.entities.Transporter;
import com.anuj.request.DealRequest;
import com.anuj.request.TransporterRequest;
import com.anuj.response.DealResponse;
import com.anuj.response.TransporterResponse;

public interface TransporterService {

	TransporterResponse saveTransporter( TransporterRequest request);

	String verifyTransporter( String username);

	DealResponse postDeal( DealRequest request);

	List<DealResponse> viewDeals( int transporterId);

	String deleteDeal(@Valid int dealId);

	DealResponse updateDeal(@Valid DealResponse request); 



	
}

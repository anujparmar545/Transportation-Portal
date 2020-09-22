package com.anuj.repository;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anuj.response.DealResponse;


@Repository
public class DealRepo {

	@Autowired
	@PersistenceContext(name = "default")
	private EntityManager entityManager;

	public List<DealResponse> viewCurrentDeals() {
		
		long millis=System.currentTimeMillis(); 
		Date date= new Date(millis);
		String s= "select * from Deal where start_date<= :currentDate and return_date>=:currentDate";
		
		Query query=entityManager.createNativeQuery(s,Tuple.class);
		query.setParameter("currentDate", date);
		@SuppressWarnings("unchecked")
		Stream<Tuple> resultStream = query.getResultStream();
		
		return resultStream.map(tuple -> getDealResponse(tuple)).collect(Collectors.toList());
		
		
	}

	private DealResponse getDealResponse(Tuple tuple) {
		
		DealResponse response= new DealResponse();
		response.setId((int)tuple.get(0));
		response.setDestination(tuple.get(1).toString());
		response.setPrice(tuple.get(2).toString());
		response.setReturn_date((Date)tuple.get(3));
		response.setSource(tuple.get(4).toString());
		response.setStart_date((Date)tuple.get(5));
		response.setTransporter_id((int)tuple.get(6));
		response.setVehicle_id((int)tuple.get(7));
		return response;
	}
	
	
	
}



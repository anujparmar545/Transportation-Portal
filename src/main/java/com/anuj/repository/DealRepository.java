package com.anuj.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anuj.entities.Deal;
import com.anuj.entities.Transporter;


@Repository
public interface DealRepository extends CrudRepository<Deal, Integer>{

	Deal findById(int id);
	List<Deal> findByTransporter(Transporter transporter);
}



package com.anuj.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anuj.entities.Transporter;


@Repository
public interface TransporterRepository extends CrudRepository<Transporter, Integer>{

	Transporter findByUsername(String username);
	Transporter findById(int id);
	Transporter findByUsernameAndPassword(String username, String password);
	List<Transporter> findAllBystatus(int status);


}



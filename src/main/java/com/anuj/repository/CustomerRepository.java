package com.anuj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anuj.entities.Customer;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

	Customer findById(int id);
	Customer findByUsernameAndPassword(String username, String password);
}



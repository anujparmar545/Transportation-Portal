package com.anuj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anuj.entities.Query;

@Repository
public interface QueryRepository extends CrudRepository<Query, Integer>{

}



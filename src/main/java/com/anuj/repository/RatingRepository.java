package com.anuj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anuj.entities.Rating;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Integer>{

}



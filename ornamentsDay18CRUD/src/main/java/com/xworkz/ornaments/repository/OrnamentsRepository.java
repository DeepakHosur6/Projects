package com.xworkz.ornaments.repository;

import java.util.Collections;
import java.util.List;

import com.xworkz.ornaments.entity.OrnamentsEntity;

public interface OrnamentsRepository {
	boolean save(OrnamentsEntity entity);  // Save
	
	boolean update(OrnamentsEntity entity); // Update

	default OrnamentsEntity findById(int id) {
		return null;
	}

	default List<OrnamentsEntity> findByName(String name) {
		return Collections.emptyList();
	}

	 default OrnamentsEntity deleteById(int id){
		return null;
	} 

	/*
	 * default boolean onDelete(int id){ return false; }
	 */

	
}

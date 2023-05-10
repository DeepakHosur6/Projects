package com.xworkz.ornaments.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.stereotype.Service;

import com.xworkz.ornaments.dto.OrnamentsDTO;

@Service
public interface OrnamentsService {

	Set<ConstraintViolation<OrnamentsDTO>> validateAndSave(OrnamentsDTO dto); // Save

	default OrnamentsDTO findById(int id) {
		return null;
	}

	default List<OrnamentsDTO> findByName(String name) {
		return Collections.emptyList();
	}

	Set<ConstraintViolation<OrnamentsDTO>> validateAndUpdate(OrnamentsDTO dto); // Update

	

	default OrnamentsDTO deleteById(int id) {
		return null;
	} 
	
	
}

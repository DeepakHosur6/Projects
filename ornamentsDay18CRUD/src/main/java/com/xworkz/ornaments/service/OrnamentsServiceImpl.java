package com.xworkz.ornaments.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.ornaments.dto.OrnamentsDTO;
import com.xworkz.ornaments.entity.OrnamentsEntity;
import com.xworkz.ornaments.repository.OrnamentsRepository;

@Service
public class OrnamentsServiceImpl implements OrnamentsService {
	@Autowired
	private OrnamentsRepository repository;

	public OrnamentsServiceImpl() {
		System.out.println("Constructor is Created in : " + this.getClass().getSimpleName());
	}

	@Override
	public Set<ConstraintViolation<OrnamentsDTO>> validateAndSave(OrnamentsDTO dto) {
		System.out.println("Set method");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<OrnamentsDTO>> violations = validator.validate(dto);

		if (violations != null && !violations.isEmpty()) {
			System.err.println("Violations in dto :" + dto);
			return violations;
		} else {
			System.out.println("Violations is not there in dto, can Procedure the save method");
			OrnamentsEntity entity = new OrnamentsEntity();
			entity.setName(dto.getName());
			entity.setFunctionDay(dto.getFunctionDay());
			entity.setType(dto.getType());
			entity.setPlace(dto.getPlace());

			boolean save = this.repository.save(entity);
			System.out.println("Entity Data is Saved to Repository " + save);
			return Collections.emptySet();
		}
	}

	@Override
	public OrnamentsDTO findById(int id) {
		if (id > 0) {
			OrnamentsEntity entity = this.repository.findById(id);

			if (entity != null) {
				System.out.println("Entity is found in the Service for id : " + id);
				OrnamentsDTO dto = new OrnamentsDTO();

				dto.setName(entity.getName());
				dto.setFunctionDay(entity.getFunctionDay());
				dto.setType(entity.getType());
				dto.setPlace(entity.getPlace());
				dto.setId(entity.getId());
				return dto;
			}
		}
		return OrnamentsService.super.findById(id);
	}

	@Override
	public List<OrnamentsDTO> findByName(String name) {
		System.out.println("---------------------------------------------------");
		System.out.println("Entity is findByName in the Service is : " + name);
		if (name != null && !name.isEmpty()) {
			System.out.println("Name is Valid ........ Calling Repository");
			List<OrnamentsEntity> entities = this.repository.findByName(name);
			// list <E> --> list <D>
			List<OrnamentsDTO> listOfDto = new ArrayList<OrnamentsDTO>();
			for (OrnamentsEntity entity : entities) {
				OrnamentsDTO dto = new OrnamentsDTO();
				dto.setName(entity.getName());
				dto.setFunctionDay(entity.getFunctionDay());
				dto.setId(entity.getId());
				dto.setPlace(entity.getPlace());
				dto.setType(entity.getType());

				listOfDto.add(dto); // adding to list.
			}
			System.out.println("size dto :" + listOfDto.size());
			System.out.println("size of entity :" + listOfDto.size());
			return listOfDto;
		} else {
			System.err.println(" Name is invalid");
		}

		return OrnamentsService.super.findByName(name);
	}

	@Override
	public Set<ConstraintViolation<OrnamentsDTO>> validateAndUpdate(OrnamentsDTO dto) {

		System.out.println("Set method");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<OrnamentsDTO>> violations = validator.validate(dto);

		if (violations != null && !violations.isEmpty()) {
			System.err.println("Violations in dto :" + dto);
			return violations;
		} else {
			System.out.println("Violations is not there in dto, can Procedure the update method");
			OrnamentsEntity entity = new OrnamentsEntity();
			entity.setName(dto.getName());
			entity.setFunctionDay(dto.getFunctionDay());
			entity.setType(dto.getType());
			entity.setPlace(dto.getPlace());
			entity.setId(dto.getId()); // IMP to update

			// boolean saved = this.repository.update(entity);
			boolean update = this.repository.update(entity);
			System.out.println("Entity Data is Updated  in Service " + update);
			return Collections.emptySet();
		}

	}

	@Override
	public OrnamentsDTO deleteById(int id) {
		System.out.println("Runnig delete by id in service:" + id);
		if (id > 0) {
			OrnamentsEntity entity = this.repository.deleteById(id);
			if (entity != null) {
				System.out.println("Entity is found in service for id " + id);
				OrnamentsDTO dto = new OrnamentsDTO();
				dto.setName(entity.getName());
				dto.setFunctionDay(entity.getFunctionDay());
				dto.setId(entity.getId());
				dto.setPlace(entity.getPlace());
				dto.setType(entity.getType());
				dto.setId(entity.getId());
				return dto;
			}
		}
		return OrnamentsService.super.deleteById(id);

	}

	/*
	 * @Override public boolean onDelete(int id) {
	 * 
	 * boolean deleted = repository.onDelete(id); return deleted; }
	 */
}

package com.xworkz.demo.services;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.demo.dto.SgroupDTO;

public interface SgroupService {

	Set<ConstraintViolation<SgroupDTO>> validateAndSave(SgroupDTO dto);

	default SgroupDTO userSignIn(String userId, String password) {
		return null;
	}

	default List<SgroupDTO> findAll() {
		return Collections.emptyList();

	}

	default Long findByUser(String user) {
		return null;

	}

	default Long findByEmail(String email) {
		return null;

	}

	default Long findByMobile(Long mobile) {
		return null;

	}

	default SgroupDTO updatePassword(String userId, String password, String confirmPassword) {
		return null;
	}

	default SgroupDTO reSetPassword(String email) {
		return null;
	}

	boolean sendMail(String email, String text);

}
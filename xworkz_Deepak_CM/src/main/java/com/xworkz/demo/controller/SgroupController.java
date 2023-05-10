package com.xworkz.demo.controller;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.xworkz.demo.dto.SgroupDTO;
import com.xworkz.demo.services.SgroupService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/")
@EnableWebMvc
public class SgroupController {

	@Autowired
	private SgroupService service;

	public SgroupController() {
		log.info("Constructor is Created in : " + this.getClass().getSimpleName());
		log.info("  : ");
	}

	@PostMapping("/display")
	public String onFam(SgroupDTO dto, Model model) {
		log.info("running in no violations condition ");
		Set<ConstraintViolation<SgroupDTO>> violation = this.service.validateAndSave(dto);
		if (violation != null && violation.isEmpty()) {

			log.info("running in no violations condition ");
			log.info("" + dto);
			model.addAttribute("signup", "Signup Data saved Successful");
			return "SignUp";
		}

		model.addAttribute("error", violation);
		model.addAttribute("message", " data not saved");
		// model.addAttribute("dto",dto);
		System.err.println("violation in controller");
		return "SignUp";
	}

	@PostMapping("/signin")
	public String userSignIn(String userId, String password, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		log.info("running in userSignIn condition");
		try {
			SgroupDTO dto = this.service.userSignIn(userId, password);
			log.info("Login count" + dto.getLoginCount());
			if (dto.getLoginCount() >= 3) {
				model.addAttribute("msg", "Account locked Reset password");
				log.info("Account locked dto to wrong password entering 3 times");
				return "SignIn";
			}
			if (dto != null) {
				if (dto.getResetPassword() == true) {
					log.info("Running in resetpassword true condition");
					if (!dto.getPasswordChangedTime().isAfter(LocalTime.now())) {
						log.info("running in time varifying condition");
						model.addAttribute("msgs", "time out plz try again");
						return "SignIn";
					}
					model.addAttribute("userId", dto.getUserId());
					log.info("running in reset condition");
					log.info("resetPassword" + dto.getResetPassword());
					log.info("Timer---" + dto.getPasswordChangedTime().isBefore(LocalTime.now()));
					return "updatePassword";
				}
				System.currentTimeMillis();
				log.info("UserId and Password are not matched, Please provide Valid UserId & Password.");
				HttpSession httpSession = request.getSession(true);
				httpSession.setAttribute("userId", dto.getUserId());
				httpSession.setAttribute("udto", dto);
				return "LoginSucess";
			}

		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
		}
		log.info("Failed: UserId and Password is not matched");
		model.addAttribute("match", "Sign in is Failed: User Id or Password is not Matched"); // web page message
		return "SignIn";
	}

	@PostMapping("/reset")
	public String reSetPassword(String email, Model model) {
		try {
			SgroupDTO dto = this.service.reSetPassword(email);
			if (dto.getResetPassword() == true) {
				model.addAttribute("msg", "PASSWORD reset successfully, please login: ");
				return "resetPassword";
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
		}

		return "resetPassword";
	}

	@PostMapping("/passwordUpdate")
	public String upDatePassword(String userId, String password, String confirmPassword) {
		log.info("Running in upDatePassword method");
		this.service.updatePassword(userId, password, confirmPassword);
		return "sucess";

	}
}

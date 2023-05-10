package com.xworkz.demo.services;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.demo.dto.SgroupDTO;
import com.xworkz.demo.entity.SgroupEntity;
import com.xworkz.demo.repository.SgroupRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SgroupServiceImpl implements SgroupService {

	@Autowired
	private SgroupRepo repo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public SgroupServiceImpl() {
		log.info("created" + this.getClass().getSimpleName());
	}

	private Set<ConstraintViolation<SgroupDTO>> validate(SgroupDTO dto) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<SgroupDTO>> violations = validator.validate(dto);
		return violations;
	}

	@Override
	public Set<ConstraintViolation<SgroupDTO>> validateAndSave(SgroupDTO dto) {
		Long emailCount = this.repo.findByEmail(dto.getEmail());
		Long userCount = this.repo.findByUser(dto.getUserId());
		Long mobileCount = this.repo.findByMobile(dto.getMobile());
		System.err.println("emailCount- : " + emailCount);
		System.err.println("userCount- : " + userCount);
		System.err.println("mobileCount- : " + mobileCount);

		Set<ConstraintViolation<SgroupDTO>> violations = validate(dto);
		if (violations != null && !violations.isEmpty()) {
			log.info("Violation in dto : " +violations);
			return violations;
		}
		if (!dto.getPassword().equals(dto.getConfirmPassword())) {
			log.info("Password is not matching");
			log.error("-----Password is not matching------");
			return null;
		}
		if (emailCount == 0 && userCount == 0 && mobileCount == 0) {

			log.info("No Violation, Processing to Save Data");

			SgroupEntity entity = new SgroupEntity();
			entity.setCreateBy(dto.getUserId());
			entity.setCreateDate(LocalDateTime.now());
			// BeanUtils.copyProperties(dto, entity);
			entity.setPassword(passwordEncoder.encode(dto.getPassword()));
			entity.setUserId(dto.getUserId());
			entity.setEmail(dto.getEmail());
			entity.setAcceptAgreement(dto.getAcceptAgreement());
			entity.setMobile(dto.getMobile());
			entity.setResetPassword(false);
			entity.setPasswordChangedTime(LocalTime.of(0, 0, 0));
			boolean saved = this.repo.save(entity);

			log.info("entity is saved" + saved);

			if (saved) {
				boolean sent = this.sendMail(dto.getEmail(), "Thanks for Registration, in Deepak Login Common Module...");
				log.info("Email sent Successfully... :  " + sent);
			}
		}
		return Collections.emptySet();
	}

	@Override
	public SgroupDTO userSignIn(String userId, String password) {
		SgroupEntity entity = this.repo.userSignIn(userId);
		SgroupDTO dto = new SgroupDTO();
		BeanUtils.copyProperties(entity, dto);
		log.info("Running userSign() in SgroupService ");
		log.info("matching" + passwordEncoder.matches(password, entity.getPassword()));
		log.info("Time matching--" + entity.getPasswordChangedTime().isBefore(LocalTime.now()));
		log.info("Now Present time--" + LocalTime.now());
		log.info("PasswordChangedTime--" + entity.getPasswordChangedTime());
		log.info("Time--" + LocalTime.now().isBefore(entity.getPasswordChangedTime()));

		if (entity.getLoginCount() >= 3) {
			log.info("Running in login count condition");
			return dto;
		}
		// dto.setUserId(entity.getUserId());
		// dto.setPassword(entity.getPassword());
		if (dto.getUserId().equals(userId) && passwordEncoder.matches(password, entity.getPassword())) {
			log.info("Running userId Matching and Password matching in userSign() in SgroupService");
			return dto;
		} else {
			this.repo.logincount(userId, entity.getLoginCount() + 1);
		    log.info("count of login : "+ entity.getLoginCount() + 1);
		}
		return null;
	}

	@Override
	public List<SgroupDTO> findAll() {
		log.info("Running findALL() in SgroupService ");
		List<SgroupEntity> sEntity = this.repo.findAll();
		List<SgroupDTO> lists = new ArrayList<SgroupDTO>();
		for (SgroupEntity entity : sEntity) {
			SgroupDTO dto = new SgroupDTO();
			BeanUtils.copyProperties(entity, dto);
			lists.add(dto);
		}
		return lists;
	}

	@Override
	public Long findByEmail(String email) {
		log.info("Running findByEmail() in SgroupService ");
		Long emailcount = this.repo.findByEmail(email);
		System.err.println("Find by Emai : l");
		return emailcount;
	}

	@Override
	public Long findByMobile(Long mobile) {
		log.info("Running findByMobile() in SgroupService ");
		Long mobilecount = this.repo.findByMobile(mobile);
		return mobilecount;

	}

	@Override
	public Long findByUser(String user) {
		log.info("Running findByUser() in SgroupService ");
		Long usercount = this.repo.findByUser(user);
		return usercount;
	}

	@Override
	public SgroupDTO reSetPassword(String email) {
		log.info("Running in reSetPassword() in SgroupService");
		String reSetPassword = DefaultPasswordGenerator.generate(6);
		log.info("Reset password -->: " + reSetPassword);
		SgroupEntity entity = this.repo.reSetPassword(email);
		if (entity != null) {
			log.info("Entity found for email is : " + email);
			entity.setPassword(passwordEncoder.encode(reSetPassword));
			entity.setUpdateBy("System");
			entity.setUpdateDate(LocalDateTime.now());
			entity.setLoginCount(0);
			entity.setResetPassword(true);
			entity.setPasswordChangedTime(LocalTime.now().plusSeconds(120));
			boolean update = this.repo.update(entity);
			if (update) {
				sendMail(entity.getEmail(), "You'r reset password is -->: " + reSetPassword
						+ "Please login again within 2 min with this Password.");
			}
			log.info("updated--" + update);
			SgroupDTO dto = new SgroupDTO();
			BeanUtils.copyProperties(entity, dto);
			return dto;
		}
		log.info("Entity not found for email--" + email);
		return SgroupService.super.reSetPassword(email);
	}

	@Override
	public SgroupDTO updatePassword(String userId, String password, String confirmPassword) {
		//SgroupEntity entity = new SgroupEntity();
		log.info("Running UpDatePassword() in SgroupService--"+password, confirmPassword);
		if (password.equals(confirmPassword)) {
			boolean passwordUpdated = this.repo.updatePassword(userId, passwordEncoder.encode(password), false,
					LocalTime.of(0, 0, 0));
			log.info("Password Updated--" + passwordUpdated);
		}
		return SgroupService.super.updatePassword(userId, password, confirmPassword);

	}

	@Override
	public boolean sendMail(String email, String text) {
		log.info("Running sendMail() in SgroupService.");
		String reSetPassword = DefaultPasswordGenerator.generate(6);
		String portNumber = "587";
		String hostName = "smtp.office365.com";
		String fromEmail = "deepakh.xworkz@outlook.com";
		String password = "Deep@koutlook6";
		// String email1 = email;
		String to = email;

		Properties prop = new Properties();
		prop.put("mail.smtp.host", hostName);
		prop.put("mail.smtp.port", portNumber);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.debug", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.transport.protocal", "smtp");

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		}
		);

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(fromEmail));
			// message.setSubject("Registration completed");
			message.setText("Reseting password is Successfully" + reSetPassword);
			message.setText(text);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(message);
			log.info("--Email send is Successfully--");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return true;
	}

	public final static class DefaultPasswordGenerator {
		private static final String[] charCategories = new String[] { "abcdefghijklmnopqrstuvwxyz",
				"ABCDEFGHIJKLMNOPQRSTUVWXYZ", "0123456789" };

		public static String generate(int length) {
			StringBuilder password = new StringBuilder(length);
			Random random = new Random(System.nanoTime());

			for (int i = 0; i < length; i++) {
				String charCategory = charCategories[random.nextInt(charCategories.length)];
				int position = random.nextInt(charCategory.length());
				password.append(charCategory.charAt(position));
			}
			return new String(password);
		}
		// String password =DefaultPasswordGenerator.generate(6);
	}
}


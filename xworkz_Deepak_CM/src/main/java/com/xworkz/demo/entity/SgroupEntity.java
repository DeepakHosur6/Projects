package com.xworkz.demo.entity;


import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "signup_table2")
@NamedQuery(name = "find", query = "select ent from SgroupEntity ent")
@NamedQuery(name = "userId", query = "select count(*) from SgroupEntity ent where ent.userId=:userBy")
@NamedQuery(name = "emailId", query = "select count(*) from SgroupEntity ent where ent.email=:emailBy")
@NamedQuery(name = "mobileId", query = "select count(*) from SgroupEntity ent where ent.mobile=:mobileBy")
@NamedQuery(name = "userANDpassword", query = "select ent from SgroupEntity ent where ent.userId=:ui")
@NamedQuery(name = "updateLoginCount", query = "update SgroupEntity ent set ent.loginCount=:count where ent.userId=:ui")
@NamedQuery(name = "updatePassword", query = "update SgroupEntity ent set ent.password=:up, ent.resetPassword=:urp, ent.passwordChangedTime=:pct where ent.userId=:uu")
@NamedQuery(name = "emailid", query = "select ent from SgroupEntity ent where ent.email=:ei")
public class SgroupEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "s_signupId")
	private int signupId;
	
	@Column(name = "s_userId")
	private String userId;
	
	@Column(name = "s_email")
	private String email;
	
	@Column(name = "s_mobile")
	private long mobile;
	
	@Column(name = "s_password")
	private String password;
	
	@Column(name = "s_acceptAgreement")
	private Boolean acceptAgreement;
	
	@Column(name = "createBy")
	private String createBy;
	
	@Column(name = "s_createDate")
	private LocalDateTime createDate;
	
	@Column(name = "s_updateBy")
	private String updateBy;
	
	@Column(name = "s_updateDate")
	private LocalDateTime updateDate;
	
	@Column(name = "logincount")
	private int loginCount;
	
	@Column(name = "resetPassword")
	private Boolean resetPassword;
	
	@Column(name = "passwordChangedTime")
	private LocalTime passwordChangedTime;

}
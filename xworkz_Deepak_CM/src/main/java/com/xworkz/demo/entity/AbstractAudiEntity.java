package com.xworkz.demo.entity;

import java.time.LocalDateTime;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public class AbstractAudiEntity{

	//@Column(name="s_createBy")
	private String createBy;
	//@Column(name="s_createDate")
	private LocalDateTime createDate;
	//@Column(name="s_updateBy")
	private String updateBy;
	//@Column(name="s_updateDate")
	private LocalDateTime updateDate;
}

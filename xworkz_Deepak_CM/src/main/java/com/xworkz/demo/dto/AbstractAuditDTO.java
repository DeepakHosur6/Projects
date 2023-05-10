package com.xworkz.demo.dto;

import java.io.Serializable;

public class AbstractAuditDTO implements Serializable {
	private String createdBy;
	private int createdDate;
	private String updateBy;
	private int updateDate;

	public String getCreatedBy() {
		return createdBy;
	}

	public int getCreatedDate() {
		return createdDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public int getUpdateDate() {
		return updateDate;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedDate(int createdDate) {
		this.createdDate = createdDate;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public void setUpdateDate(int updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "AbstractAuditDTO [createdBy=" + createdBy + ", createdDate=" + createdDate + ", updateBy=" + updateBy
				+ ", updateDate=" + updateDate + "]";
	}

}

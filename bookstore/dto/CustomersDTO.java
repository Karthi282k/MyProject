package com.bookstore.dto;

import java.util.Date;

public class CustomersDTO {
	private Integer cxId;

	private String cxName;

	private String mail;
	private Character gender;

	private Long contactNo;

	private Date createdAt;

	private Date updatedAt;

	public Integer getCxId() {
		return cxId;
	}

	public void setCxId(Integer cxId) {
		this.cxId = cxId;
	}

	public String getCxName() {
		return cxName;
	}

	public void setCxName(String cxName) {
		this.cxName = cxName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "CustomersDTO [cxId=" + cxId + ", cxName=" + cxName + ", mail=" + mail + ", gender=" + gender
				+ ", contactNo=" + contactNo + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}

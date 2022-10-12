package com.bookstore.dto;

import java.util.Date;

import com.bookstore.entity.Customer;

public class OrderDTO {
	private Integer orderId;

	private String bookName;

	private Float bookPrice;

	private Date createdAt;

	private Date updatedAt;
	Customer customers;

	public Customer getCustomers() {
		return customers;
	}

	public void setCustomers(Customer customers) {
		this.customers = customers;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Float getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Float bookPrice) {
		this.bookPrice = bookPrice;
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
		return "OrderDTO [orderId=" + orderId + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", customers=" + customers + "]";
	}

}

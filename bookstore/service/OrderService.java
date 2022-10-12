package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookstore.bo.OrderBO;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Order;

@Component
public class OrderService {
	@Autowired
	OrderBO bo = null;

	public Order addOrder(Order o) {
		return bo.addOrder(o);
	}

	public Order findOrder(int orderId) {
		return bo.findOrder(orderId);

	}

	public List<Order> findAll() {
		return bo.findAll();
	}

}

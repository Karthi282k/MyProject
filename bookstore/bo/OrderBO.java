package com.bookstore.bo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookstore.dao.OrderRepository;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Order;

@Component
public class OrderBO {
	@Autowired
	OrderRepository or;

	public Order addOrder(Order o) {
		return or.save(o);
	}

	public Order findOrder(int orderId) {
		Optional<Order> o = or.findById(orderId);
		return o.get();

	}

	public List<Order> findAll() {
		return or.findAll();
	}
}

package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.bo.CustomerBO;
import com.bookstore.bo.OrderBO;
import com.bookstore.dao.CustomersCustomized;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Order;

@Component
public class CustomerService {
	@Autowired
	CustomerBO bo = null;
	@Autowired
	OrderBO bo2;
	@Autowired
	CustomerBO bo1;

	public Customer addCustomer(Customer c) {
		return bo.addCustomer(c);

	}

	public Customer updateCustomer(Customer customer) {
		Integer customerId = customer.getCxId();
		Customer cx = bo.findCustomer(customerId);
		cx.setCxName(customer.getCxName());
		cx.setGender(customer.getGender());
		cx.setMail(customer.getMail());
		cx.setContactNo(customer.getContactNo());
		return bo.addCustomer(cx);

	}

	public Customer findCustomer(int cxId) {
		return bo.findCustomer(cxId);

	}

	public List<Customer> findAll() {
		return bo.findAll();
	}

	public List<Customer> findCustomersById(int id1) {
		return bo.findCustomersById(id1);
	}

	public List<Customer> findCustomersByGender(char gender1) {
		return bo.findCustomersByGender(gender1);
	}

	public List<CustomersCustomized> findNameAndMailByGender(char gender1) {
		return bo.findNameAndMailByGender(gender1);
	}

	public List<Customer> findAllDescOrder() {
		return bo.findAllDescOrder();
	}

	public List<Customer> findCustomerWithOrder() {
		return bo.findCustomerWithOrder();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void transactiondemo(Customer c1, Order o) {
		System.out.println("customer add before ");
		bo1.addCustomer(c1);
		System.out.println("customer add after ");
		System.out.println("order add before ");
		bo2.addOrder(o);
		System.out.println("customer add after ");
	}

}

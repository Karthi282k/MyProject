package com.bookstore.bo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookstore.dao.CustomersCustomized;
import com.bookstore.dao.CustomersRepository;
import com.bookstore.entity.Customer;

@Component
public class CustomerBO {
	@Autowired
	CustomersRepository cr;

	public Customer addCustomer(Customer c) {
		return cr.save(c);
	}
	

	public Customer findCustomer(int cxId) {
		Optional<Customer> r = cr.findById(cxId);
		return r.get();

	}

	public List<Customer> findAll() {
		return cr.findAll();
	}

	public List<Customer> findCustomersById(int id1) {
		return cr.findCustomersById(id1);
	}

	public List<Customer> findCustomersByGender(char gender1) {
		return cr.findCustomersByGender(gender1);
	}

	public List<CustomersCustomized> findNameAndMailByGender(char gender1) {
		return cr.findNameAndMailByGender(gender1);
	}

	public List<Customer> findAllDescOrder() {
		return cr.findAllNameByDesc();
	}

	public List<Customer> findCustomerWithOrder() {
		return cr.findCustomerWithOrder();
	}

}

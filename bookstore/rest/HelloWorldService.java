package com.bookstore.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bo.CustomerBO;
import com.bookstore.bo.OrderBO;
import com.bookstore.dao.CustomersCustomized;
import com.bookstore.dto.CustomersDTO;
import com.bookstore.dto.OrderDTO;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Order;
import com.bookstore.service.CustomerService;
import com.bookstore.service.OrderService;

@RestController
@CrossOrigin(origins="http://localhost:4200")

public class HelloWorldService {
	@Autowired
	CustomerService service1;
	@Autowired
	OrderService service2;

	@RequestMapping(value = "/sayHello", method = RequestMethod.GET)
	public String sayHello() {
		return "sayHello";
	}

	@RequestMapping(value = "/sayHelloUser")
	public String sayHelloUser(@RequestParam(value = "name", defaultValue = "jim") String name,
			@RequestParam(value = "phone", required = false) String phone) {
		return "Say Hello to" + name + "phone:" + phone;

	}

	@RequestMapping("/GreetingUser")
	public GreetingMessage greetinguser() {
		GreetingMessage msg = new GreetingMessage();
		msg.setGreeting("------HELLO----");
		msg.setName("karthi");
		return msg;

	}

	@RequestMapping("/GreetingUserName")
	public GreetingMessage greetingUser(@RequestParam(value = "name", defaultValue = "jim") String name,
			@RequestParam(value = "msg") String message) {
		GreetingMessage msg = new GreetingMessage();
		msg.setGreeting(message);
		msg.setName(name);
		return msg;

	}

	@RequestMapping("/SearchUser")
	public List<Users> SearchUser(String searchString) {
		System.out.println(searchString);
		List<Users> list = new ArrayList<>();
		Users u1 = new Users();
		u1.setName("karthi");
		u1.setAge(22);

		Users u2 = new Users();
		u2.setName("priya");
		u2.setAge(23);

		list.add(u1);
		list.add(u2);
		return list;

	}

	@RequestMapping("/SearchUserMap")
	public Map<String, Users> searchUsersMap(String searchString) {
		Map<String, Users> map = new HashMap<>();
		Users u1 = new Users();
		u1.setName("karthi");
		u1.setAge(22);

		Users u2 = new Users();
		u2.setName("karthee");
		u2.setAge(25);

		map.put(u1.getName(), u1);
		map.put(u2.getName(), u2);
		return map;

	}

	@RequestMapping(value = "/createCustomers", method = RequestMethod.POST)
	public CustomersDTO addCustomer(@RequestBody CustomersDTO add) {
		Customer c = new Customer();
		c.setCxName(add.getCxName());
		c.setMail(add.getMail());
		c.setGender(add.getGender());
		c.setContactNo(add.getContactNo());
		Customer c1 = service1.addCustomer(c);
		add.setCxId(c1.getCxId());
		add.setCreatedAt(c1.getCreatedAt());
		add.setUpdatedAt(c1.getUpdatedAt());
		return add;

	}
	
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.PUT)
	public Customer updteCustomer(@RequestBody Customer customer) {
		return service1.updateCustomer(customer);
	}

	@RequestMapping(value = "/fetchCustomerById", method = RequestMethod.POST)
	public CustomersDTO fetchCustomerById(@RequestBody String cxId) {
		Customer c = service1.findCustomer(new Integer(cxId));
		CustomersDTO dto = new CustomersDTO();
		dto.setCreatedAt(c.getCreatedAt());
		dto.setUpdatedAt(c.getUpdatedAt());
		dto.setCxId(c.getCxId());
		dto.setCxName(c.getCxName());
		dto.setGender(c.getGender());
		dto.setMail(c.getMail());
		dto.setContactNo(c.getContactNo());
		return dto;
	}

	@RequestMapping(value = "/fetchCustomers", method = RequestMethod.POST)
	public List<CustomersDTO> fetchCustomers() {
		List list = service1.findAll();
		return list;
	}

	@RequestMapping(value = "/createBook", method = RequestMethod.POST)
	public OrderDTO addOrder(@RequestBody OrderDTO add) {
		Customer customerResponse = service1.findCustomer(add.getCustomers().getCxId());
		Order o = new Order();
		o.setBookName(add.getBookName());
		o.setBookPrice(add.getBookPrice());
		o.setCustomers(customerResponse);
		Order o1 = service2.addOrder(o);
		add.setOrderId(o1.getOrderId());
		add.setCreatedAt(o1.getCreatedAt());
		add.setUpdatedAt(o1.getUpdatedAt());
		add.setCustomers(customerResponse);

		return add;

	}

	@RequestMapping(value = "/fetchOrderById", method = RequestMethod.POST)
	public OrderDTO fetchOrderById(@RequestBody String orderId) {
		Order o = service2.findOrder(new Integer(orderId));
		OrderDTO dto = new OrderDTO();
		dto.setOrderId(o.getOrderId());
		dto.setBookName(o.getBookName());
		dto.setBookPrice(o.getBookPrice());
		dto.setCreatedAt(o.getCreatedAt());
		dto.setUpdatedAt(o.getUpdatedAt());
		dto.setCustomers(o.getCustomers());
		return dto;

	}

	@RequestMapping(value = "/fetchOrder", method = RequestMethod.POST)
	public List<OrderDTO> fetchOrder() {
		List list = service2.findAll();
		return list;
	}

//named query
	@RequestMapping(value = "/fetchCustomersByDesc", method = RequestMethod.POST)
	public List<CustomersDTO> fetchCustomersByDesc() {
		List list = service1.findAllDescOrder();
		return list;
	}

//custom query
	@RequestMapping(value = "/fetchCustomerById2", method = RequestMethod.POST)
	public List<CustomersDTO> fetchCustomerById2(@RequestBody String cxId) {
		List list = service1.findCustomersById(new Integer(cxId));
		return list;

	}

}

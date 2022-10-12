package com.bookstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookstore.entity.Customer;

@Repository
public interface CustomersRepository extends JpaRepository<Customer, Integer> {

	@Query(value = "select c from Customer c where c.cxId<=:id1")
	List<Customer> findCustomersById(@Param("id1") Integer cxId);

	@Query("select c from  Customer c where c.gender=:gender1")
	List<Customer> findCustomersByGender(@Param("gender1") Character gender);

	@Query("select c.cxName as cxName,c.mail as mail from Customer c where c.gender = :gender1")
	List<CustomersCustomized> findNameAndMailByGender(@Param("gender1") Character gender);

	List<Customer> findAllNameByDesc();

	@Query("select c from Customer c JOIN Order o on c.cxId=o.customers")
	List<Customer> findCustomerWithOrder();

}

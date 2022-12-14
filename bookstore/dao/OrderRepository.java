package com.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.entity.Order;

@Repository

public interface OrderRepository extends JpaRepository<Order, Integer> {

}

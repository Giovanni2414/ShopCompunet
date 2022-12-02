package com.icesi.edu.Shop.repository;

import com.icesi.edu.Shop.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<Order, UUID> {
}

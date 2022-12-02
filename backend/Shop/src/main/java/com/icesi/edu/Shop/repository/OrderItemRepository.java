package com.icesi.edu.Shop.repository;

import com.icesi.edu.Shop.model.OrderItem;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderItemRepository extends CrudRepository<OrderItem, UUID> {
}

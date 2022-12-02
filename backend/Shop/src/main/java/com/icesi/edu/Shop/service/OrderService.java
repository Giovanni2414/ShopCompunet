package com.icesi.edu.Shop.service;

import com.icesi.edu.Shop.dto.OrderItemToCreateDTO;
import com.icesi.edu.Shop.model.Order;

import java.util.List;
import java.util.UUID;

public interface OrderService {

    public Order createOrder(List<OrderItemToCreateDTO> orderItemToCreateDTOList);

    public void deleteOrder(UUID orderId);

}

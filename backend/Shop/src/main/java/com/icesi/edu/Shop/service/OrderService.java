package com.icesi.edu.Shop.service;

import com.icesi.edu.Shop.dto.OrderItemToCreateDTO;
import com.icesi.edu.Shop.model.Order;

import java.util.List;

public interface OrderService {

    public Order createOrder(List<OrderItemToCreateDTO> orderItemToCreateDTOList);

}

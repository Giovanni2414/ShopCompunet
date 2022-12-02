package com.icesi.edu.Shop.controller;

import com.icesi.edu.Shop.api.OrderAPI;
import com.icesi.edu.Shop.dto.OrderDTO;
import com.icesi.edu.Shop.dto.OrderItemToCreateDTO;
import com.icesi.edu.Shop.mapper.OrderMapper;
import com.icesi.edu.Shop.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderController implements OrderAPI {

    public final OrderMapper orderMapper;

    public final OrderService orderService;

    @Override
    public OrderDTO createOrder(List<OrderItemToCreateDTO> orderItemToCreateDTOList) {
        return orderMapper.fromOrder(orderService.createOrder(orderItemToCreateDTOList));
    }
}

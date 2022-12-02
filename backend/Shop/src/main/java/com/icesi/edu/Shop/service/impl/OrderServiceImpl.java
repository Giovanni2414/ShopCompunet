package com.icesi.edu.Shop.service.impl;

import com.icesi.edu.Shop.dto.OrderItemToCreateDTO;
import com.icesi.edu.Shop.model.Computer;
import com.icesi.edu.Shop.model.Order;
import com.icesi.edu.Shop.model.OrderItem;
import com.icesi.edu.Shop.repository.ComputerRepository;
import com.icesi.edu.Shop.repository.OrderItemRepository;
import com.icesi.edu.Shop.repository.OrderRepository;
import com.icesi.edu.Shop.security.SecurityContextHolder;
import com.icesi.edu.Shop.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    public final OrderRepository orderRepository;
    public final ComputerRepository computerRepository;
    public final OrderItemRepository orderItemRepository;

    @Override
    public Order createOrder(List<OrderItemToCreateDTO> orderItemToCreateDTOList) {
        Order order = new Order();
        List<Computer> computers = new ArrayList<>();
        orderItemToCreateDTOList.forEach((p) -> {
            computers.add(computerRepository.findById(p.getComputer()).orElse(null));
        });
        computers.forEach((p) -> {
            order.setTotal(order.getTotal() + p.getPrice());
        });
        order.setStatus("Pending");
        order.setUserId(SecurityContextHolder.getContext().getUserId());
        Order createdOrder = orderRepository.save(order);
        for (int c = 0; c < computers.size(); c++) {
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(orderItemToCreateDTOList.get(c).getQuantity());
            orderItem.setComputer(computers.get(c));
            orderItem.setOrder_id(createdOrder.getOrderId());
            orderItemRepository.save(orderItem);
        }
        return orderRepository.findById(createdOrder.getOrderId()).orElse(null);
    }
}

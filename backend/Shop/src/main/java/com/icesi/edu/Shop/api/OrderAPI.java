package com.icesi.edu.Shop.api;

import com.icesi.edu.Shop.dto.OrderDTO;
import com.icesi.edu.Shop.dto.OrderItemToCreateDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public interface OrderAPI {

    @PostMapping
    public OrderDTO createOrder(@RequestBody List<OrderItemToCreateDTO> orderItemToCreateDTOList);

}

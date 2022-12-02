package com.icesi.edu.Shop.api;

import com.icesi.edu.Shop.dto.OrderDTO;
import com.icesi.edu.Shop.dto.OrderItemToCreateDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public interface OrderAPI {

    @PostMapping
    public OrderDTO createOrder(@RequestBody List<OrderItemToCreateDTO> orderItemToCreateDTOList);

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable UUID orderId);

}

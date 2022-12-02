package com.icesi.edu.Shop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.icesi.edu.Shop.enums.OrderStates;
import com.icesi.edu.Shop.model.OrderItem;

import java.util.List;
import java.util.UUID;

@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","FieldHandler"})
public class OrderDTO {

    private UUID orderId;

    private double total;

    private String status;

    private List<OrderItemDTO> orderItems;

}

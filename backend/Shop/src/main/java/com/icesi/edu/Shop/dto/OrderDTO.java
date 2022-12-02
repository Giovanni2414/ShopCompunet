package com.icesi.edu.Shop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.icesi.edu.Shop.enums.OrderStates;
import com.icesi.edu.Shop.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","FieldHandler"})
public class OrderDTO {

    private UUID orderId;

    private double total;

    private String status;

    private List<OrderItemDTO> orderItems;

}

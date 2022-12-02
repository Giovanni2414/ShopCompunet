package com.icesi.edu.Shop.dto;

import com.icesi.edu.Shop.model.Computer;
import com.icesi.edu.Shop.model.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO {

    private UUID orderItemId;

    private int quantity;

    private UUID order_id;

    private Computer computer;

}

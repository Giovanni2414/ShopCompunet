package com.icesi.edu.Shop.mapper;

import com.icesi.edu.Shop.dto.OrderItemDTO;
import com.icesi.edu.Shop.model.Order;
import com.icesi.edu.Shop.model.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    Order fromOrderItemDTO(OrderItemDTO orderItemDTO);

    OrderItemDTO fromOrderItem(OrderItem orderItem);

}

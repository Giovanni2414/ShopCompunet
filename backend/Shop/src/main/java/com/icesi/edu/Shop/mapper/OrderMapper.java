package com.icesi.edu.Shop.mapper;

import com.icesi.edu.Shop.dto.OrderDTO;
import com.icesi.edu.Shop.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order fromOrderDTO(OrderDTO orderDTO);

    OrderDTO fromOrder(Order order);

}

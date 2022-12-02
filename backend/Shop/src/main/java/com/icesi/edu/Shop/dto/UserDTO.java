package com.icesi.edu.Shop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.icesi.edu.Shop.model.Order;
import com.icesi.edu.Shop.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","FieldHandler"})
public class UserDTO {

    private UUID id;

    private String email;

    private String address;

    private String phoneNumber;

    private Role rol;

    private List<OrderDTO> userOrders;

}

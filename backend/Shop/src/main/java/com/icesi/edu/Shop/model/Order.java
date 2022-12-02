package com.icesi.edu.Shop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.icesi.edu.Shop.enums.OrderStates;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString(exclude = "orderItems")
@EqualsAndHashCode(exclude = "orderItems")
@Entity
@Table(name = "`orders`")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","FieldHandler"})                
public class Order {

    @Id
    @Type(type="org.hibernate.type.PostgresUUIDType")
    @Column(name = "order_id")
    private UUID orderId;

    @Column(name = "order_total")
    private double total;

    @Column(name = "order_status")
    private String status;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @PrePersist
    public void generateId(){
        this.orderId = UUID.randomUUID();
    }

}

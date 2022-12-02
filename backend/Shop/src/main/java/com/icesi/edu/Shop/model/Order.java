package com.icesi.edu.Shop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.icesi.edu.Shop.enums.OrderStates;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
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

    @OneToMany()
    @JoinColumn(name = "order_id")
    private List<OrderItem> orderItems;

    @PrePersist
    public void generateId(){
        this.orderId = UUID.randomUUID();
    }

}

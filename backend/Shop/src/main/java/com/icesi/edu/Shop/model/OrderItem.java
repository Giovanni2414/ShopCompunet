package com.icesi.edu.Shop.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "`orders_items`")
public class OrderItem {

    @Id
    @Type(type="org.hibernate.type.PostgresUUIDType")
    @Column(name = "order_item_id")
    private UUID orderItemId;

    @Column(name = "order_item_quantity")
    private int quantity;

    @OneToOne()
    @JoinColumn(name = "order_item_id")
    private Computer computer;

    @PrePersist
    public void generateId(){
        this.orderItemId = UUID.randomUUID();
    }

}

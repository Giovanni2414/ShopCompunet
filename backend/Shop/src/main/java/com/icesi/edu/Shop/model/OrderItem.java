package com.icesi.edu.Shop.model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@Table(name = "`orders_items`")
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @Type(type="org.hibernate.type.PostgresUUIDType")
    @Column(name = "order_item_id")
    private UUID orderItemId;

    @Column(name = "order_item_quantity")
    private int quantity;

    @ManyToOne()
    @JoinColumn(name = "order_item_order_id")
    private Order order;

    @OneToOne()
    @JoinColumn(name = "order_item_computer_id")
    private Computer computer;

    @PrePersist
    public void generateId(){
        this.orderItemId = UUID.randomUUID();
    }

}

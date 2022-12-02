package com.icesi.edu.Shop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.icesi.edu.Shop.dto.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Table(name="`user`")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","FieldHandler"})
public class User {
    @Id
    @Type(type="org.hibernate.type.PostgresUUIDType")
    @Column(name = "user_id")
    private UUID id;

    private String email;

    private String password;

    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany()
    @JoinColumn(name = "user_id")
    private List<Order> userOrders;

    @PrePersist
    public void generateId(){
        this.id = UUID.randomUUID();
    }
}

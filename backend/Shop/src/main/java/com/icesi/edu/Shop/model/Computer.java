package com.icesi.edu.Shop.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;


@Data
@Table(name="`computers`")
@Entity
public class Computer {

    @Id
    @Type(type="org.hibernate.type.PostgresUUIDType")
    @Column(name = "computer_id")
    private UUID computerId;

    @Column(name = "computer_name")
    private String name;

    @Column(name = "computer_description")
    private String description;

    @Column(name = "computer_price")
    private double price;

    @Column(name = "computer_image_path")
    private String imagePath;

    @PrePersist
    public void generateId(){
        this.computerId = UUID.randomUUID();
    }

}

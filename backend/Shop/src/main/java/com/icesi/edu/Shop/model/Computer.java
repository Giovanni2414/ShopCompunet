package com.icesi.edu.Shop.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;


@Data
@Table(name="`computers`")
@Entity
public class Computer {

    @Id
    @Type(type="org.hibernate.type.PostgresUUIDType")
    @Column(name = "role_id")
    private UUID computerId;

}

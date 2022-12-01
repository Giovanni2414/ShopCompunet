package com.icesi.edu.Shop.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "`user_permission`")
@Entity
@Data
public class Permission {

    @Id
    @Type(type="org.hibernate.type.PostgresUUIDType")
    @Column(name = "permission_id")
    private UUID permissionId;

    private String uri;

    @Column(name = "permission_key")
    private String permissionKey;

    @Column(name = "permission_method")
    private String method;

    @PrePersist
    public void generateId(){
        this.permissionId = UUID.randomUUID();
    }
}
package com.icesi.edu.Shop.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.UUID;

@Data
public class ComputerDTO {

    private UUID computerId;

    private String name;

    private String description;

    private double price;

    private String imagePath;

}

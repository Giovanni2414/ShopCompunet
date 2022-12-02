package com.icesi.edu.Shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComputerDTO {

    private UUID computerId;

    private String name;

    private String description;

    private double price;

    private String imagePath;

}

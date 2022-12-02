package com.icesi.edu.Shop.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OrderStates {
    CANCELADA("Cancelada"),
    PENDIENTE("Pendiente"),
    COMPLETA("Completa");
    String state;
}

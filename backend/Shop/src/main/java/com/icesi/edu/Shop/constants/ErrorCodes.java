package com.icesi.edu.Shop.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodes {

    CODE_UD_01("debe estar authenticado para realizar este request"),
    CODE_UD_02("token invalido"),
    CODE_UD_03("There must be an email or phone number");

    private String message;

}

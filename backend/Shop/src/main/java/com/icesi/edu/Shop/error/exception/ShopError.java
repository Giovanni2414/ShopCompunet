package com.icesi.edu.Shop.error.exception;

import com.icesi.edu.Shop.constants.ErrorCodes;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ShopError {
    private ErrorCodes code;
    private String message;
}
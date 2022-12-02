package com.icesi.edu.Shop.error.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class ShopException extends RuntimeException {
    private HttpStatus httpStatus;
    private ShopError error;
}
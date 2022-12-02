package com.icesi.edu.Shop.error;

import com.icesi.edu.Shop.constants.ErrorCodes;
import com.icesi.edu.Shop.error.exception.ShopException;
import com.icesi.edu.Shop.error.exception.ShopError;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ShopError> handleException(ShopException shopException){
        return new ResponseEntity<>(shopException.getError(),shopException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ShopError> handleAnnotationException(MethodArgumentNotValidException methodArgumentNotValidException) {
        ShopException shopException = new ShopException(HttpStatus.BAD_REQUEST, new ShopError(ErrorCodes.CODE_UD_01, Objects.requireNonNull(methodArgumentNotValidException.getFieldError()).getDefaultMessage()));
        return new ResponseEntity<>(shopException.getError(), shopException.getHttpStatus());
    }
}
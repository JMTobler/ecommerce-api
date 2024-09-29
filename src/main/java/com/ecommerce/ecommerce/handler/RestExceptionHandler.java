package com.ecommerce.ecommerce.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ecommerce.ecommerce.helper.ConversorData;
import com.ecommerce.ecommerce.model.ErrorResponse;
import com.ecommerce.ecommerce.model.exception.ResourceBadRequestException;
import com.ecommerce.ecommerce.model.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
        var dataHora = ConversorData.converteDateParaDataEHora(new Date());
        var resposta = new ErrorResponse(dataHora, 404, "Not Found", ex.getMessage());

        return new ResponseEntity<>(resposta, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<ErrorResponse> handlerResourceBadRequestException(ResourceBadRequestException ex){
        var dataHora = ConversorData.converteDateParaDataEHora(new Date());
        var resposta = new ErrorResponse(dataHora, 400, "Bad Request", ex.getMessage());

        return new ResponseEntity<>(resposta, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlerException(Exception ex){
        var dataHora = ConversorData.converteDateParaDataEHora(new Date());
        var resposta = new ErrorResponse(dataHora, 500, "internal Server Error", ex.getMessage());

        return new ResponseEntity<>(resposta, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

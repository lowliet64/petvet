package com.example.petvet.exceptions.handlers;


import com.example.petvet.exceptions.ExceptionResponse;
import com.example.petvet.exceptions.InstanceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class ExceptionEntityHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handlerAllExceptionsResponse(Exception ex, WebRequest request){

        ExceptionResponse er =  new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)

        );

        return  new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(InstanceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> notFoundException(Exception ex, WebRequest request){

        ExceptionResponse er =  new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)

        );

        return  new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }

}

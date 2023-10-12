package az.example.com.controller;


import az.example.com.enums.ErrorCodeEnum;
import az.example.com.exception.CustomNotFoundException;
import az.example.com.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerController {


    @ExceptionHandler(CustomNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleCustomException(CustomNotFoundException e){

        log.error("user not found");
        return ErrorResponse.builder()
                .message(e.getMessage())
                .code(e.getCode())
                .build();

    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInputParam(MethodArgumentTypeMismatchException e){
        log.error("xeta....");
        return ErrorResponse.builder()
                .message(e.getParameter().getParameter().getName()+" "+ErrorCodeEnum.VALIDATION_ERROR.getMessage())
                .code(ErrorCodeEnum.VALIDATION_ERROR.getCode())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> eMethodArgumentNotValid(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);

        });
        return errors;
    }



    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public  ErrorResponse allException(Exception e){


        e.printStackTrace();

        return  ErrorResponse.builder()
                .message("internal exception")
                .code(222)
                .build();


    }
}

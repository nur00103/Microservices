package com.example.libraryservice.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookException extends RuntimeException{
    private ExceptionMessage exceptionMessage;

    public BookException(String message, ExceptionMessage exceptionMessage){
        super(message);
        this.exceptionMessage = exceptionMessage;
    }
    public ExceptionMessage getExceptionMessage(){
        return exceptionMessage;
    }
    public BookException(String message){
        super(message);
    }
    public BookException(ExceptionMessage message){
        this.exceptionMessage=message;
    }

}

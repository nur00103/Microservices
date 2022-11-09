package com.example.libraryservice.controller;

import com.example.libraryservice.exception.BookException;
import com.example.libraryservice.exception.ExceptionMessage;
import com.example.libraryservice.exception.LibraryException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(LibraryException.class)
    public ResponseEntity<?> handler(LibraryException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(BookException.class)
//    public ResponseEntity<?> handler(BookException exception){
//        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler(BookException.class)
    public ResponseEntity<ExceptionMessage> handle(BookException exception){
        return new ResponseEntity<>(exception.getExceptionMessage(),HttpStatus.resolve(exception.getExceptionMessage().getStatus()));
    }

}

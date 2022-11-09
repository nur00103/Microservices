package com.example.libraryservice.client;

import com.example.libraryservice.dto.response.BookResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value ="book-service",path = "/book")
public interface BookServiceClient {

    Logger logger= LoggerFactory.getLogger(BookServiceClient.class);

    @GetMapping("/number/{number}")
    @CircuitBreaker(name = "book-service-getByNumber",fallbackMethod = "fallbackGetBookByNumber")
    ResponseEntity<BookResponse> getBookByNumber(@PathVariable String number);

    @GetMapping("/id/{id}")
    @CircuitBreaker(name = "book-service-getById",fallbackMethod = "fallbackGetBookById")
    ResponseEntity<BookResponse> getBookById(@PathVariable String id);

    default ResponseEntity<BookResponse> fallbackGetBookByNumber(String number,Exception e){
        logger.info("Book not found by number: " +number);
        return ResponseEntity.ok(new BookResponse("default-id","default-number"));
    }
    default ResponseEntity<BookResponse> fallbackGetBookById(String id,Exception e){
        logger.info("Book not found by id: " +id);
        return ResponseEntity.ok(new BookResponse("default-id","default-number"));
    }
}

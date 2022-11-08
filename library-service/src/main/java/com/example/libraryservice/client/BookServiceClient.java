package com.example.libraryservice.client;

import com.example.libraryservice.dto.response.BookResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value ="book-service",path = "/book")
public interface BookServiceClient {

    @GetMapping("/number/{number}")
    ResponseEntity<BookResponse> getBookByNumber(@PathVariable String number);

    @GetMapping("/id/{id}")
    ResponseEntity<BookResponse> getBookById(@PathVariable String id);
}

package com.example.bookservice.controller;

import com.example.bookservice.dto.response.BookResponse;
import com.example.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
@Validated
public class BookController {

    private final BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<BookResponse>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/number/{number}")
    public ResponseEntity<BookResponse> getBookByNumber(@PathVariable @NotEmpty String number){
        return ResponseEntity.ok(bookService.getBookByNumber(number));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable @NotEmpty String id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

}

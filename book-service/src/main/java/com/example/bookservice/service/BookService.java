package com.example.bookservice.service;

import com.example.bookservice.dto.response.BookResponse;

import java.util.List;

public interface BookService {

    public List<BookResponse> getAllBooks();
    public BookResponse getBookByNumber(String number);
    public BookResponse getBookById(String is);

}

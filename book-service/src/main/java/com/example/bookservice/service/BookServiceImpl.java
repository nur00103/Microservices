package com.example.bookservice.service;

import com.example.bookservice.dto.response.BookResponse;
import com.example.bookservice.entity.Book;
import com.example.bookservice.exception.BookException;
import com.example.bookservice.repository.BookRepository;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<BookResponse> getAllBooks() {
        List<Book> bookList=bookRepository.findAll();
        if (bookList.isEmpty()){
            throw new BookException("Books not found yet");
        }
        List<BookResponse> bookResponseList=bookList.stream().map(book ->convertToResponse(book))
                .collect(Collectors.toList());
        return bookResponseList;
    }

    @Override
    public BookResponse getBookByNumber(String number) {
        Book book=bookRepository.findByNumber(number)
                .orElseThrow(()->new BookException("Book not found with given isbn"));
        BookResponse bookResponse=convertToResponse(book);
        return bookResponse;
    }

    @Override
    public BookResponse getBookById(String id) {
        Book book=bookRepository.findById(id)
                .orElseThrow(()->new BookException("Book not found with given id"));
        BookResponse bookResponse=convertToResponse(book);
        return bookResponse;
    }

    public BookResponse convertToResponse(Book book){
       BookResponse bookResponse=modelMapper.map(book,BookResponse.class);
       return bookResponse;
    }
}

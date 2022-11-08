package com.example.bookservice;

import com.example.bookservice.entity.Book;
import com.example.bookservice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@RequiredArgsConstructor
@EnableEurekaClient
public class BookServiceApplication implements CommandLineRunner {

	private final BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book=new Book("1","Title",2000,"Author","PressName","number");
		Book book1=new Book("2","Title2",2001,"Author2","PressName2","number2");
        bookRepository.save(book);
		bookRepository.save(book1);

	}
}

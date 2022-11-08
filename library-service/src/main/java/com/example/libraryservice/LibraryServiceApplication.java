package com.example.libraryservice;

import com.example.libraryservice.entity.Library;
import com.example.libraryservice.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RequiredArgsConstructor
public class LibraryServiceApplication implements CommandLineRunner {

	private  final LibraryRepository libraryRepository;

	public static void main(String[] args) {
		SpringApplication.run(LibraryServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String s="number";
		List<String> userBook=new ArrayList<>();
		userBook.add(s);
		Library library=new Library();
		library.setUserBook(userBook);
		library.setId("1");
		libraryRepository.save(library);
	}
}

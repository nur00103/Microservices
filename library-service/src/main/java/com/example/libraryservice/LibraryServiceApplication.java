package com.example.libraryservice;

import com.example.libraryservice.client.RetrieveMessageErrorDecoder;
import com.example.libraryservice.entity.Library;
import com.example.libraryservice.repository.LibraryRepository;
import feign.Logger;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RequiredArgsConstructor
public class LibraryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryServiceApplication.class, args);
	}

	//Feign Client Error handling
//	@Bean
//	public ErrorDecoder errorDecoder(){
//		return new RetrieveMessageErrorDecoder();
//	}
//
//	@Bean
//	Logger.Level feignLoggerLevel(){
//		return Logger.Level.FULL;
//	}

}

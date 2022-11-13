package com.example.libraryservice.controller;

import com.example.libraryservice.dto.request.AddBookRequest;
import com.example.libraryservice.dto.response.LibraryResponse;
import com.example.libraryservice.service.LibraryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library")
@Validated
@Slf4j
public class LibraryController {

    private final LibraryService libraryService;
    private final Environment environment;
    Logger logger= LoggerFactory.getLogger(LibraryController.class);

    @GetMapping("/{id}")
    public ResponseEntity<LibraryResponse> getLibraryById(@PathVariable @NotEmpty String id){
        return ResponseEntity.ok(libraryService.getAllBooksByLibraryId(id));
    }

    @PostMapping
    public ResponseEntity<LibraryResponse> createLibrary(){
        logger.info("Library created on port number: " + environment.getProperty("local.server.port"));
       return ResponseEntity.ok(libraryService.createLibrary());
    }

    @PutMapping
    public ResponseEntity<Void> addBookToLibrary(@RequestBody @NotEmpty AddBookRequest request){
        libraryService.addBookToLibrary(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<LibraryResponse>> getAllLibrary(){
        return ResponseEntity.ok(libraryService.getAllLibrary());
    }
}

package com.example.libraryservice.controller;

import com.example.libraryservice.dto.request.AddBookRequest;
import com.example.libraryservice.dto.response.LibraryResponse;
import com.example.libraryservice.entity.Library;
import com.example.libraryservice.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library")
@Validated
public class LibraryController {

    private final LibraryService libraryService;

    @GetMapping("/{id}")
    public ResponseEntity<LibraryResponse> getLibraryById(@PathVariable @NotEmpty String id){
        return ResponseEntity.ok(libraryService.getAllBooksByLibraryId(id));
    }

    @PostMapping
    public ResponseEntity<LibraryResponse> createLibrary(){
       return ResponseEntity.ok(libraryService.createLibrary());
    }

    @PutMapping
    public ResponseEntity<Void> addBookToLibrary(@RequestBody @NotEmpty AddBookRequest request){
        libraryService.addBookToLibrary(request);
        return ResponseEntity.ok().build();
    }
}

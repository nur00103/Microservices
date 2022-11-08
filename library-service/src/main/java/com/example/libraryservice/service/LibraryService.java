package com.example.libraryservice.service;

import com.example.libraryservice.dto.request.AddBookRequest;
import com.example.libraryservice.dto.response.LibraryResponse;
import com.example.libraryservice.entity.Library;

public interface LibraryService {

    public LibraryResponse getAllBooksByLibraryId(String id);

    public void addBookToLibrary(AddBookRequest request);

    public LibraryResponse createLibrary();
}

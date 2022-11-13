package com.example.libraryservice.service.impl;

import com.example.libraryservice.client.BookServiceClient;
import com.example.libraryservice.dto.request.AddBookRequest;
import com.example.libraryservice.dto.response.BookResponse;
import com.example.libraryservice.dto.response.LibraryResponse;
import com.example.libraryservice.entity.Library;
import com.example.libraryservice.exception.LibraryException;
import com.example.libraryservice.repository.LibraryRepository;
import com.example.libraryservice.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibraryServiceImpl implements LibraryService {

    private final LibraryRepository libraryRepository;
    private final ModelMapper modelMapper;
    private final BookServiceClient bookServiceClient;

    @Override
    public LibraryResponse getAllBooksByLibraryId(String id) {
        Library library=libraryRepository.findById(id)
                .orElseThrow(()->new LibraryException("Library not found with this id"));
        library.getUserBook().stream().map(bookServiceClient::getBookByNumber)
                .map(ResponseEntity::getBody).collect(Collectors.toList());
        LibraryResponse libraryResponse=convertToResponse(library);
        return libraryResponse;
    }

    @Override
    public void addBookToLibrary(AddBookRequest request) {
        String bookNumber=bookServiceClient.getBookByNumber(request.getNumber()).getBody().getNumber();
        Library library=libraryRepository.findById(request.getId())
                .orElseThrow(()->new LibraryException("Library not found with this id"));
        library.getUserBook().add(bookNumber);
        libraryRepository.save(library);
    }

    @Override
    public LibraryResponse createLibrary() {
        Library library=libraryRepository.save(new Library());
        LibraryResponse libraryResponse=new LibraryResponse();
        libraryResponse.setId(library.getId());
        return libraryResponse;
    }

    @Override
    public List<LibraryResponse> getAllLibrary() {
        List<Library> libraryList=libraryRepository.findAll();
        List<LibraryResponse> libraryResponseList=libraryList.stream().map(library -> convertToResponse(library)).collect(Collectors.toList());
        return libraryResponseList;
    }

    public LibraryResponse convertToResponse(Library library){
        LibraryResponse libraryResponse=modelMapper.map(library,LibraryResponse.class);
//        List<BookResponse> bookResponseList=null;
//        for (String s:library.getUserBook()) {
//           BookResponse bookResponse= bookServiceClient.getBookByNumber(s).getBody();
//           bookResponseList.add(bookResponse);
//        }
//        libraryResponse.setUserBook(bookResponseList);
        return libraryResponse;
    }
}

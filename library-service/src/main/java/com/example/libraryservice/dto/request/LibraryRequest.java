package com.example.libraryservice.dto.request;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryRequest {

    private List<String> userBook;
}

package com.example.libraryservice.dto.response;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryResponse {

    private String id;
    private List<String> userBook;
}

package com.example.bookservice.dto.response;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponse {

    private String id;
    private String title;
    private Integer bookYear;
    private String author;
    private String pressName;
    private String number;
}

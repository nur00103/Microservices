package com.example.bookservice.dto.request;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookRequest {
    private String title;
    private Integer bookYear;
    private String author;
    private String pressName;
    private String number;
}

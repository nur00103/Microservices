package com.example.libraryservice.dto.request;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddBookRequest {

    private String id;
    private String number;
}

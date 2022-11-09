package com.example.libraryservice.exception;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionMessage {

    private String timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}

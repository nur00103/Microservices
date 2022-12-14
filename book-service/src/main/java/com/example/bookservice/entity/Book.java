package com.example.bookservice.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID" ,strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String title;
    private Integer bookYear;
    private String author;
    private String pressName;
    private String number;

}

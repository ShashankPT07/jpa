package com.xworkz.bookentity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {

    @Id
    private int id;
    private String title;
    private String author;
    private double price;
    private int pages;
}

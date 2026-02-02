package com.xworkz.bookentity.external;



import com.xworkz.bookentity.entity.BookEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BookRead {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("bookPU");
        EntityManager entityManager = factory.createEntityManager();

        BookEntity book = entityManager.find(BookEntity.class, 1);
        System.out.println(book);

        entityManager.close();
        factory.close();
    }
}

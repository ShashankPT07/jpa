package com.xworkz.book.runner;

import com.xworkz.book.entity.BookEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BookRunner {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Xworkz");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        BookEntity book = new BookEntity(109, "Java", "shashank", 45.5);
        entityManager.persist(book);

        transaction.commit();

        BookEntity fetchedBook = entityManager.find(BookEntity.class, 109);
        System.out.println(fetchedBook.toString());

        entityManager.close();
        entityManagerFactory.close();
    }
}

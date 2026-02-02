package com.xworkz.bookentity.external;



import com.xworkz.bookentity.entity.BookEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BookUpdate {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("bookPU");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        BookEntity book = entityManager.find(BookEntity.class, 1);
        book.setPrice(500.0); // Updating price
        entityManager.merge(book);

        transaction.commit();
        entityManager.close();
        factory.close();
    }
}

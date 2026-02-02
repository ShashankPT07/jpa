package com.xworkz.bookentity.external;



import com.xworkz.bookentity.entity.BookEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BookDelete {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("bookPU");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        BookEntity book = entityManager.find(BookEntity.class, 1);
        entityManager.remove(book);

        transaction.commit();
        entityManager.close();
        factory.close();
    }
}

package com.xworkz.product.external;

import com.xworkz.product.entity.ProductEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProductDelete {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        ProductEntity product = entityManager.find(ProductEntity.class, 201);
        entityManager.remove(product);

        transaction.commit();
        entityManager.close();
        factory.close();
    }
}

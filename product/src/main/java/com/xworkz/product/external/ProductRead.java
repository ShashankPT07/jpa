package com.xworkz.product.external;

import com.xworkz.product.entity.ProductEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProductRead {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager = factory.createEntityManager();

        ProductEntity product = entityManager.find(ProductEntity.class, 201);
        System.out.println(product);

        entityManager.close();
        factory.close();
    }
}

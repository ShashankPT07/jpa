package com.xworkz.food.dao;

import com.mysql.cj.xdevapi.Collection;
import com.xworkz.food.entity.FoodEntity;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Repository
public class FoodDAOImpl implements FoodDAO{

    @Override
    public void save(FoodEntity foodEntity) {
        System.out.println("this is repo"+foodEntity);
        EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager =null;
        try {

              entityManager=entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(foodEntity);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
            entityManagerFactory.close();

        }

    }

    @Override
    public List<FoodEntity> getflightdata() {
        EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        try {

            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Query query=entityManager.createNamedQuery("readAll");
            List<FoodEntity> entities=(List<FoodEntity>) query.getResultList();
            System.out.println(entities);
            return entities;

        }catch (Exception e){
            return Collections.emptyList();
        }finally {
            entityManager.close();
            entityManagerFactory.close();

        }

    }
    }



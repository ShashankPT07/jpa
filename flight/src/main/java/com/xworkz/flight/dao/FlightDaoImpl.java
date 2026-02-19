package com.xworkz.flight.dao;

import com.xworkz.flight.entity.FlightEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Repository
public class FlightDaoImpl implements FlightDAO{
    @Override
    public void save(FlightEntity flightEntity) {
        System.out.println("this is repo"+flightEntity);
        EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager=null;
        try {


             entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(flightEntity);
            entityTransaction.commit();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
            entityManagerFactory.close();

        }
    }
}

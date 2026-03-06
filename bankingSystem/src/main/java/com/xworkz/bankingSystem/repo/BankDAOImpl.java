package com.xworkz.bankingSystem.repo;

import com.xworkz.bankingSystem.entity.BankEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Repository
public class BankDAOImpl implements BankDAO{

    @Autowired
EntityManagerFactory entityManagerFactory;

    @Override
    public boolean save(BankEntity bankEntity) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        try {
            EntityTransaction entityTransaction=entityManager.getTransaction();
            entityTransaction.begin();
entityManager.persist(bankEntity);
entityTransaction.commit();
return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally {
            entityManager.close();
        }
    }

    @Override
    public List<BankEntity> read() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        try {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("readData");
            List<BankEntity> entityList = (List<BankEntity>) query.getResultList();
            System.out.println("All details----" + entityList);
            return entityList;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }finally {
            entityManager.close();
        }


    }

    @Override
    public BankEntity getDataBasedOnAccountNumber(String accountNumber) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        try {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("findByAccountNumber");
            query.setParameter("getAccountNumber", accountNumber);
            BankEntity bankEntity = (BankEntity) query.getSingleResult();
            return bankEntity;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            entityManager.close();
        }


    }

    @Override
    public BankEntity getDataBasedOnPhoneNumber(String phoneNumber) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        try {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("findByPhoneNumber");
            query.setParameter("getPhoneNumber", phoneNumber);
            BankEntity bankEntity = (BankEntity) query.getSingleResult();
            return bankEntity;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            entityManager.close();
        }
    }

    @Override
    public BankEntity getDataBasedOnId(int id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        try {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            BankEntity bankEntity = entityManager.find(BankEntity.class, id);
            return bankEntity;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public void update(BankEntity bankEntity) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        try {
           EntityTransaction entityTransaction= entityManager.getTransaction();
           entityTransaction.begin();
           entityManager.merge(bankEntity);
           entityTransaction.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }
    }

    @Override
    public void delete(int id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        try {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Query query=entityManager.createNamedQuery("deleteData");
            query.setParameter("getId",id);
            query.executeUpdate();
            entityTransaction.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }
    }
}

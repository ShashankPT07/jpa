package com.xworkz.employee.external;

import com.xworkz.employee.entity.EmployeeEntity;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.FileInputStream;
import java.io.IOException;

public class EmployeeRunner {
    public static void main(String[] args) {

        String excelPath = "C:\\Users\\Admin\\Downloads\\Telegram Desktop\\employee.xlsx";

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try (FileInputStream fileInputStream = new FileInputStream(excelPath);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            entityTransaction.begin();

            Sheet sheetAt = workbook.getSheetAt(0);

            for (int i = 1; i <= sheetAt.getLastRowNum(); i++) {
                Row row = sheetAt.getRow(i);

                EmployeeEntity employeeEntity = new EmployeeEntity();


                employeeEntity.setName(row.getCell(0).getStringCellValue());
                employeeEntity.setDepartment(row.getCell(1).getStringCellValue());
                employeeEntity.setSalary(row.getCell(2).getNumericCellValue());

                entityManager.persist(employeeEntity);
            }

            entityTransaction.commit();
            System.out.println("Excel data inserted in DB using JPA successfully");

        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}

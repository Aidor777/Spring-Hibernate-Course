package com.lovetocode.hibernate.test;

import com.lovetocode.hibernate.entity.Employee;
import com.lovetocode.hibernate.entity.Student;
import org.hibernate.cfg.Configuration;

public class CRUDEmployeeTest {

    public static void main(String[] args) {

        // Create session factory and let try-with-resources close it in the end
        try (var sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            // Get a new session and begin a transaction
            var session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // Save a new employee to database
            System.out.println("\nSaving new employee");
            var employee = new Employee("Obi-Wan", "Kenobi", "The Jedi Council");
            session.save(employee);
            System.out.println("Employee saved: " + employee);

            // Retrieve an employee by ID (primary key)
            int employeeId = employee.getId();
            System.out.println("\nRetrieving employee with ID: " + employeeId);
            var retrievedEmployee = session.get(Employee.class, employeeId);
            System.out.println("Employee retrieved: " + retrievedEmployee);

            // Retrieve employees by company name
            System.out.println("\nRetrieving employees working for The Jedi Council");
            var retrievedEmployees = session.createQuery("from Employee where company = 'The Jedi Council'", Employee.class)
                    .getResultList();
            System.out.println("Employees working for The Jedi Council:");
            for (var masterJedi : retrievedEmployees) {
                System.out.println(masterJedi);
            }

            // Delete employee by ID (primary key)
            System.out.println("\nDeleting employee with ID: " + employeeId);
            int affectedRows = session.createQuery("delete from Employee where id = " + employeeId).executeUpdate();
            System.out.println("Successfully deleted " + affectedRows + " employee(s)");

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("\nAll done!");
        }
    }
}

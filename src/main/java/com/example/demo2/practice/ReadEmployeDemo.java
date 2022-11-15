package com.example.demo2.practice;

import com.example.demo2.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ReadEmployeDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session=factory.getCurrentSession();

        try {
            session=factory.getCurrentSession();
            session.beginTransaction();
            //query Employee
            List<Employee> employeeList = session.createQuery("from Employee ").getResultList();

            //display the employee

            displayEmploye(employeeList);

            //query employee: lastName='Doe'
            employeeList=session.createQuery("from Employee e where e.lastName = 'Doe' ").getResultList();

            //display the employeeeeeeee
            System.out.println("\n\nEmployes who have last name of Doe");

            //query EMployyee: lastName = 'Doe' or firstName = 'Daffy'
            employeeList=session.createQuery("from Employee e where e.lastName = 'Doe' or e.firstName = 'Daffy'").getResultList();
            System.out.println("\n\nEmployes who have last name of Doe or first name Daffy");
            displayEmploye(employeeList);

            //query employes where email like '%luv2code.com'
            employeeList=session.createQuery("from Employee  e where e.company like 'linkplus'").getResultList();
            System.out.println("\n\n Employes whose companies name ends with '%linkplus'");
            displayEmploye(employeeList);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

    private static void displayEmploye(List<Employee> employeeList) {
        for (Employee employee: employeeList){
            System.out.println(employee);
        }
    }
}

package com.example.demo2.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateEmployeDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session=factory.getCurrentSession();

        try {
            //create a employee object
            System.out.println("Creating new Employee object...");
            Employee tempEmploye = new Employee("Jakup", "Sinani", "LinkPlus");

            //start a transaction
            session.beginTransaction();

            //save the Employee object
            System.out.println("Saving the employee");
            session.save(tempEmploye);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("DONE!!!!!!");
        } finally {
            factory.close();
        }
    }
}

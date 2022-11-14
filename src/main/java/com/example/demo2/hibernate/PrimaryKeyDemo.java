package com.example.demo2;

import com.example.demo2.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session= factory.getCurrentSession();
        try {
            //create a 3 student objects
            System.out.println("Creating 3 Student objects..");
            Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
            Student tempStudent2 = new Student("Mary", "Public", "Mary@luv2code.com");
            Student tempStudent3 = new Student("Bonita", "Applebaum", "Bonita@luv2code.com");

            //start a transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the student");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}

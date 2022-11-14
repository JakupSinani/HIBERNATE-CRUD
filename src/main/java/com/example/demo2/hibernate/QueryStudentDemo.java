package com.example.demo2.crud;

import com.example.demo2.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import  org.hibernate.cfg.Configuration;


public class CreateStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session= factory.getCurrentSession();
        try {
            //create a student object
            System.out.println("Creating new Student object..");
            Student tempStudent = new Student("Paul", "Wall", "paul@luv2code.com");

            //start a transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the student");
            session.save(tempStudent);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}

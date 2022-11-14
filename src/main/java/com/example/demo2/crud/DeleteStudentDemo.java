package com.example.demo2.crud;

import com.example.demo2.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UpdateStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session= factory.getCurrentSession();
        try {
            int studentId=1;

            //now get a new session and start transaction
            session=factory.getCurrentSession();
            session.beginTransaction();

            //retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: "+studentId);

            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Updating student...");
            myStudent.setFirstName("Tomy");

            //commit the transaction
            session.getTransaction().commit();

            //new code
            session=factory.getCurrentSession();
            session.beginTransaction();

            //update email for all students
            System.out.println("Update email for all Studnets");
            session.createQuery("update Student  set email='foo@gmail.com'").executeUpdate();
            //commit the transaction
            session.getTransaction().commit();


            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}

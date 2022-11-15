package com.example.demo2.hibernate;

import com.example.demo2.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {
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

            //query students
            List<Student>theStudents = session.createQuery("from Student").getResultList();

            //display the students
            displayStudents(theStudents);

            //query students: lastName='Doe'
            theStudents=session.createQuery("from Student s where s.lastName = 'Doe' ").getResultList();

            //display the students
            System.out.println("\n\nStudents who have last name of Doe");
            displayStudents(theStudents);

            //query students: lastName = 'Doe' or firstName = 'Daffy'
            theStudents=session.createQuery("from Student  s where s.lastName = 'Doe' or s.firstName = 'Daffy'").getResultList();
            System.out.println("\n\nStudent who have last name of Doe or first name Daffy");
            displayStudents(theStudents);

            //query students where email like '%luv2code.com'
            theStudents=session.createQuery("from Student  s where s.email like '%luv2code.com'").getResultList();
            System.out.println("\n\n Student whose email ends with '%luv2code.com'");
            displayStudents(theStudents);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student tempStudents: theStudents){
            System.out.println(tempStudents);
        }
    }
}

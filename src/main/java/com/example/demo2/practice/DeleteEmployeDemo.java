package com.example.demo2.practice;

import com.example.demo2.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteEmployeDemo {
    public static void main(String[] args) {

        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session= factory.getCurrentSession();
        try {
            int employeId=1;

            //now get a new session and start transaction
            session=factory.getCurrentSession();
            session.beginTransaction();

            //retrieve employe based on the id: primary key
            System.out.println("\nGetting Employe with id: "+employeId);

            Employee employee = session.get(Employee.class,employeId);

            //delete the employe
//            System.out.println("Deleting employe: "+employee);
//            session.delete(employee);

            //delete employee id= 1;
            System.out.println("Deleteing employee id = 8");
            session.createQuery("delete from Employee where id=1").executeUpdate();

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}

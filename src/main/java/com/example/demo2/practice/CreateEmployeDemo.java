package com.example.demo2.practice;

import com.example.demo2.entity.Student;
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
            //Employee tempEmploye = new Employee("Sinan", "Sinani", "LinkPlus");
            Employee tempEmploye1 = new Employee("John", "Doe", "iSolve");
            Employee tempEmploye2 = new Employee("Mary", "Public", "Bridge");
            Employee tempEmploye3 = new Employee("Bonita", "Applebaum", "Microsoft");

            //start a transaction
            session.beginTransaction();

            //save the Employee object
            System.out.println("Saving the employee");
            session.save(tempEmploye1);
            session.save(tempEmploye2);
            session.save(tempEmploye3);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("DONE!!!!!!");
        } finally {
            factory.close();
        }
    }
}

package com.anny.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
 Laptop laps=new Laptop();
 EmployeModel em=new EmployeModel();
        laps.setLid(10063);
        laps.setLname("DELL");
        laps.setEmployeModel(em);
        
        em.setId(107);
        em.setName("Anny");
        em.setEmail("Anny@gmail.com");
        em.getLaptop().add(laps);
       
        
   
        Configuration con=new Configuration().configure().addAnnotatedClass(EmployeModel.class).addAnnotatedClass(Laptop.class);
       // ServiceRegistry sr=new ServiceRegistryBuilder().buildServiceRegistry();
        SessionFactory factory=con.buildSessionFactory();
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        
       session.save(em);
       session.save(laps);
        
       // em=(EmployeModel)session.get(EmployeModel.class, 103);
        tx.commit();
        System.out.println(em);
    }
}

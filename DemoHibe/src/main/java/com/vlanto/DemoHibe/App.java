package com.vlanto.DemoHibe;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class App 
{
    public static void main( String[] args )
    {
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
         
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
         
        SessionFactory sf = con.buildSessionFactory(reg);
         
        Session session = sf.openSession();
         
        session.beginTransaction();
        int b = 60;
        Query q = session.createQuery("select rollno,name,marks from Student where marks>:b");
        q.setParameter("b", b);
        List<Object[]> students = (List<Object[]>)q.list();
        
        for(Object[] student : students) {
        	System.out.println(student[0] + " : " + student[1] + " : " + student[2]);
        }
        
        session.getTransaction().commit();
        
        
    }
}
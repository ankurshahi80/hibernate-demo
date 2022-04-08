package com.revature.driver;

import com.revature.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MainDriver {
    public static void main(String[] args) {

    }

    public static void populateSampleData(){
        // Get an instance of our sessionFactory object
        SessionFactory sf = SessionFactorySingleton.getSessionFactory();

        // Open a session
        Session session =sf.openSession();

        // Open a transaction
        Transaction tx = session.beginTransaction();

        // Make new data
    }
}

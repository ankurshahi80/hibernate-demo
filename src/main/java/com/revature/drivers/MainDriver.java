package com.revature.drivers;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MainDriver {
    public static void main(String[] args) {
        populateSampleData();
    }

    public static void populateSampleData(){
        //TODO 1: get an instance of our sessionfactory
        SessionFactory sf = SessionFactorySingleton.getSessionFactory();

        // TODO 2: open a session
        Session session = sf.openSession();

        //TODO 3: open transaction
        Transaction transaction = session.beginTransaction();

        /*
            Object states:
            1. Transient: plain old Java obj that has never been tracked by a session obj
            2. Persistent: an obj is not being tracked by the session obj and going to be synchronized with
            3. Detached: an obj that was persisted but is no longer usable within the session
         */

        //TODO 4: make new data
        User user1 = new User("Bach", "Tran","btran","password"); // Transient state
        User user2= new User("The", "Batman","thebatman","password"); // Transient

        Reimbursement reimb1 = new Reimbursement(100.34, user1, "gas money to annual conference");
        Reimbursement reimb2 = new Reimbursement(1000, user2, "oil change");
        session.persist(user1);
        session.persist(user2);
        session.persist(reimb1);
        session.persist(reimb2);

        transaction.commit();
        session.close();
    }
}

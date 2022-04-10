package com.revature.driver;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MainDriver {
    public static void main(String[] args) {
//        populateSampleData();
//        test();
        getDataFromDatabase();
    }

    public static void getDataFromDatabase(){
        SessionFactory sf = SessionFactorySingleton.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        User u = session.get(User.class, 1);
        System.out.println(u);

        tx.commit();
        session.close();
    }

    public static void test() {
        SessionFactory sf = SessionFactorySingleton.getSessionFactory();
    }

    public static void populateSampleData(){
        // Get an instance of our sessionFactory object
        SessionFactory sf = SessionFactorySingleton.getSessionFactory();

        // Open a session
        Session session =sf.openSession();

        // Open a transaction
        Transaction tx = session.beginTransaction();

        // Make new data
            // transient objects
        User user1 = new User("Bach","Tran","btran","password");
        User user2 = new User("The","Batman","thebatman","password");
            // persist data
        session.persist(user1);
        session.persist(user2);

        // transient reimbursements objects
        Reimbursement reimb1 = new Reimbursement(1000.34, user1, "gas money to annual conference");
        Reimbursement reimb2 = new Reimbursement(500, user1,"car servicing");

        //persist data
        session.persist(reimb1);
        session.persist(reimb2);

        // Close the transaction
        tx.commit();

        session.close(); // users and reimbursements are now detached
    }
}

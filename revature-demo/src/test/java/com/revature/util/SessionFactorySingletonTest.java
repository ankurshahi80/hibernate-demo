package com.revature.util;

import org.junit.jupiter.api.Test;

public class SessionFactorySingletonTest {

    @Test
    public void getSession(){

        SessionFactorySingleton.getSessionFactory().openSession();
    }
}

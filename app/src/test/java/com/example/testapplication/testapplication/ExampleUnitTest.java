package com.example.testapplication.testapplication;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ExampleUnitTest {

    @Test
    public void itIsAdmin() {
        String adminEmail = "admin@admin.com";
        String adminPassword = "Test1234!";
        boolean isItIsAdmin = MainActivity.isItAdmin(adminEmail, adminPassword);
        assertTrue(isItIsAdmin);
    }
    @Test
    public void itIsNotAdmin() {
        String adminEmail = "test";
        String adminPassword = "test";
        boolean isItIsAdmin = MainActivity.isItAdmin(adminEmail, adminPassword);
        assertFalse(isItIsAdmin);
    }
    @Test
    public void emailIsValid() {
        String email = "user@test.test";
        boolean isEmailValid = MainActivity.isValidEmail(email);
        assertTrue(isEmailValid);
    }
    @Test
    public void emailIsNotValid() {
        String email = "user.test.test";
        boolean isEmailValid = MainActivity.isValidEmail(email);
        assertFalse(isEmailValid);
    }
    @Test
    public void passwordIsValid() {
        String password = "Test1234!";
        boolean isPasswordValid = MainActivity.isValidPassword(password);
        assertTrue(isPasswordValid);
    }
    @Test
    public void passwordIsNotValid() {
        String password = "test";
        boolean isPasswordValid = MainActivity.isValidPassword(password);
        assertFalse(isPasswordValid);
    }

}
package com.socks.tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UsersTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://10.47.114.42/";
    }

    @Test
    public void testCanRegisterNewUser() {
    }
}

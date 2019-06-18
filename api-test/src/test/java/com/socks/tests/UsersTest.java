package com.socks.tests;

import com.socks.api.conditions.Conditions;
import com.socks.api.conditions.StatusCodeCondition;
import com.socks.api.payloads.UserPayload;
import com.socks.api.services.UserApiService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;

public class UsersTest {

    private final UserApiService userApiService = new UserApiService();

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://10.47.114.42/";
    }

    @Test
    public void testCanRegisterNewUser() {
        UserPayload user = new UserPayload()
                .username(RandomStringUtils.randomAlphanumeric(6))
                .email("foo@gmail.com")
                .password("abc")
                .firstName("")
                .lastName("");

        userApiService.registerUser(user)
                .shouldHave(Conditions.statusCode(200));
    }

    public void testCannotRegisterSameUserTwice() {
        UserPayload user = new UserPayload()
                .username(RandomStringUtils.randomAlphanumeric(6))
                .email("foo@gmail.com")
                .password("abc")
                .firstName("")
                .lastName("");

//        userApiService.registerUser(user)
//                .then().log().all()
//                .assertThat()
//                .statusCode(200)
//                .body("id", not(isEmptyString()));
//
//        userApiService.registerUser(user)
//                .then().log().all()
//                .assertThat()
//                .statusCode(500);
    }
}

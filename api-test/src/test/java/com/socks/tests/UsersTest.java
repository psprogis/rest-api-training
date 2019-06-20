package com.socks.tests;

import com.github.javafaker.Faker;
import com.socks.api.ProjectConfig;
import com.socks.api.payloads.UserPayload;
import com.socks.api.services.UserApiService;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Locale;

import static com.socks.api.conditions.Conditions.bodyField;
import static com.socks.api.conditions.Conditions.statusCode;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

public class UsersTest {

    private final UserApiService userApiService = new UserApiService();
    private Faker faker;

    @BeforeClass
    public void setUp() {
        final ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());

        RestAssured.baseURI = config.baseUrl();
        faker = new Faker(new Locale(config.locale()));
    }

    @Test
    public void testCanRegisterNewUser() {
        UserPayload user = new UserPayload()
                .username(faker.name().username())
                .email("foo@gmail.com")
                .password("abc")
                .firstName("")
                .lastName("");

        userApiService.registerUser(user)
                .shouldHave(statusCode(200))
                .shouldHave(bodyField("id", not(isEmptyOrNullString())));
    }

    @Test
    public void testCannotRegisterSameUserTwice() {
        UserPayload user = new UserPayload()
                .username(faker.name().username())
                .email("foo@gmail.com")
                .password("abc")
                .firstName("")
                .lastName("");

        userApiService.registerUser(user)
                .shouldHave(statusCode(200))
                .shouldHave(bodyField("id", not(isEmptyOrNullString())));

        userApiService.registerUser(user)
            .shouldHave(statusCode(500));
    }
}

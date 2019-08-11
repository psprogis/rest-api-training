package com.socks.ui.test;

import org.testng.annotations.Test;

import com.socks.api.payloads.UserPayload;
import com.socks.api.services.UserApiService;
import com.socks.ui.MainPage;

import static com.socks.api.conditions.Conditions.statusCode;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class TestLogin {

    private final UserApiService userApiService = new UserApiService();


    @Test
    public void userCanLoginWithValidCredentials() {
        UserPayload user = new UserPayload()
                               .username(randomAlphanumeric(6))
                               .password("abc")
                               .email("foo@gmail.com");


        userApiService.registerUser(user)
                      .shouldHave(statusCode(200));

        MainPage.open()
                .loginAs(user.username(), user.password());
    }
}

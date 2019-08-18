package com.socks.ui.tests;

import org.testng.annotations.Test;

import com.socks.api.payloads.UserPayload;
import com.socks.api.services.UserApiService;
import com.socks.ui.LoggedUserPage;
import com.socks.ui.MainPage;

import static com.codeborne.selenide.Condition.text;
import static com.socks.api.conditions.Conditions.statusCode;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class TestLogin extends BaseUITest {

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

        LoggedUserPage loggedUserPage = at(LoggedUserPage.class);
        loggedUserPage.logoutBtn().shouldHave(text("logout"));
        loggedUserPage.userName().shouldHave(text("Logged in as"));
    }
}

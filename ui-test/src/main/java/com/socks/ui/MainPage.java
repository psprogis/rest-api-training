package com.socks.ui;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public static MainPage open() {
        Selenide.open("/");

        return new MainPage();
    }

    public void loginAs(String name, String password) {
        $("#login > a").click();
        $("#username-modal").setValue(name);
        $("#password-modal").setValue(password);
        $("#login-modal p button").click();
    }
}

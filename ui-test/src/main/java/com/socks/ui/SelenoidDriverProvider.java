package com.socks.ui;

import java.net.MalformedURLException;
import java.net.URI;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.codeborne.selenide.WebDriverProvider;

public class SelenoidDriverProvider implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        DesiredCapabilities browser = new DesiredCapabilities();

        browser.setBrowserName("chrome");
        browser.setVersion("74.0");
        browser.setCapability("enableVNC", true);

        try {
            RemoteWebDriver driver = new RemoteWebDriver(
                URI.create("http://localhost:4444/wd/hub").toURL(),
                browser
            );

            driver.manage().window().setSize(new Dimension(1280, 1024));
            driver.setFileDetector(new LocalFileDetector());

            return driver;

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

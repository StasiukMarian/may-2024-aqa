package org.base.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    @BeforeTest
    public void config() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1280x920";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 10000;
        Configuration.headless = false;
        Configuration.savePageSource = false;
        Configuration.screenshots = true;
    }

    @BeforeMethod
    public void login() {
        Selenide.open("https://www.google.com");
    }

    @AfterMethod
    public void cleanWebDriver() {
        Selenide.clearBrowserCookies();
        Selenide.refresh();
        Selenide.open("about:blank");
    }

    @AfterTest
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}

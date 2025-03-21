package org.base.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.base.helpers.CustomConditions.*;

public class LoginPage {
    private final String usernameInput = "//input[@placeholder='Username']";
    private final String passwordInput = ".input_error.form_input[id=password]";
    private final String loginButton = "login-button";

    public void typeUsername(String username) {
        $(byXpath(usernameInput)).shouldBe(inputCondition).append(username);
    }

    public void typePassword(String password) {
        $(byCssSelector(passwordInput)).shouldBe(inputCondition).append(password);
    }

    public void clickLoginButton() {
        $(byId(loginButton)).shouldBe(clickable).submit();
    }
}

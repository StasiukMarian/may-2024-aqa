package org.base.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.base.helpers.CustomConditions.*;

public class CheckoutYourInformationPage {
    private final String firstnameInput = "first-name";
    private final String lastnameInput = "last-name";
    private final String zipInput = "postal-code";

    private final String continueButton = "continue";

    public void fillInformationInputs(String firstname, String lastname, String zip) {
        $(byId(firstnameInput)).shouldBe(inputCondition).append(firstname);
        $(byId(lastnameInput)).shouldBe(inputCondition).append(lastname);
        $(byId(zipInput)).shouldBe(inputCondition).append(zip);
    }

    public void clickContinueButton() {
        $(byId(continueButton)).shouldBe(clickable).click();
    }
}

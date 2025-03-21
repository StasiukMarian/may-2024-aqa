package org.base.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class YourCartPage {
    private final String items = "//div[@class='inventory_item_name']";
    private final String checkoutButton = "checkout";

    public ElementsCollection getItems() {
        return $$(byXpath(items));
    }
    public void clickCheckoutButton(){
        $(byId(checkoutButton)).shouldBe(clickable).click();
    }
}

package org.base.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CheckoutOverviewPage {
    private final String items = "//div[@class='inventory_item_name']";
    private final String finishButton = "finish";

    public ElementsCollection getItems() {
        return $$(byXpath(items));
    }

    public void clickFinishButton() {
        $(byId(finishButton)).shouldBe(clickable).click();
    }
}

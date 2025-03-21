package org.base.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final String logo = "//div[@class='app_logo']";
    private final String headers = "//div[@class='inventory_item_name ']";
    private final String buttons = "//button[text()='Add to cart']";
    private final String shoppingCardButton = "//a[@class='shopping_cart_link']";

    public void waitAppLogo() {
        $(byXpath(logo)).shouldBe(visible, Duration.ofSeconds(30));
    }

    public ElementsCollection getItems() {
        return $$(byXpath(headers)).shouldBe(CollectionCondition.size(6));
    }

    public void clickAddToCardButton() {
        $(byXpath(buttons)).shouldBe(clickable).click();
    }

    public void clickShoppingCardButton(){
        $(byXpath(shoppingCardButton)).shouldBe(clickable).click();
    }
}

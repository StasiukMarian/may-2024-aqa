package org.base.pages;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutCompletePage {
    private final String completeHeader = "//h2[@class='complete-header']";
    private final String backHomeButton = "//button[text()='Back Home']";

    public boolean isCompleteHeaderVisible() {
        return $(byXpath(completeHeader)).is(visible);
    }

    public void clickBackHomeButton() {
        $(byXpath(backHomeButton)).shouldBe(clickable).click();
    }
}

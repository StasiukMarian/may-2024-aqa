package org.base.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import org.base.config.PageTools;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends PageTools {
    private final String logo = "//div[@class='app_logo']";
    private final String headers = "//div[@class='inventory_item_name ']";
    private final String descriptions = "//div[@class='inventory_item_desc']";
    private final String prices = "//div[@class='inventory_item_price']";
    private final String headerByName = "//div[@class='inventory_item_name ' and text()='%s']";
    private final String headerById = "(//div[@class='inventory_item_name '])[%d]";
    private final String backToProductsButton = "back-to-products";
    private final String buttons = "//button[text()='Add to cart']";
    private final String shoppingCardButton = "//a[@class='shopping_cart_link']";

    public void waitAppLogo() {
        $(byXpath(logo)).shouldBe(visible, Duration.ofSeconds(30));
    }

    public ElementsCollection getItems() {
        shouldCollection("xpath", CollectionCondition.size(6), headers);
        return getElements("xpath", headers);
    }

    public void clickItemHeaderByName(String headerName) {
        should("xpath", clickable, headerByName, headerName);
        click("xpath", headerByName, headerName);
    }

    public void clickItemHeaderById(int id) {
        should("xpath", clickable, headerById, id);
        click("xpath", headerById, id);
    }

    public void clickAddToCardButton() {
        should("xpath", clickable, buttons);
        click("xpath", buttons);
    }

    public void clickShoppingCardButton() {
        should("xpath", clickable, shoppingCardButton);
        click("xpath", shoppingCardButton);
    }

    public void clickBackToProductsButton() {
        should("id", clickable, backToProductsButton);
        click("id", backToProductsButton);
    }

    public List<Item> getItemsList() {
        List<Item> itemList = new ArrayList<>();

        List<String> headersList = getElementsText("xpath", headers);
        List<String> descriptionsList = getElementsText("xpath", descriptions);
        List<String> pricesList = getElementsText("xpath", prices);

        for (int i = 0; i < headersList.size(); i++) {
            Item item = new Item();

            item.setName(headersList.get(i));
            item.setDescription(descriptionsList.get(i));
            item.setPrice(pricesList.get(i));

            itemList.add(item);
        }
        return itemList;
    }
}

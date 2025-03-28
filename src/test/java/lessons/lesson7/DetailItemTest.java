package lessons.lesson7;

import org.base.config.BaseTest;
import org.base.pages.Item;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.base.Pages.*;
import static org.base.helpers.Constants.LOGIN_PASSWORD;
import static org.base.helpers.Constants.LOGIN_USERNAME;

public class DetailItemTest extends BaseTest {

    @Test
    public void detailItemTest() {
        loginPage().typeUsername(LOGIN_USERNAME);
        loginPage().typePassword(LOGIN_PASSWORD);
        loginPage().clickLoginButton();

        List<Item> itemsList = mainPage().getItemsList();

        mainPage().clickItemHeaderByName("Sauce Labs Fleece Jacket");

        Item detailedItem = detailItemPage().getDetailedItem();

        Assert.assertTrue(itemsList.contains(detailedItem), "List " + itemsList + " does not contains detailed item " + detailedItem);
    }
}

package lessons.lesson6;

import com.codeborne.selenide.ElementsCollection;
import org.base.config.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.base.Pages.*;
import static org.base.helpers.Constants.*;

public class CustomFrameworkTest extends BaseTest {
    @Test
    public void customFrameworkTest() {
        loginPage().typeUsername(LOGIN_USERNAME);
        loginPage().typePassword(LOGIN_PASSWORD);
        loginPage().clickLoginButton();

        ElementsCollection items = mainPage().getItems();

        for (int i = 1; i <= items.size(); i++) {
            mainPage().clickItemHeaderById(i);
            mainPage().clickBackToProductsButton();
        }
    }
}

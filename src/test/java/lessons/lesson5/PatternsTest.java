package lessons.lesson5;

import org.base.config.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.base.Pages.*;
import static org.base.helpers.Constants.*;

public class PatternsTest extends BaseTest {

    @Test(description = "Verify user is able to buy item test")
    public void patternsTest() {
        loginPage().typeUsername(LOGIN_USERNAME);
        loginPage().typePassword(LOGIN_PASSWORD);
        loginPage().clickLoginButton();

        mainPage().waitAppLogo();

        String headerTextFromMainPage = mainPage().getItems().get(0).text();

        mainPage().clickAddToCardButton();
        mainPage().clickShoppingCardButton();

        String headerTextFromYourCartPage = yourCartPage().getItems().get(0).text();

        Assert.assertEquals(headerTextFromMainPage, headerTextFromYourCartPage);

        yourCartPage().clickCheckoutButton();

        checkoutYourInformationPage().fillInformationInputs(FIRSTNAME, LASTNAME, ZIP);
        checkoutYourInformationPage().clickContinueButton();

        String headerTextFromCheckoutOverviewPage = checkoutOverviewPage().getItems().get(0).text();

        Assert.assertEquals(headerTextFromMainPage, headerTextFromCheckoutOverviewPage);

        checkoutOverviewPage().clickFinishButton();

        Assert.assertTrue(checkoutCompletePage().isCompleteHeaderVisible(), "Complete header is not visible");
        checkoutCompletePage().clickBackHomeButton();
    }
}

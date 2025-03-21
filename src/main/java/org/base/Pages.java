package org.base;

import org.base.pages.*;

public class Pages {
    private static LoginPage loginPage;
    private static MainPage mainPage;
    private static YourCartPage yourCartPage;
    private static CheckoutYourInformationPage checkoutYourInformationPage;
    private static CheckoutOverviewPage checkoutOverviewPage;
    private static CheckoutCompletePage checkoutCompletePage;

    public static LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public static MainPage mainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    public static YourCartPage yourCartPage() {
        if (yourCartPage == null) {
            yourCartPage = new YourCartPage();
        }
        return yourCartPage;
    }

    public static CheckoutYourInformationPage checkoutYourInformationPage() {
        if (checkoutYourInformationPage == null) {
            checkoutYourInformationPage = new CheckoutYourInformationPage();
        }
        return checkoutYourInformationPage;
    }

    public static CheckoutOverviewPage checkoutOverviewPage() {
        if (checkoutOverviewPage == null) {
            checkoutOverviewPage = new CheckoutOverviewPage();
        }
        return checkoutOverviewPage;
    }

    public static CheckoutCompletePage checkoutCompletePage() {
        if (checkoutCompletePage == null) {
            checkoutCompletePage = new CheckoutCompletePage();
        }
        return checkoutCompletePage;
    }

}

package lessons.lesson4;

import com.codeborne.selenide.*;
import org.base.config.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AssertionsTest extends BaseTest {
    @Test
    public void checkboxTest() {
        ElementsCollection checkboxes = $$(byXpath("//input[@type='checkbox']"));

        for (int i = 0; i < checkboxes.size(); i++) {
            checkboxes.get(i).shouldBe(clickable).click();
            Assert.assertTrue(checkboxes.get(i).is(checked), "checkbox is not checked");
        }
        Assert.assertEquals($(byXpath("//input[@type='text']")).getValue(), "100", "values missmatch " + $(byXpath("//input[@type='text']")).getValue());
    }

    //    @Test
    public void assertionsTest() {
        $(byXpath("//input[@id='user-name']")).append("standard_user");
        $(byAttribute("placeholder", "Password")).append("secret_sauce");
        $(byCssSelector("input.submit-button")).pressEnter();
        //SHOULD BE
//        Selenide.switchTo().frame(1);
//
//        $(byXpath("//button[text()='Try it']")).click();
//
//        System.out.println($(byXpath("//input[@type='checkbox']")).is(enabled));
//        System.out.println($(byXpath("//input[@type='checkbox']")).is(clickable));
//        System.out.println($(byXpath("//input[@type='checkbox']")).is(disabled));
//        System.out.println($(byXpath("//input[@type='checkbox']")).is(not(clickable)));

//        WebElementCondition inputCondition = and("input condition", visible, empty);
//
//        $(byXpath("//input[@placeholder='Username']")).append("asd");
//
//        WebElementCondition orCondition = or("or", visible, empty);
//        $(byXpath("//input[@placeholder='Username']")).shouldBe(orCondition).append("asd");
//        $(byXpath("//input[@placeholder='Username']")).shouldBe(empty, Duration.ofSeconds(15)).append("asd");

//        System.out.println($(byXpath("//h3[@data-test='error']")).is(hidden));
//        System.out.println($(byXpath("//h3[@data-test='error']")).is(visible));
//        System.out.println($(byXpath("//h3[@data-test='error']")).is(exist));
//        System.out.println($(byXpath("//input[@type='submit']")).is(clickable));
//        System.out.println($(byXpath("//input[@type='submit']")).is(enabled));
//        System.out.println($(byXpath("//input[@type='submit']")).is(readonly));
//        System.out.println($(byXpath("//h3[@data-test='error']")).is(hidden));
//        System.out.println($(byXpath("//h3[@data-test='error']")).is(visible));
//        System.out.println($(byXpath("//h3[@data-test='error']")).is(exist));

//        $(byXpath("//h3[@data-test='error']")).shouldBe(exist);


        //SHOULD HAVE

//        $(byXpath("//input[@placeholder='Username']")).shouldHave(Condition.cssClass("input_error")).append("asd");
//        $(byXpath("//input[@placeholder='Username']")).shouldHave(Condition.id("user-name")).append("asd");
//        $(byXpath("//input[@placeholder='Username']")).shouldHave(Condition.value("ASDASD")).append("asd");
//        $(byXpath("//input[@placeholder='Username']")).shouldHave(Condition.type("text")).append("asd");
//        $(byXpath("//input[@placeholder='Username']")).shouldHave(Condition.name("user-name")).append("asd");
//        $(byXpath("//input[@placeholder='Username']")).shouldHave(Condition.attribute("placeholder", "Username")).append("asd");
//        $(byXpath("//input[@placeholder='Username']")).shouldHave(Condition.exactValue("asdasdasdasdasdasd")).append("asd");

//        $(byXpath("(//div[@class='inventory_item_name '])[1]")).shouldHave(Condition.text("Sauce Labs")).click();
//        $(byXpath("(//div[@class='inventory_item_name '])[1]")).shouldHave(Condition.exactText("Sauce Labs backpack")).click();
//        $(byXpath("(//div[@class='inventory_item_name '])[1]")).shouldHave(Condition.exactTextCaseSensitive("Sauce Labs Backpack")).click();
//        $(byXpath("(//div[@class='inventory_item_name '])[1]")).shouldHave(Condition.textCaseSensitive("Sauce Labs backpack")).click();

//
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(CollectionCondition.size(6)).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(CollectionCondition.sizeGreaterThan(0)).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(CollectionCondition.sizeNotEqual(0)).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(CollectionCondition.sizeGreaterThanOrEqual(6)).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(CollectionCondition.sizeLessThan(7)).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(CollectionCondition.sizeLessThanOrEqual(6)).texts());


//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(CollectionCondition.texts("Sauce", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)")).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(CollectionCondition.textsInAnyOrder("Sauce Labs Bike Light","Sauce", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)")).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(CollectionCondition.exactTexts("Sauce Labs Backpack","Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "test.allTheThings() T-Shirt (Red)")).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(CollectionCondition.exactTextsCaseSensitive("Sauce Labs Backpack","Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)")).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(CollectionCondition.itemWithText("Sauce Labs Fleece Jacket")).texts());

//        ElementsCollection elements = $$(byXpath("//div[@class='inventory_item_name ']"));
//
//        Assert.assertEquals(elements.size(), 6, "Size is not 6");
//
//        String appLogoText = $(byXpath("//div[@class='app_logo']")).text();
//
//        Assert.assertEquals(appLogoText, "Swag Labs", "app logo is not Swag Labs");
//
//        List<String> actualTexts = $$(byXpath("//div[@class='inventory_item_name ']")).texts();
//
//        List<String> stringList = List.of("Sauce Labs Backpack","Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)");
//
//        Assert.assertEquals(actualTexts, stringList, "lists are different");
//
//        Assert.assertTrue(actualTexts.contains("Sauce Labs Bike Light"));
//
//        Assert.assertFalse(actualTexts.contains("asdasd"));
//
//        Assert.assertNotEquals(appLogoText, "Swag Lab");

    }
}

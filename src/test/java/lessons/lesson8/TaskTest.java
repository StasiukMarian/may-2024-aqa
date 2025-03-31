package lessons.lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TaskTest {
    //    @Test
    public void progressBarTest() {
        Selenide.open("https://demoqa.com/progress-bar");

        $(byId("startStopButton")).shouldBe(clickable).scrollTo().click();

        while (true) {
            if ($(byXpath("//div[@role='progressbar']")).scrollTo().text().equals("48%")) {
                break;
            }
        }

        $(byId("startStopButton")).shouldBe(clickable).scrollTo().click();

        Assert.assertEquals($(byXpath("//div[@role='progressbar']")).text(), "50%");
    }

    //    @Test
    public void alertTest() {
        Selenide.open("https://demoqa.com/alerts");
//        $(byId("alertButton")).scrollTo().click();

//        String confirm = Selenide.confirm();

//        Assert.assertEquals(confirm, "You clicked a button");

        $(byId("confirmButton")).scrollTo().click();

        Selenide.sleep(2000);

        String dismiss = dismiss();


        Assert.assertEquals($(byId("confirmResult")).text(), "You selected Cancel");
    }

//    @Test
    public void shadowCssTest() {
        Selenide.open("http://uitestingplayground.com/shadowdom");

        $(shadowCss("#buttonGenerate", "guid-generator")).shouldBe(clickable).click();

        String valueFromInput = $(shadowCss("#editField", "guid-generator")).shouldBe(not(empty)).getValue();

        $(shadowCss("#buttonCopy", "guid-generator")).shouldBe(clickable).click();

        String textFromClipboard = clipboard().getText();

        Assert.assertEquals(valueFromInput, textFromClipboard);
    }

    @Test
    public void iframeTest(){
        Selenide.open("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");

        Selenide.switchTo().frame("iframeResult");

        Selenide.switchTo().frame($(byXpath("//iframe[@title='W3Schools Free Online Web Tutorials']")));

        $(byXpath("//a[text()='CSS']")).shouldBe(clickable).click();
    }

}

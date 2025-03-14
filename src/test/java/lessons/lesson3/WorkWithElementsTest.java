package lessons.lesson3;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.io.FileUtils;
import org.base.config.BaseTest;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WorkWithElementsTest extends BaseTest {
//    @Test
    public void hoverTest(){
        $(byXpath("(//nav[@class='nav-menu']//a)[1]")).hover();
    }
    @Test
    public void doubleClickTest(){
        $(byXpath("//p[@id='container-text']")).doubleClick();
    }
    //    @Test
    public void downloadTest() throws IOException {
        File download = $(byXpath("(//h3/a)[1]")).scrollTo().download();

        String path = download.getPath();

        System.out.println(path);

        FileUtils.deleteDirectory(new File("build/downloads"));
    }

    public static String getFilePathByName(String fileName) {
        return new File("src/main/resources/files/" + fileName).getAbsolutePath();
    }

//    @Test
    public void uploadFile() {
        $(byXpath("//input[@type='file']")).uploadFile(new File(getFilePathByName("annual-enterprise-survey-2023-financial-year-provisional.csv")));
    }

    //    @Test
    public void workWithElementsTest() {
        $(byXpath("//input[@id='user-name']")).append("standard_user");
        $(byAttribute("placeholder", "Password")).append("secret_sauce");
        $(byCssSelector("input.submit-button")).pressEnter();
//        Selenide.actions().sendKeys(Keys.ENTER).perform();

//        $(byId("password")).append("asdasd");
//        $(byClassName("input_error")).append("asd");
//        $(byName("user-name")).append("test");
//        $(byTagName("input")).append("asd");
//        $(by("placeholder", "Password")).append("asd");
//        $(byValue("test")).append("asd");
//        String text = $(byXpath("//div[@class='login_logo']")).text();
//        $(byCssSelector("#login-button")).submit();
//        $(byCssSelector("#login-button")).click();
//        $(byCssSelector(".input_error")).append("test");
//        $(byCssSelector("#password.input_error.form_input")).append("test");
//        $(byCssSelector("[placeholder='Password']")).append("asdasd");
//        $(byCssSelector("input")).append("asda");
//        $(byCssSelector("input[placeholder='Password'][data-test='password']")).append("asda");
//        $(byCssSelector("input.submit-button")).submit();

//        $(byXpath("//input[@id='user-name']")).clear();
//        String value = $(byXpath("//input[@id='user-name']")).getValue();

//        for (int i = 0; i < value.length(); i++) {
//            Selenide.actions().sendKeys($(byXpath("//input[@id='user-name']")), Keys.BACK_SPACE).perform();
//        }


//        $(byCssSelector(".product_sort_container")).selectOption("Name (Z to A)");

//        $(byCssSelector(".product_sort_container")).click();
//        Selenide.sleep(2000);
//        $(byCssSelector(".product_sort_container")).pressEscape();
//        Selenide.actions().sendKeys(Keys.ESCAPE).perform();
//        ElementsCollection elementsCollection = $$(byXpath("//div[@class='inventory_item_name ']"));
//
//        String text = elementsCollection.get(3).getText();
//        System.out.println(text);

//        elementsCollection.get(3).click();


//        ElementsCollection buttonsCollection = $$(byXpath("//button[text()='Add to cart']"));
//
//        while (buttonsCollection.size() > 0){
//            $(byXpath("//button[text()='Add to cart']")).click();
//        }

        $(byXpath("//a[text()='Twitter']")).click();

        Selenide.switchTo().window(1);

        Selenide.sleep(3000);

        $(byXpath("//nav[@role='navigation']//a[@href='/settings']")).click();
        Selenide.sleep(3000);
        Selenide.closeWindow();
        Selenide.switchTo().window(0);
        Selenide.sleep(3000);

        ElementsCollection elementsCollection = $$(byXpath("//div[@class='inventory_item_name ']"));

        System.out.println(elementsCollection);
    }
}

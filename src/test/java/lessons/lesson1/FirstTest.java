package lessons.lesson1;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.base.config.BaseTest;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.$;

public class FirstTest extends BaseTest {

    @Test
    public void firstTest() {
        $("asd").click();
    }


}

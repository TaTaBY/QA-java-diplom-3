import com.codeborne.selenide.Configuration;
import com.pages.MainPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    @BeforeClass
    public static void beforeTest () {

        System.setProperty("selenide.browser", "Chrome");
        Configuration.pageLoadTimeout = 120000;
        MainPage mainPage = open(MainPage.URL, MainPage.class);
    }

    @AfterClass
    public static void afterTest () {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }
}

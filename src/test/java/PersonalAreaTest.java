import com.UserOperations;
import com.pages.MainPage;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Map;

import static com.codeborne.selenide.Selenide.page;
import static junit.framework.TestCase.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonalAreaTest extends BaseTest {

    private static UserOperations userOperations;
    private static Map<String, String> loginData;

    @BeforeClass
    public static void setUp () {
        userOperations = new UserOperations();
        loginData = userOperations.register();
        page(MainPage.class)
                .clickLoginLink()
                .login(loginData.get("email"), loginData.get("password"));
    }


    @AfterClass
    public static void tearDownOnce () {
        userOperations.delete();
    }

    @Test
    public void personalAreaMoveCheck () {

        boolean isPersonalArea = page(MainPage.class)
                .clickPersonalAreaLink()
                .checkPersonalArea();

        assertTrue(isPersonalArea);
    }

    @Test
    public void personalAreaMoveByConstructor () {

        boolean isMainPageMoveByConstructorButton = page(MainPage.class)
                .clickPersonalAreaLink()
                .clickConstructorButton()
                .mainPageCheck();

        assertTrue(isMainPageMoveByConstructorButton);
    }

    @Test
    public void personalAreaMoveByBanner() {

        boolean isMainPageMoveByLogo = page(MainPage.class)
                .clickPersonalAreaLink()
                .clickLogo()
                .mainPageCheck();

        assertTrue(isMainPageMoveByLogo);
    }

    @Test
    public void personalAreaPressExit() {

        boolean isExit = page(MainPage.class)
                .clickPersonalAreaLink()
                .clickExitCheck();

        assertTrue(isExit);
    }
}

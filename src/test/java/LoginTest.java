import com.UserOperations;
import com.pages.MainPage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static junit.framework.TestCase.assertTrue;


public class LoginTest extends BaseTest {

    private static UserOperations userOperations;
    private static Map<String, String> loginData;

    @BeforeClass
    public static void setUp () {
        userOperations = new UserOperations();
        loginData = userOperations.register();
    }

    @After
    public void tearDown () {
        page(MainPage.class)
                .clickPersonalAreaLink()
                .clickExit();
    }

    @AfterClass
    public static void tearDownOnce () {
        userOperations.delete();
    }

    @Test
    public void loginFromPersonalArea () {

        boolean isRegistered = page(MainPage.class)
                .clickLoginLink()
                .login(loginData.get("email"), loginData.get("password"));

        assertTrue(isRegistered);
    }

    @Test
    public void loginFromLoginButtonMainPage () {

        boolean isRegistered = page(MainPage.class)
                .clickLoginButton()
                .login(loginData.get("email"), loginData.get("password"));

        assertTrue(isRegistered);
    }

    @Test
    public void loginFromLoginLinkRegistrationPage() {

        boolean isRegistered = page(MainPage.class)
                .clickLoginLink()
                .clickRegisterLink()
                .clickLoginButton()
                .login(loginData.get("email"), loginData.get("password"));

        assertTrue(isRegistered);
    }

    @Test
    public void loginFromLoginLinkRestorePassword() {

        boolean isRegistered = page(MainPage.class)
                .clickLoginLink()
                .clickRestoreButton()
                .clickLoginButton()
                .login(loginData.get("email"), loginData.get("password"));

        assertTrue(isRegistered);
    }
}

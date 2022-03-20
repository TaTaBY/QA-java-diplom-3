import com.pages.MainPage;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.page;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


public class RegistrationTest extends BaseTest {

    @Test
    public void registrationWithValidData () {

        boolean isRegistered = page(MainPage.class)
                .clickLoginLink()
                .clickRegisterLink()
                .fillInRegistrationForm();

        assertTrue(isRegistered);
    }

    @Test
    public void registrationErrorMessageWithPasswordLessSixLetter() {

        MainPage mainPage = page(MainPage.class);

        String actualErrorMessage = page(MainPage.class)
                .clickLoginLink()
                .clickRegisterLink()
                .fillInRegistrationFormWithPasswordLessSixLetter();
        String expectedErrorMessage = "Некорректный пароль";

        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

}

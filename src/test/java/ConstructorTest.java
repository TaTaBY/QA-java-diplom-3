import com.pages.MainPage;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.page;
import static junit.framework.TestCase.assertTrue;


public class ConstructorTest extends BaseTest {

    @Test
    public void toppingMoveCheck () {

        boolean isToppingsPresent = page(MainPage.class)
                .checkClickToppings();

        assertTrue(isToppingsPresent);
    }

    @Test
    public void sauceMoveCheck () {

        boolean isToppingsPresent = page(MainPage.class)
                .checkClickSauce();

        assertTrue(isToppingsPresent);
    }

    @Test
    public void bunMoveCheck () {

        boolean isToppingsPresent = page(MainPage.class)
                .clickToppings()
                .checkClickBun();

        assertTrue(isToppingsPresent);
    }

}

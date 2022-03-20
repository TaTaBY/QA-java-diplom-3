package com.pages;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public static final String URL  = "https://stellarburgers.nomoreparties.site";

    @FindBy(how = How.CLASS_NAME,using = "AppHeader_header__link__3D_hX")
    private ElementsCollection headerMenuLinks;

    public LoginPage clickLoginButton () {
        $(byText("Войти в аккаунт")).click();
        $(byText("Вход")).shouldBe(visible);
        return page(LoginPage.class);
    }

    public LoginPage clickLoginLink() {
        headerMenuLinks.get(2).click();
        $(byText("Вход")).shouldBe(visible);
        return page(LoginPage.class);
    }

    public PersonalAreaPage clickPersonalAreaLink() {
        headerMenuLinks.get(2).click();
        $(byText("Профиль")).shouldBe(visible);
        return page(PersonalAreaPage.class);
    }

    public boolean mainPageCheck () {
        return  $(byText("Оформить заказ")).isDisplayed();
    }

    public boolean checkClickToppings () {
        $(byText("Начинки")).click();
        $(byText("Филе Люминесцентного тетраодонтимформа")).shouldBe(visible);
        return  $(byText("Филе Люминесцентного тетраодонтимформа")).isDisplayed();

    }

    public MainPage clickToppings () {
        $(byText("Начинки")).click();
        return this;
    }

    public boolean checkClickSauce () {
        $(byText("Соусы")).click();
        $(byText("Соус с шипами Антарианского плоскоходца")).shouldBe(visible);
        return  $(byText("Соус с шипами Антарианского плоскоходца")).isDisplayed();
    }

    public boolean checkClickBun () {
        $(byText("Булки")).click();
        $(byText("Флюоресцентная булка R2-D3")).shouldBe(visible);
        return  $(byText("Флюоресцентная булка R2-D3")).isDisplayed();
    }
}


package com.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    @FindBy(how = How.CLASS_NAME,using = "Auth_link__1fOlj")
    private ElementsCollection registerOrRestoreLink;

    @FindBy(how = How.TAG_NAME,using = "input")
    private ElementsCollection loginInputs;

    public RegisterPage clickRegisterLink() {
        registerOrRestoreLink.get(0).click();
        $(byText("Регистрация")).shouldBe(visible);
        return page(RegisterPage.class);
    }

    public void setEmailLogin(String login) {
        loginInputs.get(0).setValue(login);
    }

    public void setPasswordLogin(String password) {
        loginInputs.get(1).setValue(password);
    }

    public void clickLogin () {
        $(byText("Войти")).click();
    }

    public boolean login (String login, String password) {
        setEmailLogin(login);
        setPasswordLogin(password);
        clickLogin();
        $(byText("Оформить заказ")).shouldBe(visible);
        return $(byText("Оформить заказ")).isDisplayed();
    }

    public RegisterPage clickRestoreButton () {
        registerOrRestoreLink.get(1).click();
        return page(RegisterPage.class);
    }

    public void clickExit () {
        $(byText("Выход")).click();
    }
}

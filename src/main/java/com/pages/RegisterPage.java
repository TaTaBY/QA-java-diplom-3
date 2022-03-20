package com.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RegisterPage {

    @FindBy(how = How.TAG_NAME,using = "input")
    private ElementsCollection registrationForm;

    @FindBy(how = How.CLASS_NAME,using = "input__error")
    private SelenideElement errorMessage;

    @FindBy(how = How.CLASS_NAME,using = "Auth_link__1fOlj")
    private SelenideElement loginButton;

    Faker faker = Faker.instance();

    public void setName() {
        registrationForm.get(0).setValue(faker.name().name());
    }

    public void setEmail() {
        registrationForm.get(1).setValue(faker.internet().emailAddress());
    }

    public void setPassword(String email) {
        registrationForm.get(2).setValue(email);
    }

    public void setPassword() {
        registrationForm.get(2).setValue(faker.internet().password());
    }

    public void clickRegisterButton() {
        $(byText("Зарегистрироваться")).click();
    }

    public boolean fillInRegistrationForm() {
        setName();
        setEmail();
        setPassword();
        clickRegisterButton();
        $(byText("Вход")).shouldBe(visible);
        return $(byText("Вход")).isDisplayed();
    }

    public String fillInRegistrationFormWithPasswordLessSixLetter() {
        setName();
        setEmail();
        setPassword(faker.internet().password(1, 5));
        clickRegisterButton();
        return errorMessage.getText();
    }

    public LoginPage clickLoginButton () {
        loginButton.click();
        return page(LoginPage.class);
    }
}

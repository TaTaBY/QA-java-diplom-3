package com.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class PersonalAreaPage {

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__link__3D_hX")
    private ElementsCollection headerMenuLinks;

    @FindBy(how = How.CLASS_NAME, using = "Account_list__3KQQf")
    private SelenideElement accountList;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logo;

    public void clickExit() {
        $(byText("Выход")).click();
    }

    public boolean clickExitCheck() {
        $(byText("Выход")).click();
        return $(byText("Вход")).shouldBe(visible).isDisplayed();
    }

    public boolean checkPersonalArea() {
        return accountList.isDisplayed();
    }

    public MainPage clickConstructorButton() {
        headerMenuLinks.get(0).click();
        return page(MainPage.class);
    }

    public MainPage clickLogo() {
        logo.click();
        return page(MainPage.class);
    }

}

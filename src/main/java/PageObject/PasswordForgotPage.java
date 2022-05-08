package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PasswordForgotPage {
    //URL страницы восстановления пароля
    public static final String FORGOT_PASSWORD_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    //Кнопка "Войти"
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement entryButton;

    //Клик кнопку "Войти"
    @Step("Click the entry button")
    public void clickTheEntryButton() {
        entryButton.scrollTo().click();
    }
}

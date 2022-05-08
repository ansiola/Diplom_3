import PageObject.MainPage;
import PageObject.RegistrationPage;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static PageObject.LoginPage.LOGIN_PAGE_URL;
import static PageObject.RegistrationPage.REGISTER_PAGE_URL;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserRegistrationTests {
    MainPage mainPage;

    @Before
    public void setUp() {
        closeWebDriver();
        Configuration.browser = browser;
    }

    @Test
    @DisplayName("Correct registration")
    @Description("При успешной регистрации переход на страницу входа")
    public void checkTheCorrectRegistration() {
        RegistrationPage registerPage = open(REGISTER_PAGE_URL, RegistrationPage.class);
        registerPage.registration(registerPage.NAME, registerPage.EMAIL, registerPage.PASSWORD);
        registerPage.waitAfterRegistration();
        assertEquals("After successful registration user must be redirected on the login page!",
                url(), LOGIN_PAGE_URL);
    }

    @Test
    @DisplayName("Registration with short password")
    @Description("Регистрация с некорректным по заданной длине символов паролем, отображение ошибки")
    public void checkTheRegistrationWithIncorrectPassword() {
        RegistrationPage registerPage = open(REGISTER_PAGE_URL, RegistrationPage.class);
        registerPage.registration(registerPage.NAME, registerPage.EMAIL, registerPage.INCORRECT_PASSWORD);
        assertTrue("The incorrect password sign must be visible", registerPage.checkIncorrectPasswordSign());
    }
}

import PageObject.PasswordForgotPage;
import PageObject.LoginPage;
import PageObject.MainPage;
import PageObject.RegistrationPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static PageObject.PasswordForgotPage.FORGOT_PASSWORD_URL;
import static PageObject.MainPage.MAIN_PAGE_URL;
import static PageObject.RegistrationPage.REGISTER_PAGE_URL;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;

public class UserLoginTests {
    MainPage mainPage;

    @Before
    public void setUp() {
        closeWebDriver();
        Configuration.browser = browser;
    }

    @After
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    @DisplayName("Correct entry from the main page via the account entry button")
    @Description("Корректный вход с главной страницы через кнопку «Войти в аккаунт»")
    public void checkLoginFromMainPageViaEntryButton() {
        MainPage main = open(MAIN_PAGE_URL, MainPage.class);
        main.clickAccountEntryButton();
        LoginPage login = page(LoginPage.class);
        login.entry(login.EMAIL, login.PASSWORD);
        login.waitAfterEntry();
        assertEquals("After successful login user must be redirected on the main page!",
                url(), MAIN_PAGE_URL);
    }

    @Test
    @DisplayName("Correct entry from the main page via the personal account button")
    @Description("Корректный вход с главной страницы через кнопку «Личный кабинет»")
    public void checkLoginFromMainPageViaPersonalAccountButton() {
        MainPage main = open(MAIN_PAGE_URL, MainPage.class);
        main.clickPersonalAccountButton();
        LoginPage login = page(LoginPage.class);
        login.entry(login.EMAIL, login.PASSWORD);
        login.waitAfterEntry();
        assertEquals("After successful login user must be redirected on the main page!",
                url(), MAIN_PAGE_URL);
    }

    @Test
    @DisplayName("Correct entry from the registration page via the entry button")
    @Description("Корректный вход со страницы регистрации через кнопку «Войти»")
    public void checkLoginFromRegistrationPageViaPersonalAccountButton() {
        RegistrationPage register = open(REGISTER_PAGE_URL, RegistrationPage.class);
        register.clickTheEntryButton();
        LoginPage login = page(LoginPage.class);
        login.entry(login.EMAIL, login.PASSWORD);
        login.waitAfterEntry();
        assertEquals("After successful login user must be redirected on the main page!",
                url(), MAIN_PAGE_URL);
    }

    @Test
    @DisplayName("Correct entry from the forgot password page via the entry button")
    @Description("Переход со страницы восстановления пароля через кнопку «Войти»")
    public void checkLoginFromForgotPasswordPageViaEntryButton() {
        PasswordForgotPage forgotPasswordPage = open(FORGOT_PASSWORD_URL, PasswordForgotPage.class);
        forgotPasswordPage.clickTheEntryButton();
        LoginPage login = page(LoginPage.class);
        login.entry(login.EMAIL, login.PASSWORD);
        login.waitAfterEntry();
        assertEquals("After successful login user must be redirected on the main page!",
                url(), MAIN_PAGE_URL);
    }
}

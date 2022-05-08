import PageObject.LoginPage;
import PageObject.MainPage;
import PageObject.AccountPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static PageObject.LoginPage.LOGIN_PAGE_URL;
import static PageObject.MainPage.MAIN_PAGE_URL;
import static PageObject.AccountPage.PERSONAL_ACCOUNT_PAGE_URL;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;

public class AccountPageTests {
    MainPage mainPage;

    @Before
    public void login() {
        closeWebDriver();
        Configuration.browser = browser;
        MainPage main = open(MAIN_PAGE_URL, MainPage.class);
        main.clickAccountEntryButton();
        LoginPage login = page(LoginPage.class);
        login.entry(login.EMAIL, login.PASSWORD);
    }

    @After
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    @DisplayName("Entry and move to the personal account page via the PA button")
    @Description("Переход в личный кабинет с главной страницы")
    public void checkTheTransitionToThePersonalAccountPage() {
        MainPage main = page(MainPage.class);
        main.clickPersonalAccountButton();
        AccountPage personalPage = page(AccountPage.class);
        personalPage.waitAfterTransition();
        assertEquals("After click to the PA button user must be redirected on the personal account page!",
                url(), PERSONAL_ACCOUNT_PAGE_URL);
    }

    @Test
    @DisplayName("Transition to the main page after click the constructor button")
    @Description("Переход из личного кабинета в конструктор по нажатию на кнопку «Конструктор»")
    public void checkTheTransitionAfterClickConstructorButton() {
        MainPage main = page(MainPage.class);
        main.clickPersonalAccountButton();
        AccountPage personalPage = page(AccountPage.class);
        personalPage.waitAfterTransition();
        personalPage.clickTheConstructorButton();
        assertEquals("After click to the constructor button user must be redirected on the main page!",
                url(), MAIN_PAGE_URL);
    }

    @Test
    @DisplayName("Transition to the main page after click the the logo")
    @Description("Переход из личного кабинета в конструктор по нажатию на лого бургера")
    public void checkTheTransitionAfterClickLogo() {
        MainPage main = page(MainPage.class);
        main.clickPersonalAccountButton();
        AccountPage personalPage = page(AccountPage.class);
        personalPage.waitAfterTransition();
        personalPage.clickTheLogo();
        assertEquals("After click to the logo user must be redirected on the main page!",
                url(), MAIN_PAGE_URL);
    }

    @Test
    @DisplayName("Transition to the login page after click to the logout button")
    @Description("Переход из личного кабинета на страницу логина после выхода")
    public void checkTheTransitionAfterLogOut() {
        MainPage main = page(MainPage.class);
        main.clickPersonalAccountButton();
        AccountPage personalPage = page(AccountPage .class);
        personalPage.waitAfterTransition();
        personalPage.clickTheLogOutButton();
        personalPage.waitAfterLogOut();
        assertEquals("After click to the log out button user must be redirected on the login page!",
                url(), LOGIN_PAGE_URL);
    }
}

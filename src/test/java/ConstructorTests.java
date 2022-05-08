import PageObject.MainPage;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static PageObject.MainPage.MAIN_PAGE_URL;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class ConstructorTests {
    MainPage mainPage;

    @Before
    public void setUp() {
        closeWebDriver();
        Configuration.browser = browser;
    }

    @Test
    @DisplayName("Check transition of buns button")
    @Description("Проверка перехода к разделу «Булки», добавление элемента в корзину")
    public void checkTransitionOfBunsButton() {
        MainPage main = open(MAIN_PAGE_URL, MainPage.class);
        assertTrue("After drag and drop the bun in the order basket must be visible", main.clickBunsButtonCheckTheSign());
    }

    @Test
    @DisplayName("Check transition of sauces button")
    @Description("Проверка перехода к разделу «Соусы», добавление элемента в корзину")
    public void checkTransitionOfSaucesButton() {
        MainPage main = open(MAIN_PAGE_URL, MainPage.class);
        assertTrue("After drag and drop the sauce in the order basket must be visible", main.clickSaucesButtonAndCheckTheSign());
    }

    @Test
    @DisplayName("Check transition of sauces button")
    @Description("Проверка перехода к разделу «Начинки», добавление элемента в корзину")
    public void checkTransitionOfFillingButton() {
        MainPage main = open(MAIN_PAGE_URL, MainPage.class);
        assertTrue("After drag and drop the filling in the order basket must be visible", main.clickFillingButtonAndCheckTheSign());
    }
}

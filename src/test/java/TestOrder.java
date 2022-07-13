import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.notNullValue;

import org.hamcrest.MatcherAssert;

import static org.hamcrest.CoreMatchers.startsWith;


public class TestOrder {

    private WebDriver driver;

    String actual;
    String jSign;

    @Before
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        System.setProperty("webdriver.chrome.driver", "C:/cygwin64/home/Belka/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

    }

    // Оформление заказа при нажатии верхней кнопки "Заказать"
    @Test
    public void CorrectOrderUpperButton() {

        pageobject.HomePageScooter objHomePage = new pageobject.HomePageScooter(driver);
        pageobject.OrderPageScooter objOrderPage = new pageobject.OrderPageScooter(driver);
        objHomePage.clickCookieButton();
        objHomePage.clickUpperOrderButton();
        objOrderPage.whoIsScooterForFormField("Иван", "Петров", "Ленинградский", "Сокольники", "89304563748");
        objOrderPage.aboutRentalFormField("14.07.2022", "трое суток", "тест тест");
        objOrderPage.clickColourFieldBlack();
        objOrderPage.clickOrderButtonYes();
        actual = objOrderPage.getFinalFormText();
        jSign = "Заказ оформлен";
        MatcherAssert.assertThat(actual, startsWith(jSign));
    }

    // Оформление заказа при нажатии нижней кнопки "Заказать"
    @Test
    public void CorrectOrderLowerButton() {

        pageobject.HomePageScooter objHomePage = new pageobject.HomePageScooter(driver);
        pageobject.OrderPageScooter objOrderPage = new pageobject.OrderPageScooter(driver);
        objHomePage.clickCookieButton();
        objHomePage.clickLowerOrderButton();
        objOrderPage.whoIsScooterForFormField("Ирина", "Скворцова", "Ленина, 31", "Лубянка", "+79201342345");
        objOrderPage.aboutRentalFormField("28.07.2022", "семеро суток", "не звоните в домофон");
        objOrderPage.clickColourFieldGrey();
        objOrderPage.clickOrderButtonYes();
        actual = objOrderPage.getFinalFormText();
        jSign = "Заказ оформлен";
        MatcherAssert.assertThat(actual, startsWith(jSign));

    }

    @After
    public void teardown() {
        driver.quit();
    }
}


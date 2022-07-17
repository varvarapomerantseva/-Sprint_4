import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.hamcrest.MatcherAssert;

import static org.hamcrest.CoreMatchers.startsWith;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestOrder {

    private WebDriver driver;
    private final String button;

    public TestOrder(String button) {

        this.button = button;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"upper"},
                {"lower"},
        };
    }

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:/cygwin64/home/Belka/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

    }

    @Test
    public void CorrectOrder() {

        pageobject.HomePageScooter objHomePage = new pageobject.HomePageScooter(driver);
        pageobject.OrderPageScooter objOrderPage = new pageobject.OrderPageScooter(driver);
        objHomePage.clickCookieButton();
        objHomePage.clickOrderButton(button);
        objOrderPage.whoIsScooterForFormField("Иван", "Петров", "Ленинградский", "Сокольники", "89304563748");
        objOrderPage.aboutRentalFormField("14.07.2022", "трое суток", "black", "в домофон не звонить");
        objOrderPage.clickOrderButtonYes();
        String actual = objOrderPage.getFinalFormText();
        String jSign = "Заказ оформлен";
        MatcherAssert.assertThat(actual, startsWith(jSign));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
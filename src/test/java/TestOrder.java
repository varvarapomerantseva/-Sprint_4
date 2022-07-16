import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
    private final String NAME;
    private final String SURNAME;
    private final String ADDRESS;
    private final String STATION;
    private final String NUMBER;
    private final String DATE;
    private final String PERIOD;
    private final String COLOR;
    private final String COMMENT;

    public TestOrder(String name, String surname, String address, String station, String number, String date, String period, String color, String comment) {
        this.NAME = name;
        this.SURNAME = surname;
        this.ADDRESS = address;
        this.STATION = station;
        this.NUMBER = number;
        this.DATE = date;
        this.PERIOD = period;
        this.COLOR = color;
        this.COMMENT = comment;

    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Иван", "Петров", "Ленинградский", "Сокольники", "89304563748", "14.07.2022", "трое суток", "black", "тест тест"},
                {"Ирина", "Скворцова", "Ленина, 31", "Лубянка", "+79201342345", "28.07.2022", "семеро суток", "grey", "не звоните в домофон"},

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
        objHomePage.clickUpperOrderButton();
        objOrderPage.whoIsScooterForFormField(NAME, SURNAME, ADDRESS, STATION, NUMBER);
        objOrderPage.aboutRentalFormField(DATE, PERIOD, COLOR, COMMENT);
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

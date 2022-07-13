import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;

public class TestAnswerTheQuestion {
    private WebDriver driver;
    String expected;
    String actual;

    @Before
    public void openBrowser() {
        // Создаём драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        System.setProperty("webdriver.chrome.driver", "C:/cygwin64/home/Belka/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        WebElement element = driver.findElement(By.id("accordion__heading-1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    @Test
    public void shouldBeAnswerAndTextEqual0() {
        pageobject.HomePageScooter objHomePage = new pageobject.HomePageScooter(driver);
        expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        actual = objHomePage.getHowPayAnswer();
        assertEquals("Текст не совпадает", expected, actual);
    }

    @Test
    public void shouldBeAnswerAndTextEqual1() {
        pageobject.HomePageScooter objHomePage = new pageobject.HomePageScooter(driver);
        expected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        actual = objHomePage.getSeveralScootersAnswer();
        assertEquals("Текст не совпадает", expected, actual);
    }

    @Test
    public void shouldBeAnswerAndTextEqual2() {
        pageobject.HomePageScooter objHomePage = new pageobject.HomePageScooter(driver);
        expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        actual = objHomePage.getCalculationRentalTimeAnswer();
        assertEquals("Текст не совпадает", expected, actual);
    }

    @Test
    public void shouldBeAnswerAndTextEqual3() {
        pageobject.HomePageScooter objHomePage = new pageobject.HomePageScooter(driver);
        expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        actual = objHomePage.getOrderTodayAnswer();
        assertEquals("Текст не совпадает", expected, actual);
    }

    @Test
    public void shouldBeAnswerAndTextEqual4() {
        pageobject.HomePageScooter objHomePage = new pageobject.HomePageScooter(driver);
        expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        actual = objHomePage.getRenewalAndReturnScooterAnswer();
        assertEquals("Текст не совпадает", expected, actual);
    }

    @Test
    public void shouldBeAnswerAndTextEqual5() {
        pageobject.HomePageScooter objHomePage = new pageobject.HomePageScooter(driver);
        expected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        actual = objHomePage.getScooterBatteryAnswer();
        assertEquals("Текст не совпадает", expected, actual);
    }

    @Test
    public void shouldBeAnswerAndTextEqual6() {
        pageobject.HomePageScooter objHomePage = new pageobject.HomePageScooter(driver);
        expected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        actual = objHomePage.getCancelOrderAnswer();
        assertEquals("Текст не совпадает", expected, actual);
    }

    @Test
    public void shouldBeAnswerAndTextEqual7() {
        pageobject.HomePageScooter objHomePage = new pageobject.HomePageScooter(driver);
        expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        actual = objHomePage.getLiveBehindMKADAnswer();
        assertEquals("Текст не совпадает", expected, actual);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
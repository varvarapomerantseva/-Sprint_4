package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageScooter {

    // Сколько это стоит? И как оплатить?
    private final By howPay = By.id("accordion__heading-0");
    // Ответ 0
    private final By howPayAnswer = By.xpath(".//div[@id='accordion__panel-0']/p");
    // Хочу сразу несколько самокатов! Так можно?
    private final By severalScooters = By.id("accordion__heading-1");
    // Ответ 1
    private final By severalScootersAnswer = By.xpath(".//div[@id='accordion__panel-1']/p");
    // Как рассчитывается время аренды?
    private final By calculationRentalTime = By.id("accordion__heading-2");
    // Ответ 2
    private final By calculationRentalTimeAnswer = By.xpath(".//div[@id='accordion__panel-2']/p");
    // Можно ли заказать самокат прямо на сегодня?
    private final By orderToday = By.id("accordion__heading-3");
    // Ответ 3
    private final By orderTodayAnswer = By.xpath(".//div[@id='accordion__panel-3']/p");
    // Можно ли продлить заказ или вернуть самокат раньше?
    private final By renewalAndReturnScooter = By.id("accordion__heading-4");
    // Ответ 4
    private final By renewalAndReturnScooterAnswer = By.xpath(".//div[@id='accordion__panel-4']/p");
    // Вы привозите зарядку вместе с самокатом?
    private final By scooterBattery = By.id("accordion__heading-5");
    // Ответ 5
    private final By scooterBatteryAnswer = By.xpath(".//div[@id='accordion__panel-5']/p");
    // Можно ли отменить заказ?
    private final By cancelOrder = By.id("accordion__heading-6");
    // Ответ 6
    private final By cancelOrderAnswer = By.xpath(".//div[@id='accordion__panel-6']/p");
    // Я жизу за МКАДом, привезёте?
    private final By liveBehindMKAD = By.id("accordion__heading-7");
    // Ответ 7
    private final By liveBehindMKADAnswer = By.xpath(".//div[@id='accordion__panel-7']/p");
    // Кнопка "Заказать" вверху страницы
    private final By upperOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    // Кнопка "Заказать" внизу страницы
    private final By lowerOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //кнопка куки
    private final By cookieButton = By.id("rcc-confirm-button");

    private final WebDriver driver;


    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPageScooter clickUpperOrderButton() {
        driver.findElement(upperOrderButton).click();
        return new OrderPageScooter(driver);
    }

    public OrderPageScooter clickLowerOrderButton() {
        WebElement element = driver.findElement(lowerOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(lowerOrderButton).click();
        return new OrderPageScooter(driver);
    }

    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    public String getHowPayAnswer() {
        driver.findElement(howPay).click();
        return driver.findElement(howPayAnswer).getText();
    }

    public String getSeveralScootersAnswer() {
        driver.findElement(severalScooters).click();
        return driver.findElement(severalScootersAnswer).getText();
    }

    public String getCalculationRentalTimeAnswer() {
        driver.findElement(calculationRentalTime).click();
        return driver.findElement(calculationRentalTimeAnswer).getText();
    }

    public String getOrderTodayAnswer() {
        driver.findElement(orderToday).click();
        return driver.findElement(orderTodayAnswer).getText();
    }

    public String getRenewalAndReturnScooterAnswer() {
        driver.findElement(renewalAndReturnScooter).click();
        return driver.findElement(renewalAndReturnScooterAnswer).getText();
    }

    public String getScooterBatteryAnswer() {
        driver.findElement(scooterBattery).click();
        return driver.findElement(scooterBatteryAnswer).getText();
    }

    public String getCancelOrderAnswer() {
        driver.findElement(cancelOrder).click();
        return driver.findElement(cancelOrderAnswer).getText();
    }

    public String getLiveBehindMKADAnswer() {
        driver.findElement(liveBehindMKAD).click();
        return driver.findElement(liveBehindMKADAnswer).getText();
    }
}


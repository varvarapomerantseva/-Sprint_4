package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class HomePageScooter {
    // Кнопка "Заказать" вверху страницы
    private final By upperOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    // Кнопка "Заказать" внизу страницы
    private final By lowerOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //кнопка куки
    private final By cookieButton = By.id("rcc-confirm-button");
    private final String FaqAnswer = ".//div[@id='accordion__panel-%s']/p";

    private final String FaqQuestion = "accordion__heading-%s";

    private final WebDriver driver;

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    public OrderPageScooter clickOrderButton(String button) {
        if (button == "upper") {
            driver.findElement(upperOrderButton).click();
            return new OrderPageScooter(driver);
        }
        if(button == "lower") {
            WebElement element = driver.findElement(lowerOrderButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            driver.findElement(lowerOrderButton).click();
            return new OrderPageScooter(driver);

        }
        return new OrderPageScooter(driver);
    }

    public String getAnswerTheQuestion(String number) {
        WebElement element = driver.findElement(By.id(String.format(FaqQuestion, number)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element); //скролл до нужного элемента
        driver.findElement(By.id(String.format(FaqQuestion, number))).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver.findElement(By.xpath(String.format(FaqAnswer, number))).getText();
    }
}
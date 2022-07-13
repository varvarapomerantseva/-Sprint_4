package pageobject;

import org.openqa.selenium.*;

public class OrderPageScooter {
    // Поле "Имя"
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");

    // Поле "Фамилия"
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");

    // Поле "Адрес"
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // Поле "Станция метро"
    private final By stationField = By.xpath(".//input[@placeholder='* Станция метро']");

    // Поле "Телефон"
    private final By numberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // Кнопка "Далее"
    private final By furtherButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");

    // Поле "Когда привезти самокат"
    private final By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    // Поле "Срок аренды"
    private final By periodField = By.xpath(".//div[@class='Dropdown-placeholder' and text()='* Срок аренды']");

    // Поле "Цвет самоката черный"
    private final By colourFieldBlack = By.id("black");

    // Поле "Цвет самоката серый"
    private final By colourFieldGrey = By.id("grey");

    // Поле "Комментарий для курьера"
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    // Кнопка "Заказать" на форме "Про аренду"
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    // Кнопка "Да" в окне "Хотите оформить заказ?"
    private final By yesButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    // Всплывающее окно "Заказ оформлен"
    private final By finalForm = By.className("Order_Modal__YZ-d3");


    private final WebDriver driver;

    //Выбор цвета самоката
    private final String xpathPeriodFieldDropDown = "//div[@class ='Dropdown-option' and text()='%s']";

    public OrderPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setSurnameField(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void setStationField(String station) {
        driver.findElement(stationField).sendKeys(station + Keys.ARROW_DOWN + Keys.ENTER);

    }

    public void setNumberField(String number) {
        driver.findElement(numberField).sendKeys(number);
    }

    public void clickFurtherButton() {
        WebElement element = driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(furtherButton).click();
    }

    public void setDateField(String date) {
        driver.findElement(dateField).sendKeys(date + Keys.ENTER);
    }

    //Метод для ввода срока аренды
    public void setPeriodField(String period) {
        driver.findElement(periodField).click();
        driver.findElement(By.xpath(String.format(xpathPeriodFieldDropDown, period))).click();
    }

    public void clickColourFieldBlack() {
        driver.findElement(colourFieldBlack).click();
    }

    public void clickColourFieldGrey() {
        driver.findElement(colourFieldGrey).click();
    }

    public void setCommentField(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    // заполнение форма "Для кого самокат"
    public void whoIsScooterForFormField(String name, String surname, String address, String station, String number) {
        setNameField(name);
        setSurnameField(surname);
        setAddressField(address);
        setStationField(station);
        setNumberField(number);
        clickFurtherButton();

    }

    // Заполнение формы "Про аренду"
    public void aboutRentalFormField(String date, String period, String comment) {
        setDateField(date);
        setPeriodField(period);
        setCommentField(comment);

    }

    // Нажатие на кнопку "Заказать" и кнопку "Да" в окне "Хотите оформить заказ?"
    public void clickOrderButtonYes() {
        driver.findElement(orderButton).click();
        driver.findElement(yesButton).click();
    }


    public String getFinalFormText() {
        return driver.findElement(finalForm).getText();
    }
}




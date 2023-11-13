package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage_1 {
    private final WebDriver driver;

    //Поле "Имя"
    private final By nameField = By.xpath(".//input[contains(@placeholder,'* Имя')]");

    //Поле "Фамилия"
    private final By surnameField = By.xpath(".//input[contains(@placeholder,'* Фамилия')]");

    //"Поле Адрес: куда привезти самокат"
    private final By addressField = By.xpath(".//input[contains(@placeholder,'* Адрес: куда привезти заказ')]");

    //Поле "Станция метро"
    private final By metroStationField = By.xpath(".//input[contains(@placeholder,'* Станция метро')]");

    //Поле "Телефон: на него позвонит курьер"
    private final By telephoneField = By.xpath(".//input[contains(@placeholder,'* Телефон: на него позвонит курьер')]");

    //Кнопка "Далее"
    private final By nextButton = By.xpath(".//button[text()='Далее']");

    public OrderPage_1(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForLoadTextWhoIsScooterFor() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[text()='Для кого самокат']")));
    }
    public void enterName(String name) {
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(name);
    }
    public void enterSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }
    public void enterAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }
    public void enterMetroStation(String metroStation) {
        driver.findElement(metroStationField).sendKeys(metroStation);
        driver.findElement(By.className("select-search__select")).click();
    }
    public void enterTelephone(String telephone) {
        driver.findElement(telephoneField).sendKeys(telephone);
    }
    public void clickOnNextButton() {
        driver.findElement(nextButton).click();
    }
    public void fillOutOrderForm_1(String name, String surname, String address, String metroStation, String telephone) {
        enterName(name);
        enterSurname(surname);
        enterAddress(address);
        enterMetroStation(metroStation);
        enterTelephone(telephone);
        clickOnNextButton();
    }
}

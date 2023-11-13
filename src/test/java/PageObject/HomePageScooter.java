package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageScooter {
    //URL сайта "Яндекс Самокат"
    private final static String URL = "https://qa-scooter.praktikum-services.ru/";

    //Кнопка "да все привыкли"
    private final static By BUTTON_COOKIES = By.id("rcc-confirm-button");
    private final WebDriver driver;

    //Кнопка "Заказать" в хедере
    private By orderButtonInHeader = By.className("Button_Button__ra12g");

    //Кнопка "Заказать" в середине страницы
    private By orderButtonInMiddle = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    //Логотип "Самокат" в хедере
    private By logoScooter = By.xpath(".//img[@src='/assets/scooter.svg']");

    //Логотоп "Яндекс" в хедере
    private By logoYandex = By.xpath(".//img[@src='/assets/ya.svg']");


    //URL главной страницы Яндекса
    private final static String YANDEX_MAIN_PAGE_URL = "https://dzen.ru/?yredirect=true";

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(URL);
    }
    public void clickOnButtonCookies() {
        driver.findElement(BUTTON_COOKIES).click();
    }
    public void scrollToFaq(By accordingHeading) {
        WebElement element = driver.findElement(accordingHeading);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void clickAccordingHeading(By accordingHeading){
        driver.findElement(accordingHeading).click();
    }
    public void clickOnOrderButtonInHeader(){
        driver.findElement(orderButtonInHeader).click();
    }
    public void scrollToOrderButtonInMiddle() {
        WebElement element = driver.findElement(orderButtonInMiddle);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void clickOnOrderButtonInMiddle(){
        driver.findElement(orderButtonInMiddle).click();
    }
    public void clickOnLogoScooter(){
        driver.findElement(logoScooter).click();
    }
    public void clickOnLogoYandex(){
        driver.findElement(logoYandex).click();
    }


    public void waitForLoadMainPage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.urlToBe(URL));
    }
    public void checkTransitionToMainPage() {
        Assert.assertEquals(URL, driver.getCurrentUrl());
    }

    public void waitForLoadYandexMainPage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.urlToBe(YANDEX_MAIN_PAGE_URL));
    }
    public void checkTransitionToYandexMainPage() {
        Assert.assertEquals(YANDEX_MAIN_PAGE_URL, driver.getCurrentUrl());
    }

}

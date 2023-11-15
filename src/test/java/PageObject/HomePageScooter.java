package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class HomePageScooter {

    //URL сайта "Яндекс Самокат"
    private final static String URL = "https://qa-scooter.praktikum-services.ru/";

    //Кнопка "да все привыкли"
    private final static By BUTTON_COOKIES = By.id("rcc-confirm-button");
    private final WebDriver driver;

    //Локатор элементов FAQ
    private String accordingHeading = ".//div[@id='accordion__heading-%s']";

    //Локатор раскрывающихся элементов FAQ
    private String accordionPanel = ".//div[@id='accordion__panel-%s']";

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
    public void scrollToFaq(String sv) {
        WebElement element = driver.findElement(By.xpath(String.format(accordingHeading, sv)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void clickAccordingHeading(String sv){
        driver.findElement(By.xpath(String.format(accordingHeading, sv))).click();
    }
    public void waitForLoadAccordingPanel(String sv) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(accordionPanel, sv))));
    }
    public String actual(String sv){
        return driver.findElement(By.xpath(String.format(accordionPanel, sv))).getText();
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

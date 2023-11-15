package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAboutRent {
    private WebDriver driver;

    //Текст "Про аренду"
    private By textAboutRent = By.xpath(".//div[text()='Про аренду']");

    //Поле "Когда привезти самокат"
    private By whenToBringScooterField = By.xpath(".//input[contains(@placeholder,'* Когда привезти самокат')]");

    //Поле "Срок аренды"
    private By rentalPeriodField = By.className("Dropdown-arrow");

    //Элемент "сутки" в выпадающем списке поле Срок аренды
    private By dayInDropdownOption = By.xpath(".//div[text()='сутки']");

    //Чек-бокс "чёрная безысходность"
    private By checkBoxBlackPearl = By.xpath(".//input[@id='black']");

    //Кнопка "Заказать"
    private By orderButtonInFormAboutRent = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    public PageAboutRent(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForLoadTextAboutRent() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(textAboutRent));
    }
    public void enterWhenToBringScooter(String whenToBringScooter) {
        driver.findElement(whenToBringScooterField).sendKeys(whenToBringScooter);
    }
    public void chooseRentalPeriod() {
        driver.findElement(rentalPeriodField).click();
        driver.findElement(dayInDropdownOption).click();
    }
    public void chooseColorOfScooter() {
        driver.findElement(checkBoxBlackPearl).click();
    }
    public void clickOnOrderButtonInFormAboutRent() {
        driver.findElement(orderButtonInFormAboutRent).click();
    }
    public void fillOutOrderFormAboutRent(String whenToBringScooter) {
        enterWhenToBringScooter(whenToBringScooter);
        chooseRentalPeriod();
        chooseColorOfScooter();
        clickOnOrderButtonInFormAboutRent();
    }
}


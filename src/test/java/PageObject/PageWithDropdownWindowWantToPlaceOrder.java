package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageWithDropdownWindowWantToPlaceOrder {
    private WebDriver driver;

    //Текст "Хотите оформить заказ?"
    private By textWantToPlaceOrder = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    //Кнопка "Да"
    private By buttonYes = By.xpath(".//button[text()='Да']");
    public PageWithDropdownWindowWantToPlaceOrder(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForLoadTextWantToPlaceOrder() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(textWantToPlaceOrder));
    }
    public void clickOnButtonYes() {
        driver.findElement(buttonYes).click();
    }
}

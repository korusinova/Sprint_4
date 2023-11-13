package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderProcessedDropdownWindow {
    private WebDriver driver;

    //Текст "Заказ оформлен"
    private By textOrderProcessed = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");
    public OrderProcessedDropdownWindow(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForLoadDropdownWindowOrderProcessed() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(textOrderProcessed));
    }
    public void checkTextOrderProcessed() {
        Assert.assertTrue("Текст (Заказ оформлен) не появился", driver.findElements(textOrderProcessed).size()>0);
    }
}

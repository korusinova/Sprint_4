import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OrderAScooter {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @Test
    public void successfulScooterOrderWithOrderButtonInHeader() {

        PageObject.HomePageScooter objHomePage = new PageObject.HomePageScooter(driver);
        objHomePage.open();
        objHomePage.clickOnButtonCookies();
        objHomePage.clickOnOrderButtonInHeader();

        PageObject.OrderPage_1 objOrderPage_1 = new PageObject.OrderPage_1(driver);
        objOrderPage_1.waitForLoadTextWhoIsScooterFor();
        objOrderPage_1.fillOutOrderForm_1("Лев", "Накаряков", "9-я Подлесная, 9", "Чистые пруды", "89199199191");

        PageObject.OrderPage_2 objOrderPage_2 = new PageObject.OrderPage_2(driver);
        objOrderPage_2.waitForLoadTextAboutRent();
        objOrderPage_2.fillOutOrderForm_2("21.11.2023");

        PageObject.PageWithDropdownWindowWantToPlaceOrder objPageWithDropdownWindow = new PageObject.PageWithDropdownWindowWantToPlaceOrder(driver);
        objPageWithDropdownWindow.waitForLoadTextWantToPlaceOrder();
        objPageWithDropdownWindow.clickOnButtonYes();

        PageObject.OrderProcessedDropdownWindow objOrderProcessed = new PageObject.OrderProcessedDropdownWindow(driver);
        objOrderProcessed.waitForLoadDropdownWindowOrderProcessed();
        objOrderProcessed.checkTextOrderProcessed();
    }

    @Test
    public void successfulScooterOrderWithOrderButtonInMiddle() {

        PageObject.HomePageScooter objHomePage = new PageObject.HomePageScooter(driver);
        objHomePage.open();
        objHomePage.clickOnButtonCookies();
        objHomePage.scrollToOrderButtonInMiddle();
        objHomePage.clickOnOrderButtonInMiddle();

        PageObject.OrderPage_1 objOrderPage_1 = new PageObject.OrderPage_1(driver);
        objOrderPage_1.waitForLoadTextWhoIsScooterFor();
        objOrderPage_1.fillOutOrderForm_1("Евгения", "Петрова", "Красная, 5", "Сокольники", "+79129129129");

        PageObject.OrderPage_2 objOrderPage_2 = new PageObject.OrderPage_2(driver);
        objOrderPage_2.waitForLoadTextAboutRent();
        objOrderPage_2.fillOutOrderForm_2("01.12.2023");

        PageObject.PageWithDropdownWindowWantToPlaceOrder objPageWithDropdownWindow = new PageObject.PageWithDropdownWindowWantToPlaceOrder(driver);
        objPageWithDropdownWindow.waitForLoadTextWantToPlaceOrder();
        objPageWithDropdownWindow.clickOnButtonYes();

        PageObject.OrderProcessedDropdownWindow objOrderProcessed = new PageObject.OrderProcessedDropdownWindow(driver);
        objOrderProcessed.waitForLoadDropdownWindowOrderProcessed();
        objOrderProcessed.checkTextOrderProcessed();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

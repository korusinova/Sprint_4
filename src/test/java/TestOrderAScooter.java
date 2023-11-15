import PageObject.PageWhoIsScooterFor;
import PageObject.PageAboutRent;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestOrderAScooter {
    private WebDriver driver;

    @Before
    public void setUp() {
        switch (System.getProperty("browser")) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
                driver = new FirefoxDriver(options);
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions ChOptions = new ChromeOptions();
                ChOptions.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
                driver = new ChromeDriver(ChOptions);
        }
    }
    @Test
    public void successfulScooterOrderWithOrderButtonInHeader() {

        PageObject.HomePageScooter objHomePage = new PageObject.HomePageScooter(driver);
        objHomePage.open();
        objHomePage.clickOnButtonCookies();
        objHomePage.clickOnOrderButtonInHeader();

        PageWhoIsScooterFor objPageWhoIsScooterFor = new PageWhoIsScooterFor(driver);
        objPageWhoIsScooterFor.waitForLoadTextWhoIsScooterFor();
        objPageWhoIsScooterFor.fillOutOrderFormWhoIsScooterFor("Лев", "Накаряков", "9-я Подлесная, 9", "Чистые пруды", "89199199191");

        PageAboutRent objPageAboutRent = new PageAboutRent(driver);
        objPageAboutRent.waitForLoadTextAboutRent();
        objPageAboutRent.fillOutOrderFormAboutRent("21.11.2023");

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

        PageWhoIsScooterFor objPageWhoIsScooterFor = new PageWhoIsScooterFor(driver);
        objPageWhoIsScooterFor.waitForLoadTextWhoIsScooterFor();
        objPageWhoIsScooterFor.fillOutOrderFormWhoIsScooterFor("Евгения", "Петрова", "Красная, 5", "Сокольники", "+79129129129");

        PageAboutRent objPageAboutRent = new PageAboutRent(driver);
        objPageAboutRent.waitForLoadTextAboutRent();
        objPageAboutRent.fillOutOrderFormAboutRent("01.12.2023");

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

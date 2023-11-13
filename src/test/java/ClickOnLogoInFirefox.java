import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class ClickOnLogoInFirefox {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new FirefoxDriver(options);
    }

    @Test
    public void IfClickOnScooterLogoOpenMainPage(){
        PageObject.HomePageScooter objHomePage = new PageObject.HomePageScooter(driver);
        objHomePage.open();
        objHomePage.clickOnButtonCookies();
        objHomePage.clickOnLogoScooter();
        objHomePage.waitForLoadMainPage();
        objHomePage.checkTransitionToMainPage();
    }

    @Test
    public void IfClickOnYandexLogoOpenYandexMainPage(){
        PageObject.HomePageScooter objHomePage = new PageObject.HomePageScooter(driver);
        objHomePage.open();
        objHomePage.clickOnButtonCookies();
        objHomePage.clickOnLogoYandex();
        objHomePage.waitForLoadYandexMainPage();
        objHomePage.checkTransitionToYandexMainPage();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ClickOnLogo {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
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

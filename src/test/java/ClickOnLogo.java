import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class ClickOnLogo {
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
                ChromeOptions chOptions = new ChromeOptions();
                chOptions.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
                driver = new ChromeDriver(chOptions);
        }
    }

    @Test
    public void ifClickOnScooterLogoOpenMainPage(){
        PageObject.HomePageScooter objHomePage = new PageObject.HomePageScooter(driver);
        objHomePage.open();
        objHomePage.clickOnButtonCookies();
        objHomePage.clickOnLogoScooter();
        objHomePage.waitForLoadMainPage();
        objHomePage.checkTransitionToMainPage();
    }

    @Test
    public void ifClickOnYandexLogoOpenYandexMainPage(){
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

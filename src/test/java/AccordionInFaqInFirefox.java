import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccordionInFaqInFirefox {
    private final By accordingHeading;
    private final By accordionPanel;
    private final String expected;
    private WebDriver driver;


    public AccordionInFaqInFirefox(By accordingHeading, By accordionPanel, String expected) {
        this.accordingHeading = accordingHeading;
        this.accordionPanel = accordionPanel;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][]{
                {By.id("accordion__heading-0"), By.id("accordion__panel-0"), "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {By.id("accordion__heading-1"), By.id("accordion__panel-1"), "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."}
        };
    }

    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new FirefoxDriver(options);
    }

    @Test
    public void whenClickOnArrowOpenCorrespondingText() {

        PageObject.HomePageScooter objHomePage = new PageObject.HomePageScooter(driver);
        objHomePage.open();
        objHomePage.scrollToFaq(accordingHeading);
        objHomePage.clickAccordingHeading(accordingHeading);
        assertEquals(expected, driver.findElement(accordionPanel).getText());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

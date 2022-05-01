import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void startUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications","--disable-blink-features=AutomationControlled");

       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver(options);
       driver.get("https://www.lcwaikiki.com/");

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
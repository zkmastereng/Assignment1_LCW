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
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-notifications");


        String path = System.getProperties().get("user.dir").toString();
        System.setProperty("webdriver.gecko.driver", path + "/src/main/resources/geckodriver.exe");

        driver = new FirefoxDriver(options);

        driver.get("https://www.lcwaikiki.com/");

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}

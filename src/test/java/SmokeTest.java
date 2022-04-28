import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SmokeTest extends BaseTest{




    @Test
    public void goToLcwHomePage() {


        WebElement logo = new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver-> driver.findElement(By.cssSelector(".main-header-logo")));
        Boolean logoVisibility = logo.isDisplayed();

        Assert.assertTrue(logoVisibility);
    }
    @Test
    public void login() {

        WebElement login = new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver -> driver.findElement(By.cssSelector(".header-dropdown-toggle")));
        login.click();
        /*WebElement phone = driver.findElement(By.cssSelector(".login-form__radio-buttons--second-label"));
        phone.click(); */
        WebElement email = new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver-> driver.findElement(By.cssSelector(".text-input[name='email']")));

        email.sendKeys("email@email.com");


        WebElement password = new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver-> driver.findElement(By.cssSelector(".text-input[name='password']")));
        password.sendKeys("password");

        WebElement submitButton = new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver ->driver.findElement(By.cssSelector(".login-form__button[type='submit']")));
        submitButton.click();


        WebElement errorMessage = new WebDriverWait(driver,Duration.ofSeconds(10)).until(driver -> driver.findElement(By.cssSelector(".login-form__header-errors--p")));
        String message = errorMessage.getText();
        System.out.println(message);




    }
}

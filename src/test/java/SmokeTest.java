import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SmokeTest extends BaseTest{

    @Test
    public void goToLcwHomePage() {


        WebElement logo = new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver-> driver.findElement(By.cssSelector(".header-dropdown-toggle")));
        boolean logoVisibility = logo.isDisplayed();

        Assert.assertTrue(logoVisibility);
    }

    @Test
    public void signUp () throws InterruptedException {
        WebElement login = new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver -> driver.findElement(By.cssSelector(".header-dropdown-toggle")));
        Actions action = new Actions(driver);
        action.moveToElement(login).perform();
        action.pause(Duration.ofSeconds(2));
        WebElement signUpButton = new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> driver.findElement(By.cssSelector(".cart-action__btn[href='https://www.lcwaikiki.com/tr-TR/TR/uye-ol']")));
        action.moveToElement(signUpButton).click().perform();


        WebElement email = new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver-> driver.findElement(By.cssSelector(".TLeaf-Mask[data-tracking-label='YeniUyeEmail']")));
        email.sendKeys("email    ");

        WebElement password = new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver-> driver.findElement(By.cssSelector(".TLeaf-Mask[data-tracking-label='YeniUyeSifre']")));
        password.sendKeys("password", Keys.TAB);


        WebElement err1 = new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver -> driver.findElement(By.cssSelector("#RegisterFormView_RegisterEmail-error")));
        WebElement err2 = new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver -> driver.findElement(By.cssSelector("#RegisterFormView_Password-error")));
        Assert.assertTrue(err1.isDisplayed()&&err2.isDisplayed());
        System.out.println(err1.getText() + "\n" + err2.getText());






    }
}
package stepDefinations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
    public static WebDriver driver;


    public static void clear(int time,WebElement element )
    {
        WebDriverWait wait=new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
    }
    public static void click(int time,WebElement element )
    {
        WebDriverWait wait=new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

    public static void sendKeys(int time, WebElement element , String string  )
    {
        WebDriverWait wait=new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(string);
    }

    public  static String GenerateMobileno() {
        String Mobileno = RandomStringUtils.randomNumeric(10);
        return Mobileno;

    }

    public static String generateEmail() {
        RandomStringUtils rm = new RandomStringUtils();
        String email = rm.randomAlphabetic(5) + "@gmail.com";
        return email;
    }

    public static String GeneratePassword() {
        String password = RandomStringUtils.randomAlphanumeric(8);
        return password;
    }
    public static void dropDown(WebElement element , String value) {
        Select se=new Select(element);
        se.selectByVisibleText(value);
    }

}

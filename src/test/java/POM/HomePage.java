package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public static WebDriver driver ;
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    @CacheLookup
    private WebElement logout ;

    @FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
    @CacheLookup
    private WebElement customersFirst ;

    @FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
    @CacheLookup
    private WebElement customersSecond ;

    public WebElement getCustomersFirst() {
        return customersFirst;
    }

    public WebElement getCustomersSecond() {
        return customersSecond;
    }

    public WebElement getLogout() {
        return logout;
    }
}

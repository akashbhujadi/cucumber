package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

   public static WebDriver driver ;
   public LoginPage(WebDriver driver)
   {
       this.driver=driver;
       PageFactory.initElements(driver,this);
   }

   @FindBy (xpath = "//input[@id='Email']")
    @CacheLookup
    private WebElement email ;

    @FindBy (xpath = "//input[@id='Password']")
    @CacheLookup
    private WebElement password ;

    @FindBy (xpath = "//button[normalize-space()='Log in']")
    @CacheLookup
    private WebElement login ;


    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLogin() {
        return login;
    }


}

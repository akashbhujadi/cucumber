package stepDefinations;

import POM.Customers;
import POM.HomePage;
import POM.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class Steps extends BaseClass{
    public static Logger log;

    public LoginPage lp;
    public HomePage hp;
    public Customers custo;
    public Properties pro;
    public String url;
    public String userName;
    public String password;

    @Before
    public void setup() throws IOException {
    File src=new File("./Config.properties");
    FileInputStream fis =new FileInputStream(src);
    pro=new Properties();
    pro.load(fis);
    String browser=pro.getProperty("browser");
     url=pro.getProperty("url");
     userName=pro.getProperty("userName");
     password=pro.getProperty("password");
    switch(browser.toLowerCase())
    {
        case "chrome" :
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            break;

        case "firefox" :
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
            break;

        case "edge" :
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
            break;
        default:
            System.out.println("Enter z Browser name from chrome , edge , firefox only");
    }
    driver.manage().window().maximize();
    log=Logger.getLogger("cucumber");
    DOMConfigurator.configure("log4j.xml");
    //PropertyConfigurator.configure("log4j.properties");
}
    @Given("launch browser")
    public void launch_browser() {

        lp=new LoginPage(driver);
        hp=new HomePage(driver);
        custo=new Customers(driver);
        log.info("browser is launched");
    }
    @When("launch url")
    public void launch_url() {
        driver.get(url);
        log.info("url is launched");

    }
    @Then("enter email")
    public void enter_email() {
        clear(2,lp.getEmail());
        sendKeys(5,lp.getEmail(),userName);
        log.info("email is entered");
    }
    @Then("enter password")
    public void enter_password( ) {
        clear(2,lp.getPassword());
        sendKeys(5,lp.getPassword(),password);
        log.info("password is entered");
    }
    @Then("enter email {string}")
    public void enter_email(String string) {
        clear(2,lp.getEmail());
        sendKeys(5,lp.getEmail(),string);
    }

    @Then("enter password {string}")
    public void enter_password(String string) {
        clear(2,lp.getPassword());
        sendKeys(5,lp.getPassword(),string);

    }
    @Then("click login")
    public void click_login() {
       click(5,lp.getLogin());
        log.info("login button clicked");

    }
    @Then("check home page title {string}")
    public void check_home_page_title(String string) {
        Assert.assertEquals(string,driver.getTitle());
        log.info("home page title checked");

    }
    @Then("click logout")
    public void click_logout() {
        click(10,hp.getLogout());
        log.info("logout button clicked");

    }
    @Then("check login page title {string}")
    public void check_login_page_title(String string) {
        Assert.assertEquals(string,driver.getTitle());
        log.info("login page title checked");

    }
    @Then("close browser")
    public void close_browser() {
        driver.close();
        log.info("browser closed");

    }

    @Then("check login successful or not")
    public void check_login_successful_or_not() {
       if (driver.getPageSource().contains("Dashboard / nopCommerce administration"))
       {
           System.out.println("login successful");
       }
       else if (driver.getPageSource().contains("The credentials provided are incorrect"))
       {
           System.out.println("incorrect password");
       }
       else if (driver.getPageSource().contains("No customer account found"))
       {
           System.out.println("incorrect email");
       }
    }



    /**
     *   add new customer
     */

    @Then("click customers")
    public void click_customers() {
        click(3,hp.getCustomersFirst());

    }
    @Then("click customers second one")
    public void click_customers_second_one() {
        click(3,hp.getCustomersSecond());

    }
    @Then("click add new customer")
    public void click_add_new_customer() {
        click(3,custo.getAddNewCustomer());

    }
    @Then("fill info")
    public void fill_info() {
        sendKeys(5,custo.getEmail(),generateEmail());
        sendKeys(5,custo.getPassword(),GeneratePassword());
        sendKeys(4,custo.getFirstname(),"akash");
        sendKeys(3,custo.getLastname(),"babaji");
        click(3,custo.getMale());
        sendKeys(5,custo.getDob(),"1/1/2000");
        sendKeys(3,custo.getCompanyName(),"chorbazar");
        click(3,custo.getTaxExempt());
        click(3,custo.getNewsletterClick());
        click(3,custo.getNewsletter());
        click(5,custo.getCustomerRoleClear());
        click(3,custo.getCustomerRoleClick());
        click(5,custo.getCustomerRole());
        dropDown(custo.getVendor(),"Vendor 1");
        sendKeys(3,custo.getAdminCommit(),"ky bolnr atta");
        click(3,custo.getSave());



    }
    @Then("seesucess alert is present or not")
    public void seesucess_alert_is_present_or_not() {

        Assert.assertTrue(custo.getSuccess().isDisplayed());

    }
}

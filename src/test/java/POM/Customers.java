package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customers {
    public static WebDriver driver ;
    public Customers(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[normalize-space()='Add new']")
    @CacheLookup
    private WebElement addNewCustomer ;

    @FindBy(xpath = "//input[@id='Email']")
    @CacheLookup
    private WebElement email ;

    @FindBy(xpath = "//input[@id='Password']")
    @CacheLookup
    private WebElement password ;

    @FindBy(xpath = "//input[@id='FirstName']")
    @CacheLookup
    private WebElement firstname ;
    @FindBy(xpath = "//input[@id='LastName']")
    @CacheLookup
    private WebElement lastname ;

    @FindBy(xpath = "//input[@id='Gender_Male']")
    @CacheLookup
    private WebElement male ;

    @FindBy(xpath = "//input[@id='Gender_Female']")
    @CacheLookup
    private WebElement female ;

    @FindBy(xpath = "//input[@id='DateOfBirth']")
    @CacheLookup
    private WebElement dob ;

    @FindBy(xpath = "//input[@id='Company']")
    @CacheLookup
    private WebElement companyName ;

    @FindBy(xpath = "//input[@id='IsTaxExempt']")
    @CacheLookup
    private WebElement taxExempt ;

    @FindBy(xpath = "//div[@class='input-group-append']//div[@role='listbox']")
    @CacheLookup
    private WebElement newsletterClick ;

    @FindBy(xpath = "//li[normalize-space()='Test store 2']")
    @CacheLookup
    private WebElement newsletter ;

    @FindBy(xpath = "//div[@class='input-group-append input-group-required']//div[@role='listbox']")
    @CacheLookup
    private WebElement customerRoleClick ;
    @FindBy(xpath = "//span[@title='delete']")
    @CacheLookup
    private WebElement customerRoleClear ;

    @FindBy(xpath = "//li[contains(text(),'Vendors')]")
    @CacheLookup
    private WebElement customerRole ;

    public WebElement getNewsletterClick() {
        return newsletterClick;
    }

    public WebElement getCustomerRoleClear() {
        return customerRoleClear;
    }

    public WebElement getCustomerRoleClick() {
        return customerRoleClick;
    }



    public WebElement getAddNewCustomer() {
        return addNewCustomer;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getFirstname() {
        return firstname;
    }

    public WebElement getLastname() {
        return lastname;
    }

    public WebElement getMale() {
        return male;
    }

    public WebElement getFemale() {
        return female;
    }

    public WebElement getDob() {
        return dob;
    }

    public WebElement getCompanyName() {
        return companyName;
    }

    public WebElement getTaxExempt() {
        return taxExempt;
    }

    public WebElement getNewsletter() {
        return newsletter;
    }

    public WebElement getCustomerRole() {
        return customerRole;
    }

    public WebElement getVendor() {
        return vendor;
    }

    public WebElement getAdminCommit() {
        return adminCommit;
    }

    public WebElement getSave() {
        return save;
    }

    public WebElement getSuccess() {
        return success;
    }

    @FindBy(xpath = "//select[@id='VendorId']")
    @CacheLookup
    private WebElement vendor ;

    @FindBy(xpath = "//textarea[@id='AdminComment']")
    @CacheLookup
    private WebElement adminCommit ;

    @FindBy(xpath = "//button[@name='save']")
    @CacheLookup
    private WebElement save ;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
    @CacheLookup
    private WebElement success ;








}

package Objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class ContactUsPageSearch {
	
	WebDriver driver;
    SoftAssert softAssert;
    String expectedErrorMsgText = null;

    public ContactUsPageSearch(WebDriver driver) {
        this.driver = driver;
        this.softAssert = new SoftAssert();
    }
    
    //Marketing contact us botton Locator  
   // By contactUsLoc = By.xpath("//div[contains(text(),'Marketing')]/following-sibling::div/button");
    By contactUsLoc = By.xpath("(//button[contains(text(),'Contact')])[1]");
    
    //Full Name Locator
    By fullNameLoc = By.xpath("(//input[@name='fullName'])[1]");
    
    //Org Name Locator
    By OrgNameLoc = By.xpath("(//input[@name='organisationName'])[1]");
    
    //Phone Locator
    By phoneNoLoc = By.xpath("(//input[@name='cellPhone'])[1]");
    
    //Email Locator
    By emailLoc = By.xpath("(//input[@name='email'])[1]");
    
    //job Role Locator
    By jobRoleLoc = By.xpath("(//select[@name='jobRole'])[1]");
    
    //Radio Button Locator
    By radioButtonLoc = By.xpath("(//input[@name='consentAgreed'])[1]");
    
    //Submit button Locator
    By sublitButtonLoc = By.xpath("(//button[@name='form_page_submit'])[1]");
    
    //error msg Locator
    By errorMsgLoc = By.xpath("//div[@class='ff-form-errors']/p");
    
 // Contact Us Xpath
    By contactUsText = By.xpath("//a[contains(text(),'Contact Us')]");
    
    
    
    public void marketingMessageVerify() {
    	
    	try {
            driver.findElement(contactUsText).click();

            // wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            WebElement contactUsButton = wait.until(ExpectedConditions.elementToBeClickable(contactUsLoc));
            contactUsButton.click();

            // Wait for 'Contact Us' page to be visible
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(fullNameLoc)));

            // Fill the 'Contact Us' form
            driver.findElement(fullNameLoc).sendKeys("Ritesh Kumar");
            driver.findElement(OrgNameLoc).sendKeys("xyz pvt ltd");
            driver.findElement(phoneNoLoc).sendKeys("1234567890");
            driver.findElement(emailLoc).sendKeys("ritesh.kumar@gmail.com");

            Select select = new Select(driver.findElement(jobRoleLoc));
            select.selectByValue("Other");

            // Element View to perform click
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement radioButton = driver.findElement(radioButtonLoc);
            js.executeScript("arguments[0].scrollIntoView();", radioButton);

         // Click the radio button using JavaScript
            js.executeScript("arguments[0].click();", radioButton);
            
            driver.findElement(sublitButtonLoc).submit();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(errorMsgLoc)));

            expectedErrorMsgText = driver.findElement(errorMsgLoc).getText();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception occurred: " + e.getMessage());
        }

    	
    	// Verifying error msg
    	softAssert.assertEquals(expectedErrorMsgText, "Sorry, there was an error submitting the form. Please try again.", "Verification Fail");
    	softAssert.assertAll();
    }
}

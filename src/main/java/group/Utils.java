package group;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utils extends BasePage {

    public void ToLaunchChromeBrowser(){
        System.setProperty("webdriver.chrome.driver","src\\main\\Resources\\Browserdriver\\chromedriver.exe");

        //To open Browser
        driver=new ChromeDriver();
        //To maximise the Browser screen
        driver.manage().window().fullscreen();
        // To set the implicity wait for the driver object
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);}

      //Method to Quit
        public  void closebrowser(){
        driver.quit();
        }
    //Method for send Keys
    public void EnterText(By locator, CharSequence text) {
        driver.findElement(locator).sendKeys(text);
    }

    //Method for instructing Browser to click a Element
    public void ClickonElement(By by) {
        driver.findElement(by).click();
    }

    //Method for getting text
    public String ExtractText(By by) {
        return driver.findElement(by).getText();
    }
     //Method for Explicit wait
    public  void WaitForClickable(By by, long time) {
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        }
    //Method for instructing until the element to be visible(Explicit Wait)
    public  void WaitForElementVisible(By by,long time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    //Method for driver to wait for Alert(Explicit wait method)
    public  void WaitforAlertPresent(long time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.alertIsPresent());
    }
    //Method for random Date,Month And year
    public  String randomDate(){
        DateFormat format = new SimpleDateFormat("ddyyHHmmss");
        return format.format(new Date());
    }
    // Method to generate Email
    public String GenerateEmail(String startValue) {
        String email = startValue.concat(new Date().toString());
        return email;
    }

    //To clear
    public  void clearLocator(By by)
    { driver.findElement(by).clear();
    }
        //Method to clear
    public void clearandEnteranElement(By by,String text){
            driver.findElement(by).clear();
            driver.findElement(by).sendKeys(text);
        }
        // Method to select by value from dropdown
        public void selectByValue(By by, String value){
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);

        }
        //Method
        public void selectbyVisibleText(By by, String text){
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
        }
        //Method to select Index from dropdown
         public void selectByIndexNumber(By by, int n){
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(n);
         }
     //Method to get Attribute
    public String getattribute(By by, String text) {
        return driver.findElement(by).getAttribute(text);
    }

    //Method for checking Webelement is Displayed or not
    public static void WebelementTobeDisplayed(By by) {
        if (driver.findElement(by).isDisplayed()) {
            System.out.println("Element is displayed");
        } else {
            System.out.println("Element is not displayed");
        }
    }
        //Method for checking web element is present or not in DOM
        public void checkingifwebelementisPresentinDOM(By by){
            if (driver.findElement(by)!=null){
                System.out.println("Element is Present");}
            else{
                System.out.println("Element is Absent");
            }
            }
            //Method for Explicit wait to be Invisible
     public void InvisibleTextforExpilicitWait(By by, long time){
         WebDriverWait wait = new WebDriverWait(driver,time);
         wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
     }
          //Method for Invisible Text for WebElement
    public void WaitForElementTObeInvisibleText(By by, long time, String text){
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(by,text));
    }
    //Scroll to View Element
    public void ScrolltoviewElement(By by ){
        Actions actions = new Actions(driver);
        actions.moveToElement((WebElement) by);
    }
    //Scroll to view Element & Click
    public void ScrolltoviewElementAndClick(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement((WebElement) by).click();
    }
    //Method for CSSValue
    public void getcssvalue(By by, String text){
        driver.findElement(by).getCssValue(text);
    }
    //Method for Date Stamp Short
    public  String randomDateSort(){
        DateFormat format = new SimpleDateFormat("ddMMyy");
        return format.format(new Date());}

    }











package group;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NopCommerceRegistration extends Utils {
    LoadProps loadprop = new LoadProps();

    @BeforeMethod
    //Method to launch browser
    public void setUp() {
        ToLaunchChromeBrowser();
        //To open the website
        driver.get(loadprop.getProperty("url"));

    }

    @AfterMethod
    //Method to Quit the Browser
    public void quitbrowser() {
       closebrowser();
    }


@Test(priority=0)
    public void UsershouldbeAbleToDoRegistrationSuccessfully() {
    ClickonElement(By.xpath("//a[@class='ico-register']"));
    //Enter First Name
    EnterText(By.id("FirstName"), loadprop.getProperty("FirstName"));
    //Enter Last Name
    EnterText(By.xpath("//input[@name='LastName']"), loadprop.getProperty("LastName"));
    //Enter Date of BirthDay
    selectByValue(By.xpath("//select[@name=\"DateOfBirthDay\"]"), "2");
    //Enter Birth Month
    selectByValue(By.xpath("//select[@name=\"DateOfBirthMonth\"]"), "8");
    //Enter Birth Year
    selectByValue(By.xpath("//select[@name=\"DateOfBirthYear\"]"), "1983");
    //Enter Email
    EnterText(By.name("Email"),("xyz" +randomDate()+"@gmail.com"));
    //Enter password
    EnterText(By.xpath("//input[@id='Password']"),loadprop.getProperty("Password"));
    //Re-enter password
    EnterText(By.xpath("//input[@id='ConfirmPassword']"),loadprop.getProperty("ConfirmPassword"));
    //Click Register
    ClickonElement(By.xpath("//input[@id='register-button']"));

    //
    String Expectedresult = "Your registration completed";
    String Actualresult = ExtractText(By.xpath("//div[@class='result']"));
    Assert.assertEquals(Actualresult, Expectedresult);

}
@Test(priority = 1)
public void UserShouldReferAproducttoFriend() {
    //click on register button
    ClickonElement(By.xpath("//a[@class='ico-register']"));
    //Enter First Name
    EnterText(By.id("FirstName"), loadprop.getProperty("FirstName"));
    //Enter Last Name
    EnterText(By.xpath("//input[@name='LastName']"), loadprop.getProperty("LastName"));
    //Enter email
    EnterText(By.name("Email"),("xyz" + randomDate() + "@gmail.com"));
    //Enter password
    EnterText(By.xpath("//input[@id='Password']"),loadprop.getProperty("Password"));
    //Re-enter password
    EnterText(By.xpath("//input[@id='ConfirmPassword']"),loadprop.getProperty("ConfirmPassword"));
    //Click Register
    ClickonElement(By.xpath("//input[@id='register-button']"));
    // click on Continue
    ClickonElement(By.name("register-continue"));
    //
    ClickonElement(By.linkText("Apple MacBook Pro 13-inch"));
    //click on Email a Friend button
    ClickonElement(By.xpath("//input[@value='Email a friend']"));
    //Enter friend's email
    EnterText(By.xpath("//input[@id='FriendEmail']"),loadprop.getProperty("FriendEmail"));
    //Enter personal message
    EnterText(By.xpath("//textarea[@name='PersonalMessage']"),loadprop.getProperty("PersonalMessage"));
    //Sending Email
    ClickonElement(By.xpath("//input[@name='send-email']"));
    //To test Expected & Actual Message
    String ExpectedMessage = "Your message has been sent.";
    String ActualMessage = ExtractText(By.xpath("//div[@class='result']"));
    Assert.assertEquals(ActualMessage, ExpectedMessage);
}

          @Test(priority = 2)
        public void UsershouldbeAbleToNavigatetoCameraandphotoPage(){
        //Click on Electronics
        ClickonElement(By.linkText("Electronics"));
        //Navigate to Camera and Photo section
        ClickonElement(By.xpath("//h2/a[@title=\"Show products in category Camera & photo\"]"));
              //To test Expected & Actual Page
              String Expectedpage = "Camera & photo";
              String Actualpage = ExtractText(By.linkText("Camera & photo"));
              Assert.assertEquals(Actualpage, Expectedpage);


    }
    @Test(priority = 3)
     public void userShouldBeAbleAddBooksToTheShoppingCart(){
        //click on Books
        ClickonElement(By.linkText("Books"));
        //Click on book name"First Prize Pies"
        ClickonElement(By.linkText("First Prize Pies"));
        // Add Book  to shopping Cart
        ClickonElement(By.xpath("//input[@id=\"add-to-cart-button-38\"]"));
        //webdriver wait
        WaitForElementVisible(By.xpath("//span [@class=\"cart-qty\" and text ()='(1)']"),10);
        //ClickonElement;
        //click on book name Fahrenheit
        ClickonElement(By.linkText("Fahrenheit 451 by Ray Bradbury"));
        //Add Book to shopping cart
       ClickonElement(By.xpath("//input[@id=\"add-to-cart-button-37\"]"));
       //Webdriver Wait
        WaitForElementVisible(By.xpath("//span [@class=\"cart-qty\" and text ()='(2)']"),10);
        //check books are in shopping cart
        ClickonElement(By.linkText("Shopping cart"));
        //To test Expected & Actual Product
        String Expectedproduct = "Shopping cart";
        String Actualproduct = ExtractText(By.linkText("Shopping cart"));
        Assert.assertEquals(Actualproduct, Expectedproduct);

    }
    @Test(priority = 4)
    public void UserShouldAbleToSelectJewlleryFromAFixedRange(){
        //click on Jewelry
        ClickonElement(By.linkText("Jewelry"));
        //Click on $700-$3000 Range
        ClickonElement(By.xpath("//a[contains(@href,\"700-3000\")]"));

        //To test the Expected & Actual Range
        String expectedrange="$700.00 - $3,000.00";
        String actualrange = ExtractText(By.xpath("//span[@class='item']"));
        Assert.assertEquals(actualrange,expectedrange);

        String startprice =ExtractText(By.xpath("//span[@class=\"PriceRange\" and text() ='$700.00']"));
        String endprice =ExtractText(By.xpath("//span[@class=\"PriceRange\" and text() ='$3,000.00']"));
        String actualprice =ExtractText(By.xpath("//span[@class=\"price actual-price\" and text() ='$2,100.00']"));

        System.out.println(startprice);
        System.out.println(endprice);
        System.out.println(actualprice);
        float sp = Float.parseFloat(startprice.substring(1));
        System.out.println(sp);
        float ep = Float.parseFloat(endprice.replace(",","").substring(1));
        System.out.println(ep);
        float ap = Float.parseFloat(actualprice.replace("," ,"").substring(1));
        System.out.println(ap);

        Assert.assertTrue(sp<=ap && ap<=ep);

    }
    }







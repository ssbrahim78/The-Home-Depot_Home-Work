package homeDepot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class HomeDepot {
    // create driver object
    public static WebDriver driver;
    public static String firefoxDriver = "webdriver.chrome.driver";
    public static String firefoxDriverPath = "BrowserDriver\\Windows\\chromedriver.exe";

    public static String url = "https://www.homedepot.com/";


    public static void main(String[] args) throws InterruptedException {

        //************test case 1:************
         //signInInvalidUser();
        //*************test case 2:***********
        // signInInvalidPassword();
        //*************test case 3:***********
        signin();
        //****************test case 4:**********
       // searchProduct();
        //****************test case 5:*********
        //searchInvalidProduct();
        //****************test case 6:*********
        //checkCardItems();
        //*****************test case 7:********
        //increaseQuantity();
        //******************test case 8:*********
        //checkOutOrder();
        //******************test case 9***********
        // creditCardApply();
        //******************test case 10***********
        //storeFinderUsingLocation();
        //******************test case 10***********
        //storeFinderUsingZipCode();
        //******************test case 11***********
       // Appliances();
        //******************test case 12***********
        ToolRental ();
    }

    public static void signin() {
        // test case 3- sign in to home depot account
        // step 1- ****Open Browser and Navigate to URL
        browseSetUp(firefoxDriver, firefoxDriverPath, url);
        // click on my account web element
        driver.findElement(By.cssSelector("#headerMyAccount > div.MyAccount__icon > div > div.HeaderIcon__primary > svg")).click();
        // step 2- enter your credentials
        //valid user name:
        driver.findElement(By.cssSelector("#SPSOSignIn > a > span")).click();
        // step 3- enter valid  email
        driver.findElement(By.cssSelector("#email")).sendKeys("ibrahimsidisaid@gmail.com");
        // valid passoword:
        driver.findElement(By.id("password-input-field")).sendKeys("java206java206");
        // step 4- click on sign in
        driver.findElement(By.cssSelector("#single-signin__body > div > div.col__12-12.col__8-12--xs.u--paddingNone-top.col__4-12--lg.col__4-12--md.col__6-12--sm > form > button > span")).click();
    }
    //test cast 1 sign in with invalid user name
    public static void signInInvalidUser() throws InterruptedException {
        // test case 1- sign in to home depot account
        // step one: ****Open Browser and Navigate to URL
        browseSetUp(firefoxDriver, firefoxDriverPath, url);
        // click on my account web element
        driver.findElement(By.cssSelector("#headerMyAccount > div.MyAccount__icon > div > div.HeaderIcon__primary > svg")).click();
        // step two: enter your credentials
        //valid user name:
        driver.findElement(By.cssSelector("#SPSOSignIn > a > span")).click();
        // step three: enter valid  email
        driver.findElement(By.cssSelector("#email")).sendKeys("fouadmsidisaid@gmail.com");
        // valid passoword:
        driver.findElement(By.id("password-input-field")).sendKeys("java206java206");
        // click on sign in
        driver.findElement(By.cssSelector("#single-signin__body > div > div.col__12-12.col__8-12--xs.u--paddingNone-top.col__4-12--lg.col__4-12--md.col__6-12--sm > form > button > span")).click();
        waitingTime( 3000);

        driver.quit();

    }
    //test case 2: sign in with invalid password
    public static void signInInvalidPassword() throws InterruptedException {
        // test case 1- sign in to home depot account
        // step one: ****Open Browser and Navigate to URL
        browseSetUp(firefoxDriver, firefoxDriverPath, url);
        // click on my account web element
        driver.findElement(By.cssSelector("#headerMyAccount > div.MyAccount__icon > div > div.HeaderIcon__primary > svg")).click();
        // step two: enter your credentials
        //valid user name:
        driver.findElement(By.cssSelector("#SPSOSignIn > a > span")).click();
        // step three: enter valid  email
        driver.findElement(By.cssSelector("#email")).sendKeys("ibrahimsidisaid@gmail.com");
        // valid passoword:
        driver.findElement(By.id("password-input-field")).sendKeys("fouad12345@#");
        // click on sign in
        driver.findElement(By.cssSelector("#single-signin__body > div > div.col__12-12.col__8-12--xs.u--paddingNone-top.col__4-12--lg.col__4-12--md.col__6-12--sm > form > button > span")).click();
        waitingTime( 3000);
        driver.quit();
    }
    public static void searchProduct() throws InterruptedException {
// 4- test case: search for in search box
//********************************** step 1 open browser and navigate to url***************************
        // Open Browser and Navigate to URL
        browseSetUp(firefoxDriver, firefoxDriverPath, url);
//****************************************<step 2- enter keyword in search box>**********************
        waitingTime( 2000);
        driver.findElement(By.xpath("//*[@id=\"headerSearch\"]")).sendKeys("paint roller");
        waitingTime( 3000);
//*******************************************<step 3- click on the search button>**********************************
        driver.findElement(By.cssSelector(".SearchBox__buttonIcon")).click();
//*******************************************<step 4- select the item>**********************************
        driver.findElement(By.cssSelector("#products > div > div.js-pod.js-pod-0.plp-pod.plp-pod--default.pod-item--0 > div > div.plp-pod__info > div.pod-plp__description.js-podclick-analytics > a")).click();
        waitingTime( 5000);
//*******************************************<step 5- click to add the item to the cart>**********************************
        driver.findElement(By.xpath("//*[@id=\"atc_pickItUp\"]/span")).click();
        waitingTime( 4000);
        driver.close();


    }
    //test case five : search invalid item
    public static void searchInvalidProduct() throws InterruptedException {
// 4- test case: search for in search box
//********************************** step 1 open browser and navigate to url***************************
        // Open Browser and Navigate to URL
        browseSetUp(firefoxDriver, firefoxDriverPath, url);
//****************************************<step 2- enter keyword in search box>**********************
        waitingTime( 2000);
        driver.findElement(By.xpath("//*[@id=\"headerSearch\"]")).sendKeys("milk ");
        waitingTime( 3000);
//*******************************************<step 3- click on the search button>**********************************
        driver.findElement(By.cssSelector(".SearchBox__buttonIcon")).click();
//*******************************************<step 4- select the item>**********************************
        driver.findElement(By.cssSelector("#products > div > div.js-pod.js-pod-0.plp-pod.plp-pod--default.pod-item--0 > div > div.plp-pod__info > div.pod-plp__description.js-podclick-analytics > a")).click();
        waitingTime( 5000);
//*******************************************<step 5- click to add the item to the cart>**********************************
        driver.findElement(By.xpath("//*[@id=\"atc_pickItUp\"]/span")).click();
        waitingTime( 5000);
        driver.close();
    }


     public static void checkCardItems() throws InterruptedException {
   // 6- test case: check card items
         // all sign in steps
        // signin();
         waitingTime(5000);
         // step 5- click on items
     driver.findElement(By.className("MyCart__itemCount__label")).click();
}

    public static void increaseQuantity() throws InterruptedException {
        // 7- test case: increase items Quantity
        // all sign in steps
        //signin();
        // all checkCardItems steps
       // checkCardItems();
        //step 6- set number 2 on Quantity items web element
     driver.findElement(By.className("cartItem__qtyInput form-input__field u__left padding_left-10 padding_right-10")).sendKeys("2");
    waitingTime(5000);}

         public static void checkOutOrder() throws InterruptedException {
             // 8- test case: check Out order
             // all sign in steps
             //signin();
             // all checkCardItems steps
             //checkCardItems();
             // step 7- click on checkout button
     driver.findElement(By.cssSelector("div.col__12-12--md:nth-child(1) > div:nth-child(5) > form:nth-child(1) > button:nth-child(1) > span:nth-child(1)")).click();

}
public static void creditCardApply() throws InterruptedException {
    // 9- test case: apply for home depot credit card
    // step 1-Open Browser and Navigate to URL
    browseSetUp(firefoxDriver, firefoxDriverPath, url);
    waitingTime(5000);
    // step 2-click on the credit services web element
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/ul/li[5]/a")).click();
    waitingTime(3000);
    // step 3 - click on the View Offers web element
    driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div[1]/div/div/div/div/ul[3]/li/a")).click();
    waitingTime(3000);
    // step 4- click on the apply now web element
    driver.findElement(By.cssSelector("#ProjectLoan > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")).click();
}
public static void storeFinderUsingLocation() throws InterruptedException {
    // 10- test case: find store location using My location option
    // step 1-Open Browser and Navigate to URL
    browseSetUp(firefoxDriver, firefoxDriverPath, url);
    waitingTime(5000);
    // step 2-click on store finder web element
    driver.findElement(By.cssSelector("li.TaskLinks__item:nth-child(1) > a:nth-child(1)")).click();
    // step 2-click on use my location button
   driver.findElement(By.cssSelector("#gpsButton > span:nth-child(1)")).click();
   String title= driver.getTitle();
    System.out.println(title);
}
    public static void storeFinderUsingZipCode() throws InterruptedException {
        // 10- test case: find store location using zip code option
        // step 1-Open Browser and Navigate to URL
        browseSetUp(firefoxDriver, firefoxDriverPath, url);
        waitingTime(5000);
        // step 2-click on store finder web element
        driver.findElement(By.cssSelector("li.TaskLinks__item:nth-child(1) > a:nth-child(1)")).click();
        // step 3- enter the zip code to the search box
        driver.findElement(By.id("storeSearchBox")).sendKeys("07306");
        waitingTime(3000);
        // step 4- click on the search button
        driver.findElement(By.cssSelector(".bttn--noShadow > span:nth-child(1) > svg:nth-child(1)")).click();
        String title = driver.getTitle();
        System.out.println(title);
        closeBrowser();

    }
    public static void Appliances() throws InterruptedException {
        // 10- test case: find store location using zip code option
        // step 1-Open Browser and Navigate to URL
        browseSetUp(firefoxDriver, firefoxDriverPath, url);
        waitingTime(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[4]/div/ul/li[1]/a")).click();
        // step 2-Open click on appliance web button
        //driver.findElement(By.className("MainFlyout__link MainFlyout__link--active")).click();
        waitingTime(2000);
        // step 2-Open click on  Refrigerators web button on appliances
        driver.findElement(By.cssSelector("div.col__12-12--xs:nth-child(1) > div:nth-child(1) > div:nth-child(1) > p:nth-child(25) > a:nth-child(1)")).click();
        closeBrowser();}

    public static void ToolRental () throws InterruptedException {
        // 11- test case: find truck and tool rental
        // step 1-Open Browser and Navigate to URL
        browseSetUp(firefoxDriver, firefoxDriverPath, url);
        waitingTime(3000);
        // step 2-click on truck and tool rental web button
       driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/ul/li[2]/a")).click();
       waitingTime(2000);
        // step 3-click on Rent Now web button
       driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div/div[1]/div[2]/div/a/span")).click();

    }

    // create method to open browser and navigate to url
    public static void browseSetUp(String browserDriver, String driverPath, String url) {

        //  connect and open browser
        System.setProperty(browserDriver, driverPath);
        driver=new ChromeDriver();
       // System.setProperty(browserDriver, driverPath);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        driver.navigate().to(url);
    }

    public static void waitingTime(int waitSeconds) throws InterruptedException {
        Thread.sleep(waitSeconds);
    }

    public static void closeBrowser() {

        driver.quit();
    }

}
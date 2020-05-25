package homeDepot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class HomeDepot {

    // create driver object
   public static WebDriver driver= new FirefoxDriver();
    public static String firefoxDriver="webdriver.gecko.driver";
   public static String firefoxDriverPath="BrowserDriver\\Windows\\geckodriver.exe";

   public static String  url = "https://www.homedepot.com/";



    public static void main(String[] args) throws InterruptedException {

// 1 test case
searchProduct();



}
public static void Login(){
    // Open Browser and Navigate to URL
    browseSetUp(firefoxDriver, firefoxDriverPath, url);


}
public static void searchProduct() throws InterruptedException {
// 1- test case: search for in search box
//********************************** step 1 open browser and navigate to url***************************
   // Open Browser and Navigate to URL
    browseSetUp(firefoxDriver, firefoxDriverPath, url);
//****************************************<step 2- enter keyword in search box>**********************
    waitingTime(5000);
 driver.findElement(By.xpath("//*[@id=\"headerSearch\"]")).sendKeys("screwdriver");
    waitingTime(5000);
//*******************************************<step 3- click on the search button>**********************************
driver.findElement(By.cssSelector(".SearchBox__buttonIcon")).click();
//*******************************************<step 4- select the item>**********************************
driver.findElement(By.cssSelector("div.js-pod:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(1) > img:nth-child(1)")).click();
    waitingTime(5000);
//*******************************************<step 5- click to add the item to the cart>**********************************
driver.findElement(By.cssSelector("div.atc-button:nth-child(2) > div:nth-child(1) > button:nth-child(1) > span:nth-child(1)")).click();

   // closeBrowser();
}

// create method to open browser and navigate to url
public static void browseSetUp(String browserDriver,String driverPath,String url){

    // connect and open browser
    System.setProperty(browserDriver,driverPath);
            System.setProperty(browserDriver, driverPath);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            //driver.get(url);
            driver.navigate().to(url);
}

public static void waitingTime(int waitSeconds) throws InterruptedException {
       Thread.sleep(waitSeconds);
}
public static void closeBrowser(){

      driver.quit();
}
}

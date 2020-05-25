package homeDepot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class PractiseClass {


    // Chrome Browser
    public static WebDriver driver = new ChromeDriver();
    public static String chromeDriver = "WebDriver.chrome.driver";
    public static String chromeDriverPath = "BrowserDriver\\Windows\\chromedriver.exe";
    public static String url = "https://www.homedepot.com/";

    // Variable for WebElements
    public static String searchField = "//*[@id=\"twotabsearchtextbox\"]";
    public static String searchProduct = "Hand Sanitizer";


    public static void main(String[] args) throws InterruptedException {
        // Relative Path: BrowserDriver\windows\chromedriver.exe
        // Absolute Path: G:\SOFTWARE ENGINEERING\PROJECTS\IdeaProjects\PNT\Learn_Automation_WeekDays_Selenium_NY_Winter2020\BrowserDriver\windows\chromedriver.exe

        // test case 1
        searchProduct();


//        driver.findElement(By.id("kjdkfjsd")).click();
//        driver.findElement(By.name("kjdkfjsd")).click();
//        driver.findElement(By.tagName("kjdkfjsd")).click();
//        driver.findElement(By.className("kjdkfjsd")).click();
//        driver.findElement(By.linkText("kjdkfjsd")).click();
//        driver.findElement(By.partialLinkText("kjdkfjsd")).click();
//        driver.findElement(By.cssSelector("kjdkfjsd")).click();
//        driver.findElement(By.xpath("kjdkfjsd")).click();


//
//        // Firefox Browser
//        String firefoxDriver="webdriver.gecko.driver";
//        String firefoxDriverPath="BrowserDriver\\windows\\geckodriver.exe";
//        System.setProperty(firefoxDriver,firefoxDriverPath);
//        WebDriver driver1= new FirefoxDriver();
//        driver1.get("https://www.amazon.com/");


    }

    /**
     * This method is for search product purpose
     * @throws InterruptedException
     */
    public static void searchProduct() throws InterruptedException {
        // Test Case: search Hand sanitizer in search box
        // Open Browser and Navigate to URL
        setUp(chromeDriver, chromeDriverPath, url);
        //  Enter Keyword in searchBox
        //driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Hand Sanitizer");
        driver.findElement(By.xpath(searchField)).sendKeys(searchProduct);
        //Thread.sleep(5000);
        // Click searchButton
        driver.findElement(By.cssSelector("#nav-search > form > div.nav-right > div > input")).click();
        //Thread.sleep(5000);
        waitFor(5000);
        // driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[4]/div[2]/div[2]/div/span/div/div/div[2]/h2/a")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Natural Concepts Hand Sanitizer Gel, 6-Pack,')]")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
        driver.findElement(By.id("hlb-ptc-btn-native")).click();
        // Wait 5 sec
        //Thread.sleep(5000);
        String title = driver.getTitle();
        System.out.println(title);
        closeBrowser();
    }

    public static void setUp(String browserDriver, String driverPath, String url) {
        System.setProperty(browserDriver, driverPath);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //driver.get(url);
        driver.navigate().to(url);
    }

    public static void waitFor(int waitSeconds) throws InterruptedException {
        Thread.sleep(5000);
    }
    public static void closeBrowser(){
        // close the running window only
        //driver.close();
        // quit all the open windows/ tabs
        driver.quit();

    }


}
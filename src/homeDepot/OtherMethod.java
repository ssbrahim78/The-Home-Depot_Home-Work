package homeDepot;

import com.google.common.annotations.VisibleForTesting;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OtherMethod {

    public static String chromeDriver = "webdriver.chrome.driver";
    public static String chromeDriverPath = "BrowserDriver\\Windows\\chromedriver.exe";

    public static WebDriver driver2 = null;

    @Test
    public void setUp() throws InterruptedException {

        System.setProperty(chromeDriver, chromeDriverPath);
        WebDriver driver = new ChromeDriver();
        String url = "https://www.homedepot.com/";

        //navigate to url
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        //searchProduct();
        //driver.close();
    }


    //@Test
    public static void searchProduct() throws InterruptedException {

        // Test Case: search Hand sanitizer in search box
        // Open Browser and Navigate to URL
        //setUp(chromeDriver, chromeDriverPath, url);

        driver2.findElement(By.xpath("//*[@id=\"headerSearch\"]")).sendKeys("screwdriver");

        //Thread.sleep(5000);
        // Click searchButton
        driver2.findElement(By.cssSelector(".SearchBox__buttonIcon")).click();
    }

    @After
    public void closeBrowser() {

        // close the running window only
        //driver.close();
        // quit all the open windows/ tabs
        driver2.quit();

    }
}




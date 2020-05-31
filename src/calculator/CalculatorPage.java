package calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class CalculatorPage {

  public static WebDriver driver;
  public static String chromeDriver="webdriver.chrome.driver";
  public static String chromeDriverPath="BrowserDriver\\Windows\\chromedriver.exe";
  public static String url="https://www.calculator.net/";


    public static void main(String[] args) throws InterruptedException {
//test case 1

        calculateAutoLoan();






    }


   public static String AutoPrice= "34000";
   static String termValue="24";
   public static String InterestRate="3.8";
    public static String DownPayment = "2500";
   public static String StateTax = "5.5";
    public static String OtherFees = "500";

public static void calculateAutoLoan() throws InterruptedException {
// test case 1- user can calculate auto loan
    //step 1- open browser and navigate url
    setUpBrowser();
    //step 2- click on Auto Loan Calculator link
    driver.findElement(By.cssSelector("#hl1 > li:nth-child(3) > a")).click();
    waitingTime(3000);
// step 3- enter the Auto Price value to the textBox
   driver.findElement(By.xpath("//*[@id=\"cloanamount\"]")).clear();
    driver.findElement(By.xpath("//*[@id=\"cloanamount\"]")).sendKeys(AutoPrice);
   waitingTime(2000);
 // step 4- enter the Loan Term value to the textBox
    driver.findElement(By.cssSelector("#cloanterm")).clear();
    driver.findElement(By.cssSelector("#cloanterm")).sendKeys(termValue);
// step 5- enter Interest Rate in the textBox
    driver.findElement(By.cssSelector("#cinterestrate")).clear();
    driver.findElement(By.cssSelector("#cinterestrate")).sendKeys(InterestRate);
// step 5- enter Down Payment value in the textBox
    driver.findElement(By.cssSelector("#cdownpayment")).clear();
    driver.findElement(By.cssSelector("#cdownpayment")).sendKeys(DownPayment);

   // step 6 - select the New Jersey stat from the select box
    driver.findElement(By.cssSelector("#calinputtable > tbody > tr:nth-child(6) > td:nth-child(2) > select")).sendKeys("New Jersey");
waitingTime(2000);
// step 7 - enter the Sales Tax stat in the text box
    driver.findElement(By.cssSelector("#csaletax")).clear();
    driver.findElement(By.cssSelector("#csaletax")).sendKeys(StateTax);
    waitingTime(2000);
    // step 8 - enter  Other Fees in the text box
    driver.findElement(By.cssSelector("#ctitlereg")).clear();
    driver.findElement(By.cssSelector("#ctitlereg")).sendKeys(OtherFees);
    waitingTime(2000);
    // step9 - click on the check box include all the fees in loan
    driver.findElement(By.cssSelector("#calinputtable > tbody > tr:nth-child(9) > td > label > span")).click();
waitingTime(2000);
// step10 - click on the calculate web button
driver.findElement(By.cssSelector("#calinputtable > tbody > tr:nth-child(10) > td > input[type=image]:nth-child(3)")).click();
// step 11- get the value of monthly payment
String monthlyPayment=driver.findElement(By.cssSelector("#content > table > tbody > tr > td:nth-child(2) > h2")).getText();

    System.out.println(monthlyPayment);
}


public static void setUpBrowser(){

    //  connect and open browser
    System.setProperty(chromeDriver, chromeDriverPath);
    driver=new ChromeDriver();
    //System.setProperty(browserDriver, driverPath);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.get(url);
    driver.navigate().to(url);

}

    public static void waitingTime( int time) throws InterruptedException {

      Thread.sleep(time);


    }

  public static void closeB(){
   driver.close();

}



}

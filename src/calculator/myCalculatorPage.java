package calculator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class myCalculatorPage {

 public static WebDriver driver;
 public static String chromDriver="webdriver.chrome.driver";
 public static String chromdriverPath="BrowserDriver\\Windows\\chromedriver.exe";
 public static String url ="https://www.calculator.net/";
 //************ connect to excel ************************
    static FileInputStream fis;
    static XSSFWorkbook workBook;
    static Sheet sheet;
//********************* declare variables to use in excel****************
    public static Cell AutoPrice;
    public static Cell termValue;
    public static Cell YourState;
    public static Cell InterstRate;
    public static Cell DownPayment;
    public static Cell StateTax;
    public static Cell OtherFees;



    public static void main(String[] args) throws InterruptedException, IOException {

        fis=new FileInputStream("MyFirstExcel.xlsx");
        workBook =new XSSFWorkbook(fis);
        sheet= workBook.getSheetAt(0);
        // get the row count
          int rowCount= sheet.getLastRowNum();

for(int i=1; i<=rowCount;i++){

    AutoPrice = sheet.getRow(i).getCell(0);
    termValue = sheet.getRow(i).getCell(1);

    InterstRate = sheet.getRow(i).getCell(2);
    DownPayment = sheet.getRow(i).getCell(3);
    YourState = sheet.getRow(i).getCell(4);
    StateTax = sheet.getRow(i).getCell(5);
    OtherFees = sheet.getRow(i).getCell(6);



    calculateAutoLoan();



}

    }
public static void calculateAutoLoan() throws InterruptedException {
   // test case 1- user can calculate auto loan
// step1- open the browser and navigate to the url
    setUpBrowser();
    waitingTime(3000);
// step2- click on the calculator auto loan
    driver.findElement(By.cssSelector("#hl1 > li:nth-child(3) > a")).click();
// step3- enter the value to Auto Price text box
    driver.findElement(By.cssSelector("#cloanamount")).clear();
    driver.findElement(By.cssSelector("#cloanamount")).sendKeys( String.valueOf(AutoPrice));

    // step4- enter the value into Loan Term text box
    driver.findElement(By.cssSelector("#cloanterm")).clear();
    driver.findElement(By.cssSelector("#cloanterm")).sendKeys(String.valueOf(termValue));
    // step5- enter the data to the Interest Rate text box
waitingTime(2000);
    driver.findElement(By.cssSelector("#cinterestrate")).clear();
    driver.findElement(By.cssSelector("#cinterestrate")).sendKeys(String.valueOf(InterstRate));
waitingTime(2000);
    // step 6- enter the value into Down Payment text box
    driver.findElement(By.cssSelector("#cdownpayment")).clear();
    driver.findElement(By.cssSelector("#cdownpayment")).sendKeys(String.valueOf(DownPayment));
    waitingTime(2000);
    // step 7- select the state
    driver.findElement(By.cssSelector("#calinputtable > tbody > tr:nth-child(6) > td:nth-child(2) > select")).sendKeys(String.valueOf(YourState));
    waitingTime(2000);
// step 8- enter the value into the Sales Tax text box
    driver.findElement(By.cssSelector("#csaletax")).clear();
    driver.findElement(By.cssSelector("#csaletax")).sendKeys(String.valueOf( StateTax ));
waitingTime(2000);
    // step 9- enter the value into the other fees text box
driver.findElement(By.cssSelector("#ctitlereg")).clear();
driver.findElement(By.cssSelector("#ctitlereg")).sendKeys(String.valueOf(OtherFees));
waitingTime(2000);
// step 10 check the web box
    driver.findElement(By.cssSelector("#calinputtable > tbody > tr:nth-child(9) > td > label > span")).click();
    waitingTime(2000);
// step 11- click on the calculate link
    driver.findElement(By.cssSelector("#calinputtable > tbody > tr:nth-child(10) > td > input[type=image]:nth-child(3)")).click();

String MonthlyPayment = driver.findElement(By.cssSelector("#content > table > tbody > tr > td:nth-child(2) > h2")).getText();

    System.out.println(YourState+"  "+MonthlyPayment);

closeBrowser();

}
    public static void setUpBrowser(){
        System.setProperty(chromDriver,chromdriverPath);
     driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       driver.get(url);


    }
public static void waitingTime(int time) throws InterruptedException {


        Thread.sleep(time);
}

public static void closeBrowser(){


        driver.quit();
}

}

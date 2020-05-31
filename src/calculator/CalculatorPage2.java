package calculator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import static calculator.CalculatorPage.AutoPrice;

public class CalculatorPage2 {

    public static WebDriver driver;
    public static String chromeDriver="webdriver.chrome.driver";
    public static String chromeDriverPath="BrowserDriver\\Windows\\chromedriver.exe";
    public static String url="https://www.calculator.net/";
   //**************** Connect to excel and read data**********************
   static FileInputStream fis;
    static FileOutputStream fos;
    static XSSFWorkbook workbook;
    static Sheet sheet;
    static Row row;
    static Cell ceel;
    // ***************declare variables to use in excel **********************************
   public static Cell AutoPrice;
   public static Cell termValue;
   public static Cell YourState;
   public static Cell InterestRate;
   public static Cell DownPayment;
   public   static Cell StateTax;
    public   static Cell OtherFees;
public static int i;
    public static void main(String[] args) throws InterruptedException, IOException {
//***************** connect to workBook excel file**************************
        fis = new FileInputStream("MyFirstExcel.xlsx");
        workbook = new XSSFWorkbook(fis);
        //sheet=workbook.getSheet("Sheet1");
        sheet = workbook.getSheetAt(0);
        // get the rowCount
        int rowCount = sheet.getLastRowNum();

        System.out.println("rows number is " + rowCount);

// for loop to get all the sheet data
        for (int i = 1; i <= rowCount; i++) {
         // read data
            AutoPrice = sheet.getRow(i).getCell(0);
            System.out.println(AutoPrice);
             termValue = sheet.getRow(i).getCell(1);
            System.out.println(termValue);
             InterestRate = sheet.getRow(i).getCell(2);
             DownPayment = sheet.getRow(i).getCell(3);
            YourState=sheet.getRow(i).getCell(4);
             StateTax = sheet.getRow(i).getCell(5);
             OtherFees = sheet.getRow(i).getCell(6);
        //********************************************************
            // test case 1
           calculateAutoLoan();

        }

    }

//    public static String AutoPrice =25000;
//    static String termValue = 24;
//    public static String InterestRate = 3.2;
//    public static String DownPayment= 4200 ;
//    public static String StateTax = 6.5;
//    public static String OtherFees = 300;

    public static void calculateAutoLoan() throws InterruptedException {
// test case 1- user can calculate auto loan
        //step 1- open browser and navigate url
        setUpBrowser();
        //step 2- click on Auto Loan Calculator link
        driver.findElement(By.cssSelector("#hl1 > li:nth-child(3) > a")).click();
        waitingTime(3000);
// step 3- enter the Auto Price value to the textBox
        driver.findElement(By.xpath("//*[@id=\"cloanamount\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"cloanamount\"]")).sendKeys( String.valueOf(AutoPrice) );
        waitingTime(2000);
        // step 4- enter the Loan Term value to the textBox
        driver.findElement(By.cssSelector("#cloanterm")).clear();
        driver.findElement(By.cssSelector("#cloanterm")).sendKeys(String.valueOf(termValue));
// step 5- enter Interest Rate in the textBox
        driver.findElement(By.cssSelector("#cinterestrate")).clear();
        driver.findElement(By.cssSelector("#cinterestrate")).sendKeys(String.valueOf(InterestRate));
// step 5- enter Down Payment value in the textBox
        driver.findElement(By.cssSelector("#cdownpayment")).clear();
        driver.findElement(By.cssSelector("#cdownpayment")).sendKeys(String.valueOf(DownPayment) );

        // step 6 - select the New Jersey stat from the select box
        driver.findElement(By.cssSelector("#calinputtable > tbody > tr:nth-child(6) > td:nth-child(2) > select")).sendKeys(String.valueOf(YourState));
        waitingTime(2000);
// step 7 - enter the Sales Tax stat in the text box
        driver.findElement(By.cssSelector("#csaletax")).clear();
        driver.findElement(By.cssSelector("#csaletax")).sendKeys(String.valueOf(StateTax) );
        waitingTime(2000);
        // step 8 - enter  Other Fees in the text box
        driver.findElement(By.cssSelector("#ctitlereg")).clear();
        driver.findElement(By.cssSelector("#ctitlereg")).sendKeys(String.valueOf(OtherFees) );
        waitingTime(2000);
        // step9 - click on the check box include all the fees in loan
        driver.findElement(By.cssSelector("#calinputtable > tbody > tr:nth-child(9) > td > label > span")).click();
        waitingTime(2000);
// step10 - click on the calculate web button
        driver.findElement(By.cssSelector("#calinputtable > tbody > tr:nth-child(10) > td > input[type=image]:nth-child(3)")).click();
// step 11- capture the value of monthly payment
        String monthlyPayment=driver.findElement(By.cssSelector("#content > table > tbody > tr > td:nth-child(2) > h2")).getText();
      // print out the result
        System.out.println(YourState+" state "+monthlyPayment);
    // write the data into Excel
   //*****************************************************************************************
//        int columnCount=0;
//        //int i=1;
//        sheet.getRow(i).createCell(7).setCellValue(monthlyPayment);
//       // Cell cell = row.createCell(7);
//       // cell.setCellValue((String) monthlyPayment);
//
//        try (FileOutputStream outputStream = new FileOutputStream("fis")) {
//            workbook.write(outputStream);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //********************************************************************************************
closeBrowser();

    }


    public static void setUpBrowser(){

        //  connect browser and navigate to url
        System.setProperty(chromeDriver, chromeDriverPath);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        //driver.navigate().to(url);

    }

    public static void waitingTime( int time) throws InterruptedException {

        Thread.sleep(time);


    }

    public static void closeBrowser(){
        driver.quit();

    }



}

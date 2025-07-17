package Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class A_Login {

    WebDriver driver ;

    By[] ArrayOfCheckboxes = {By.xpath("//input[@name = 'termsAndConditions']"),By.xpath("//input[@name = 'cancellationPolicy']"), By.xpath("//input[@name = 'responsibilityAcknowledge']"),By.xpath("//input[@name = 'waiverAgreement']")};
    int i;
    @BeforeMethod
    public void precondition() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://dayuse.kona.com.sa/booking");
   //     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
   //     JavascriptExecutor js = (JavascriptExecutor) driver;

    }

    @Test
    public void Test_One (){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='19']")));
        element1.click();

        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input [@type ='radio']")));
        element2.click();

        driver.findElement(By.xpath("//button [text()='Confirm']")).click();

        driver.findElement(By.xpath("//button [text()='+']")).click();

        driver.findElement(By.xpath("//button [text()='Next']")).click();

        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input [@id = 'first-name-input-0']")));
        element3.sendKeys("Male");

        WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input [@id = 'last-name-input-0']")));
        element4.sendKeys("One");

        WebElement element5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input [@id = 'whatsappNumber-input-0']")));
        element5.sendKeys("222");

        driver.findElement(By.xpath("//button [text()='Proceed To Payment']")).click();

        WebElement element6 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p [text()='Male One']")));
        element6.click();

        WebElement element7 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button [text()='Confirm Male As Main Guest']")));
        element7.click();


         for (i=0 ; i<4; i++){
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(ArrayOfCheckboxes[i]));
            element.click();
        }

        WebElement element8 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span [text()='Pay']")));
        element8.click();

        WebElement element9 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input [@name ='cardnumber']")));
        element9.sendKeys("4000000000000002");

        driver.findElement(By.xpath("//input [@name ='ccmonth']")).sendKeys("12");

        driver.findElement(By.xpath("//input [@name ='ccyear']")).sendKeys("28");

        driver.findElement(By.xpath("//input [@name ='cvv']")).sendKeys("123");

        driver.findElement(By.xpath("//button [@id ='payBtn']")).click();

        WebElement element10 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input [@value ='Authenticated']")));
        element10.click();

        wait.until(ExpectedConditions.urlToBe("https://dayuse.kona.com.sa/payment-success"));

        WebElement element11 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2 [text()='Booking Confirmed!']")));

        Assert.assertTrue(driver.findElement(By.xpath("//h2 [text()='Booking Confirmed!']")).isDisplayed());

/*
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(ArrayOfCheckboxes[0]));
        driver.findElement(ArrayOfCheckboxes[0]).click();
*/
    }

    @Test (enabled = true)
    public void Test_Two () throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='19']")));
        element1.click();

        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input [@type ='radio']")));
        element2.click();

        driver.findElement(By.xpath("//button [text()='Confirm']")).click();

      //  driver.findElement(By.xpath("(//button [text()='+'])[2]")).click();

        driver.findElements(By.xpath("//button [text()='+']")).get(1).click();

        driver.findElement(By.xpath("//button [text()='Next']")).click();

        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input [@id = 'first-name-input-0']")));
        element3.sendKeys("Male");

        WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input [@id = 'last-name-input-0']")));
        element4.sendKeys("One");

        WebElement element5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input [@id = 'whatsappNumber-input-0']")));
        element5.sendKeys("222");

        driver.findElement(By.xpath("//button [text()='Proceed To Payment']")).click();

        WebElement element6 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span [text()='This number is associated with a Male account. Please use the correct gender.']")));

        Assert.assertTrue(element6.isDisplayed());
    }

    @Test (enabled = true)
    public void Test_Three () throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='19']")));
        element1.click();

        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input [@type ='radio']")));
        element2.click();

        driver.findElement(By.xpath("//button [text()='Confirm']")).click();

        //  driver.findElement(By.xpath("(//button [text()='+'])[2]")).click();

        driver.findElements(By.xpath("//button [text()='+']")).getFirst().click();

        driver.findElement(By.xpath("//button [text()='Next']")).click();

        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input [@id = 'first-name-input-0']")));
        element3.sendKeys("Female");

        WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input [@id = 'last-name-input-0']")));
        element4.sendKeys("One");

        WebElement element5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input [@id = 'whatsappNumber-input-0']")));
        element5.sendKeys("111");

        driver.findElement(By.xpath("//button [text()='Proceed To Payment']")).click();

        WebElement element6 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span [text()='This number is associated with a Female account. Please use the correct gender.']")));

        Assert.assertTrue(element6.isDisplayed());
    }

    @AfterMethod
    public void PostCondition() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}

package com.spreadsheet123.com;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Header {
    private WebDriver driver;
    @BeforeClass
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

     driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.spreadsheet123.com/");
    }
    @Test
    public void headerAutomatipn() throws InterruptedException {

        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String result = js.executeScript("return document.readyState").toString();
        if (result.equals("complete"))
        {
            Thread.sleep(10000);
            System.out.println("result "+result);
        }

        String[] a= {"HOME","EXCEL TEMPLATES","WORD TEMPLATES","CALCULATORS","CALENDARS","APPS","LEGAL FORMS","BLOG"};
        int l = a.length;
        System.out.println(l);
        for(int j = 0; j<=l; j++)
        {
            a[j]
        }

        List<WebElement> headerElements = driver.findElements(By.xpath("//nav[contains(@class,'header-menu')]"));
        for(int i=0; i<headerElements.size(); i++)
        {
            String element = headerElements.get(i).getText();
            System.out.println(element);
            Assert.assertEquals(element, headerElements.get(i).getText());
        }
    }



    ////a[text()='Sign In Sheets']


    public static void waitForElement(WebDriver driver, By locator)
    {
       try {
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
           wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
           wait.ignoring(NoSuchElementException.class);
       }
       catch(TimeoutException e)
       {
       }
    }

}

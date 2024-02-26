package com.comprrhensiveAssisgnments;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Program5TestNgProgram {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(groups = "newWindow")
    public void testNewTabIsOpened() {
        driver.get("https://autify.com/");
        String parentWindowHandle = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()='Start Free Trial']")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(parentWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        
        String childWindowTitle = driver.getTitle();
        Assert.assertEquals(childWindowTitle, "Expected Child Window Title");
    }

    @Test(groups = "newWindow", dependsOnMethods = "testNewTabIsOpened")
    public void testSignUpErrorMessages() {
        driver.findElement(By.xpath("//button[text()='Sign up']")).click();
        
        Assert.assertTrue(driver.getPageSource().contains("First name can't be blank"));
        Assert.assertTrue(driver.getPageSource().contains("Last name can't be blank"));
        Assert.assertTrue(driver.getPageSource().contains("Company name can't be blank"));
        Assert.assertTrue(driver.getPageSource().contains("Password cannot be blank"));
        Assert.assertTrue(driver.getPageSource().contains("Email can't be blank"));
    }

    @AfterClass
    public void tearDown() {
        
        driver.quit();
    }
}



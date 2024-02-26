package com.comprrhensiveAssisgnments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.util.Set;

public class ProgramThirdSwitchToParentWindow {
    public static void main(String[] args) {
        
        System.setProperty("webdriver.chrome.driver","C:\\Users\\deepa\\Downloads\\chromedriver-win32 (1)\\chromedriver-win32.exe");

       
        WebDriver driver = new ChromeDriver();

        
        driver.get("https://autify.com/");

        
        driver.findElement(By.xpath("//button[text()='Start Free Trial']")).click();

       
        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(driver.getWindowHandle())) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        String childWindowTitle = driver.getTitle();
        System.out.println("Title of the child window: " + childWindowTitle);

        
        driver.close();

        
        driver.switchTo().window((String) windowHandles.toArray()[0]);

        driver.quit();
    }
}

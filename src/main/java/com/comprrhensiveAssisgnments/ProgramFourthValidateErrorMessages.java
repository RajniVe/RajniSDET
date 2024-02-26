package com.comprrhensiveAssisgnments;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class ProgramFourthValidateErrorMessages {
	    public static void main(String[] args) {
	        
	        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

	        
	        WebDriver driver = new ChromeDriver();

	     
	        driver.get("https://autify.com/");

	    
	        WebElement startFreeTrialButton = driver.findElement(By.xpath("//a[contains(text(),'Start Free Trial')]"));
	        startFreeTrialButton.click();

	    
	        for (String windowHandle : driver.getWindowHandles()) {
	            driver.switchTo().window(windowHandle);
	        }
	        WebElement signUpButton = driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));
	        signUpButton.click();

	       
	        WebElement firstNameError = driver.findElement(By.xpath("//div[contains(text(),'First name can’t be blank')]"));
	        WebElement lastNameError = driver.findElement(By.xpath("//div[contains(text(),'Last name can’t be blank')]"));
	        WebElement companyNameError = driver.findElement(By.xpath("//div[contains(text(),'Company name can’t be blank')]"));
	        WebElement passwordError = driver.findElement(By.xpath("//div[contains(text(),'Password cannot be blank')]"));
	        WebElement emailError = driver.findElement(By.xpath("//div[contains(text(),'Email can’t be blank')]"));

	        
	        boolean allErrorsDisplayed = firstNameError.isDisplayed() &&
	                lastNameError.isDisplayed() &&
	                companyNameError.isDisplayed() &&
	                passwordError.isDisplayed() &&
	                emailError.isDisplayed();

	        if (allErrorsDisplayed) {
	            System.out.println("All error messages are displayed successfully.");
	        } else {
	            System.out.println("Error: Some error messages are missing.");
	        }

	        driver.quit();
	    }

}

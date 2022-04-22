import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class TestCase3 {
	
	
	
	public void EnterData(WebElement element, String Data) throws InterruptedException {
		try {
			element.clear();
			element.sendKeys(Data);
		} catch (Exception e) {
			
			element.clear();
			element.sendKeys(Data);
		}
	}
	
	

	public static void main(String[] args) throws InterruptedException  {
		

	
	 
     // browser type and chromedrover.exe path as parameters
     System.setProperty("webdriver.chrome.driver","C:\\Users\\MU20084746\\Downloads\\chromedriver_win32\\chromedriver.exe");
     
     WebDriver driver = new ChromeDriver();
     String URL = "C:\\Users\\MU20084746\\Downloads\\AutomationChallengeIDC\\index.html";
     driver.get(URL);
     driver.manage().window().maximize(); 
     
     driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
     JavascriptExecutor js = (JavascriptExecutor) driver;
   
     Thread.sleep(2000);
     
     boolean TestResult= false;
		TestCase3 Testcase=new TestCase3();
		//Testcase.LaunchTest();
		
		java.util.List <WebElement> SearchField= driver.findElements(By.id("searchMe")); 
		Testcase.EnterData(SearchField.get(0), "USA");
		
	//	js.executeScript("arguments[0].scrollIntoView(true);", SearchField);
		
		java.util.List <WebElement> Table= driver.findElements(By.xpath("//tbody//tr"));
		int count=0;
		for (WebElement element: Table) { 
			if(element.isDisplayed()) {
				count++;
			}
		
		} 
		
		if(count==2) {
			System.out.println("Only 2 rows is displayed - Passed");
			TestResult=true;
		}
		else {
			System.out.println("More than 2 rows is displayed - failed");
			TestResult=false;
		}
		
		
		SearchField.get(0).clear();
		SearchField.get(0).sendKeys(Keys.ENTER);
		SearchField.get(0).click();
		
		count=0;
		
		for (WebElement element: Table) { 
			if(element.isDisplayed()) {
				count++;
			}
		
		}
		
		
		if(count==4) {
			System.out.println("Only 4 rows is displayed - Passed");
			TestResult=true;
		}
		else {
			System.out.println("Less than 4 rows is displayed - failed");
			TestResult=false;
		}
		
		
		if(TestResult) {
			System.out.println("Test Case 1 - Passed");
			
		}
		else
			System.out.println("Test Case 1 - failed");
		
		System.out.println("Process done");
    
     System.out.println("Deleting COOKIES");
     
     driver.manage().deleteAllCookies(); 
     
     driver.quit();
	}
}



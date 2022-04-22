import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.util.concurrent.TimeUnit;


public class TestCase2 {
	
	
	
	public void EnterData(WebElement element, String Data) throws InterruptedException {
		try {
			element.clear();
			element.sendKeys(Data);
		} catch (Exception e) {
			
			element.clear();
			element.sendKeys(Data);
		}
	}
	
	

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException  {
		

	
	 
     // browser type and chromedrover.exe path as parameters
     System.setProperty("webdriver.chrome.driver","C:\\Users\\MU20084746\\Downloads\\chromedriver_win32\\chromedriver.exe");
     
     WebDriver driver = new ChromeDriver();
     String URL = "C:\\Users\\MU20084746\\Downloads\\AutomationChallengeIDC\\index.html";
     driver.get(URL);
     driver.manage().window().maximize(); 
     
     driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
     
     Thread.sleep(2000);
     
     boolean TestResult= false;
		TestCase2 Testcase=new TestCase2();
		//Testcase.LaunchTest();
		
		java.util.List <WebElement> ClickMe= driver.findElements(By.xpath("//button[contains(text(),'Click Me')]")); 
		ClickMe.get(0).click();
		
		WebElement Dropdown= driver.findElement(By.xpath("//input[@id='myInput']/parent::ul")); 
		
		java.util.List <WebElement> Lists= driver.findElements(By.xpath("//input[@id='myInput']/following::li")); 
		
		ArrayList originalList = new ArrayList();
		
		java.util.List<WebElement> lists = Dropdown.findElements (By.xpath("//input[@id='myInput']/following::li")); 
		
		for (WebElement element: lists) { 
			String var2 = element.getText ();
			originalList.add(element.getText());
			System.out.println (var2); 
		
		} 
	
		System.out.println("originalList:" + originalList);
		 
		if(originalList.contains("Angular") && originalList.contains("Angular 2")) {
			 TestResult=true;
		 }
		
		
		
		
		java.util.List <WebElement> SearchText= driver.findElements(By.id("myInput")); 
		Testcase.EnterData(SearchText.get(0), "ReactJs");
		
		
		java.util.List <WebElement> Dropdownelements= driver.findElements(By.xpath("//li[@style='display: none;']"));
		
		//Check for dropdown elements not displayed and also there is no ReactJs in the dropdownelements
		if(Dropdownelements.size()!=0 && !originalList.contains("ReactJs")) {
			TestResult=true; 
		}
		else
			TestResult=false;
				
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



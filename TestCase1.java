import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class TestCase1 {
	
	
	
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
     
     Thread.sleep(2000);
     
     boolean TestResult= false;
		TestCase1 Testcase=new TestCase1();
		//Testcase.LaunchTest();
		
		java.util.List <WebElement> Modal= driver.findElements(By.xpath("//button[@data-target='#myModal']")); 
		Modal.get(0).click();
		java.util.List <WebElement> Name= driver.findElements(By.id("name")); 
		Scanner input1= new Scanner(System.in); //System.in is a standard input stream.
		System.out.print("Enter Name: ");
		String inputname= input1.nextLine();
		
		Testcase.EnterData(Name.get(0), inputname);
		
		
		java.util.List <WebElement> City= driver.findElements(By.id("city")); 
		
		Scanner input2= new Scanner(System.in); //System.in is a standard input stream.
		System.out.print("Enter City: ");
		String inputCity= input2.nextLine();
		
		Testcase.EnterData(City.get(0), inputCity);
		
		java.util.List <WebElement> Enter= driver.findElements(By.id("enter")); 
		Enter.get(0).click();
		
		WebElement Close= driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
		System.out.println("Clicking Close Button");
		Close.click();
		
		java.util.List <WebElement> NameText= driver.findElements(By.id("nameVal")); 
		java.util.List <WebElement> CityText= driver.findElements(By.id("cityVal")); 
		
		String ActualName = NameText.get(0).getText();
		String AcualText = CityText.get(0).getText();
		
		if(ActualName.contains(inputname) && AcualText.contains(inputCity)){
			System.out.println("Entered Name and City is updated");
			TestResult=true;
		}
		else {
			System.out.println("Entered Name and City is not updated");
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



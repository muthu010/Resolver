import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.interactions.Actions;


public class TestCase4 {
	

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
    // JavascriptExecutor js = (JavascriptExecutor) driver;
   
     Thread.sleep(2000);
     
    
     
     boolean TestResult= false;
		
		
		WebElement DraggableButton= driver.findElement(By.xpath("//button[@id='drag1']")); 
		DraggableButton.click();
		WebElement DragArea= driver.findElement(By.xpath("//div[@id='div1']")); 
		Point point = DragArea.getLocation();
		int xcord = point.getX();
		int ycord = point.getY();
		
		System.out.println(xcord + ycord);
		
		
		Actions builder = new Actions(driver);
	
		builder.clickAndHold(DraggableButton).moveToElement(DragArea).release().build().perform();
		       
		
	   Thread.sleep(10000);
	   java.util.List <WebElement> Dragged= driver.findElements(By.xpath("//button[@id='drag1']/following::br"));
	    if(Dragged.size()!=0 && Dragged.get(0).isDisplayed()) {
	    	System.out.println("Item is dropped in the target");
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



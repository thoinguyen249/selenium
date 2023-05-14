package sel01;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExcutorDemo {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		driver.manage().window().maximize();
		
		JavascriptExecutor jsExcutor = (JavascriptExecutor) driver;
		String script = "return document.title;";
		
		jsExcutor.executeScript(script);
		String title = (String) jsExcutor.executeScript(script);
		System.out.println(title);
		
		// click button
		driver.switchTo().frame("iframeResult");
		jsExcutor.executeScript("myFunction()");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		WebElement buttonElement = driver.findElement(By.xpath("/html/body/button"));
		jsExcutor.executeScript("arguments[0].style.border='3px solid red'", buttonElement);
		
		//scroll
		driver.navigate().to("https://www.w3schools.com/");
		WebElement bottomBtn = driver.findElement(By.xpath("//*[@id=\"footer\"]/div[2]/div[1]/a"));
		jsExcutor.executeScript("arguments[0].scrollIntoView(true);", bottomBtn);
		
		Thread.sleep(3000);
		driver.quit();

	}

}

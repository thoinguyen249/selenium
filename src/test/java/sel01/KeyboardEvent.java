package sel01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardEvent {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://extendsclass.com/text-compare.html");
		driver.manage().window().maximize();

		WebElement sourceTextArea = driver.findElement(
				By.xpath("//*[@id=\"dropZone\"]/div[2]/div/div[6]/div[1]/div/div/div/div[5]/div[9]/pre/span"));
		Actions actions = new Actions(driver);

		Thread.sleep(3000);
		actions.keyDown(sourceTextArea, Keys.COMMAND).sendKeys("a").sendKeys("c").build().perform();
		Thread.sleep(3000);

		WebElement targetArea = driver.findElement(
				By.xpath("//*[@id=\"dropZone2\"]/div[2]/div/div[6]/div[1]/div/div/div/div[5]/div[1]/pre/span"));
//		targetArea.click();
		actions.keyDown(targetArea, Keys.COMMAND).sendKeys("a").sendKeys("v").build().perform();

		Thread.sleep(10000);
		driver.quit();

	}

}

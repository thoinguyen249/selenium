package sel01;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www2.asx.com.au/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"pnProductNavContents\"]/h5[2]")).click();

		// get the number of row
		List<WebElement> rowElement = driver
				.findElements(By.xpath("//*[@id=\"home_top_five\"]/div/div[1]/div/div[1]/table/tr"));
		int rowSize = rowElement.size();
		System.out.println("Number of row: " + rowSize);
		List<WebElement> colElement = driver
				.findElements(By.xpath("//*[@id=\"home_top_five\"]/div/div[1]/div/div[1]/table/tr[2]/td"));
		int colSize = colElement.size();
		System.out.println("Number of col: " + colSize);

		for (int i = 2; i <= rowSize; i++) {
			for (int j = 2; j <= colSize; j++) {
			 String getTextElement = driver.findElement(By.xpath(
						"//*[@id=\"home_top_five\"]/div/div[1]/div/div[1]/table/tr["+i+"]/td["+j+"]"))
						.getText();
			 System.out.println(getTextElement);
			}
			System.out.println();
		}

		// get the number of columns
		// iterate rows and columns and get text and print it

		Thread.sleep(2000);
		driver.quit();

	}

}

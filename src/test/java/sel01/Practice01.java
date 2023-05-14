package sel01;


import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice01 {
 public static void main(String[] args) {
	 WebDriverManager.chromedriver().setup();
	 ChromeDriver driver = new ChromeDriver();
	 driver.get("https://et.urbn8.io/");
	 driver.manage().window().maximize();
	 
	System.out.println("Hello world");
}

}

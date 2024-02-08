package task20;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q1_Task20 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Launch the Chrome browser
		WebDriver driver = new ChromeDriver();

		// Load the URL using get method
		driver.get(" https://jqueryui.com/datepicker/");

		// Implicit wait for the element of the page to click them
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Maximise the browser view
		driver.manage().window().maximize();

		// Switching to frame to locate the elements inside the frame
		driver.switchTo().frame(0);

		// Click the next button to move to next month
		driver.findElement(By.id("datepicker")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@title='Next']")).click();

		// Access cell data from the Date picker table using X-path
		Thread.sleep(1000);
		driver.findElement(By.xpath("((//table)[1]//tr//a[text()='2'])")).click();

		// Get the date value form the input text field using getAttribute and printing
		// in console
		WebElement dateEle = driver.findElement(By.id("datepicker"));
		String date = dateEle.getAttribute("value");
		System.out.println("The selected date and month is: " + date);

		// Closing the browser and quitting webDriver instance
		driver.close();

		// Quitting is not performed as the there is only one tab in the browser
		// driver.quit();

	}

}

package task20;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Q2_Task20 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Launch the Chrome browser
		WebDriver driver = new ChromeDriver();

		// Load the URL using get method
		driver.get("https://www.guvi.in/");

		// Implicit wait for the element of the page to click them
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Maximise the browser view
		driver.manage().window().maximize();

		// Click the Sign up button on the top right corner
		driver.findElement(By.xpath("(//a[text()='Sign up'])[1]")).click();

		// Filling all the details for Sing up form.
		driver.findElement(By.id("name")).sendKeys("Dan Dan");
		driver.findElement(By.id("email")).sendKeys("Daandan41@gmail.com");
		driver.findElement(By.cssSelector("input#password")).sendKeys("DanDaan73");
		driver.findElement(By.xpath("//input[@id='mobileNumber']")).sendKeys("9937849931");

		List<WebElement> buttons = driver.findElements(By.tagName("a"));

		for (WebElement button : buttons) {
			if (button.getAttribute("id").equals("signup-btn")) {
				button.click();
			}
		}

		// Click the may be later button to proceed to Email verification screen
		driver.findElement(By.xpath("//a[text()='May be later']")).click();

		// Validate the page is navigated to Email verification screen
		String verifyText = driver.findElement(By.xpath("//h1[text()='Almost Done! Check Your Inbox!']")).getText();

		if (verifyText.equals("Almost Done! Check Your Inbox!")) {
			System.out.println("The page is navigated to Email verification screen successfully!!");
		} else {
			System.out.println("The page navigation to Email verification screen failed");
		}

		// Navigate back to the previous screen to start the Login process
		driver.navigate().back();

		// Using Explicit wait for the Login button to be interactable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Login'])[1]")));

		// Filling all the details for Login form.
		driver.findElement(By.xpath("(//a[text()='Login'])[1]")).click();
		driver.findElement(By.id("email")).sendKeys("Maginthanofficial1@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Happy@1415");
		driver.findElement(By.xpath("(//a[text()='Login'])[1]")).click();

		// Using Explicit wait for the Course page to be changed as title name
		WebDriverWait titleWait = new WebDriverWait(driver, Duration.ofSeconds(3));
		titleWait.until(ExpectedConditions.titleContains("GUVI | courses"));

		// Validating the user login is successful
		String title = driver.getTitle();
		System.out.println("**************************************************************");
		System.out.println(title);

		if (title.equals("GUVI | courses")) {
			System.out.println("The user logged in successfully");
		} else {
			System.out.println("The user login was not successful");
		}

		// Closing the browser
		driver.close();
	}

}

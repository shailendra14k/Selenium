package selenium;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Tests that Selenium can run on Chrome.
 */
public class BrowserTest
{
	// ----------------------------------------------------------------------------------------------------------------
	// fields
	// ----------------------------------------------------------------------------------------------------------------
	
	private WebDriver driver;
	
	private WebDriverWait wait;
	
	// ----------------------------------------------------------------------------------------------------------------
	// JUnit methods
	// ----------------------------------------------------------------------------------------------------------------
	
	@Before
	public void setUp()
	{
		
		//System.setProperty("webdriver.gecko.driver", "/Users/shsingh/Documents/Software/Selenium/geckodriver");
		
		FirefoxOptions options = new FirefoxOptions()
			.setHeadless(true);
		
		driver = new FirefoxDriver(options);
		 wait = new WebDriverWait(driver, 10);
		
	}
	
	@After
	public void tearDown()
	{
		driver.close();
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// tests
	// ----------------------------------------------------------------------------------------------------------------
	
	@Test
	public void canDuck()
	{
		driver.get("https://google.com/ncr");
        driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
        WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3>div")));
		assertThat(firstResult.getAttribute("textContent"), containsString("Show more"));
	}
}
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class SeleniumIframes {
	private WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
	}

	
	@After
	public void tearDown() {
		this.driver.manage().deleteAllCookies();
		this.driver.quit();
		this.driver = null;
	}
	
	@Test
	public void iframesTest(){
		this.driver.get("http://jqueryui.com/droppable/");
		this.driver.switchTo().frame(this.driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		Actions a = new Actions(this.driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();

		this.driver.switchTo().defaultContent();
	}
}

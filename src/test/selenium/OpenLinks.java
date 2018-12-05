import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class OpenLinks {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
         WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);

        driver.get("http://qaclickacademy.com/practice.php");
        System.out.println(driver.findElements(By.tagName("a")).size());
        WebElement footerDriver=driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        WebElement columnDriver=footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columnDriver.findElements(By.tagName("a")).size());

        for(int i=1;i<columnDriver.findElements(By.tagName("a")).size();i++)
        {

            String clickonlinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);

            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
            Thread.sleep(5000L);

        }
        Set<String> windowHandles=driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            System.out.println(driver.getTitle());
        }
    }
}

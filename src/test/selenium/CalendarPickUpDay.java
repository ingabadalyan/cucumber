import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalendarPickUpDay {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);

        driver.get("http://path2usa.com/travel-companions");

        driver.findElement(By.xpath(".//*[@id='travel_date']")).click();
        driver.findElement(By.className("class=[datepicker-days][class='datepicker-switch']"));

        // Pick up July 15 from the calendar

        List<WebElement> listOfDays = driver.findElements(By.cssSelector(".day"));
        for (WebElement listOfDay : listOfDays) {

            String text = listOfDay.getText();
            if (text.equalsIgnoreCase("15")) {
                listOfDay.click();
                break;
            }
        }
    }
}

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class TestMainClass {
    private WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\viktor.nenashev\\WebDrivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver();
    }
    @Test
    public void playAndPlug() {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.get("https://datatables.net/examples/server_side/row_details.html");

        WebElement tableExamples = driver.findElement(By.id("example"));

        List<WebElement> tableRows = tableExamples.findElements(By.cssSelector("tbody > tr[role='row']"));

        Assert.assertEquals(10, tableRows.size());

        Select select = new Select(driver.findElement(By.name("example_length")));
        select.selectByValue("25");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tableRows = tableExamples.findElements(By.cssSelector("tbody > tr[role='row']"));
        Assert.assertEquals(25, tableRows.size());


    }
    @After
    public void setDown() {
        driver.quit();
    }
}

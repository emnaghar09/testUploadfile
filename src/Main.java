import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://wetransfer.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.className("fides-accept-all-button")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.className("transfer__button")).click();
        WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file' and @data-testid='file-input']")));
        fileInput.sendKeys("C:\\Users\\User\\OneDrive\\Pictures\\Captures d’écran\\seif.PNG");
        WebElement autosuggest = wait.until(ExpectedConditions.elementToBeClickable(By.id("autosuggest")));
        autosuggest.sendKeys("emna.ghariani09@gmail.com");
        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
        email.sendKeys("emna.ghariani09@gmail.com");
        WebElement message = wait.until(ExpectedConditions.elementToBeClickable(By.id("message")));
        message.sendKeys("test");
    }
}
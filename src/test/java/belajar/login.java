package belajar;
import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class login {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverWait wait;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");
        System.out.println("judul halaman"+" "+driver.getTitle());

        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement invenContainer = driver.findElement(By.id("inventory_container"));
        if (invenContainer.isDisplayed()) {
            System.out.println("Inventory sudah terlihat");
        } else {
            System.out.println("Inventory tidak terlihat");
        }
        driver.quit();
    }
}

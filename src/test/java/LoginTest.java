import  org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;

    @BeforeEach

    public void setUp() {
        // set up the path to the webdriver (e.g. ChromeDriver)
        driver = new ChromeDriver();

    }

    @Test
    public void testLoginPage() {

        // Open a website with a login page (for example, example.com/login)
        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains("https://practicetestautomation.com/practice-test-login"));

        //Verify the page title
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://practicetestautomation.com/practice-test-login/", currentUrl);

        // Find the username, password, and login button by their ID
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("submit"));

        // Enter credentials
        usernameField.sendKeys("student");
        passwordField.sendKeys("Password123");
        loginButton.click();

        // Wait for the page to load (simple sleep method; consider using WebDriverWait for better practice)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify if login was successful by checking if the "Logout" button exists
        WebElement logoutButton = driver.findElement(By.linkText("Log out"));
        Assertions.assertNotNull(logoutButton, "Login failed: Logout button not found");
        }
        @AfterEach
    public void tear() {
        //close the browser after the test
            if (driver != null){
                driver.quit();
            }
        }

    }

